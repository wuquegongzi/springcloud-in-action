package com.iwufang.websocket.controller;

import cn.com.gmmedicare.common.utils.GsonUtils;
import com.iwufang.websocket.model.BaseMessage;
import com.iwufang.websocket.model.ChatMessage;
import com.iwufang.websocket.model.User;
import com.iwufang.websocket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
@Controller
public class ChatController {

	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm");

	@Autowired
	private SimpMessagingTemplate template;

	@Autowired
	private UserService userService;

	/***
	 * 群发
	 * @param principal
	 * @param message
	 */
	@MessageMapping({"/all"})
	public void all(Principal principal, String message) {
		ChatMessage chatMessage = createMessage(principal.getName(), message);
		template.convertAndSend("/topic/notice", GsonUtils.GsonString(chatMessage));
	}

	/**
	 * 点对点
	 * @param principal
	 * @param message
	 */
	@MessageMapping("/chat")
	public void chat(Principal principal, String message) {
		System.out.println(principal.getName()+"来消息啦:"+message);
		BaseMessage baseMessage=GsonUtils.GsonToBean(message, BaseMessage.class);
		baseMessage.setSender(principal.getName());
		this.send(baseMessage);
	}

	private void send(BaseMessage message) {
		message.setDate(new Date());
		ChatMessage chatMessage = createMessage(message.getSender(), message.getContent());
		template.convertAndSendToUser(message.getReceiver(),
				"/topic/chat", GsonUtils.GsonString(chatMessage));
	}

	private ChatMessage createMessage(String userCode, String message) {
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setUserCode(userCode);
		User user = userService.getByUserCode(userCode);
		chatMessage.setClientId(user.getClientId());
		chatMessage.setContent(message);
		chatMessage.setSendTime(simpleDateFormat.format(new Date()));
		return chatMessage;
	}

}
