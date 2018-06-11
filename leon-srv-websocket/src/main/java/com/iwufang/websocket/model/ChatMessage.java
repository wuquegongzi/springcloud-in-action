package com.iwufang.websocket.model;

import lombok.Data;

@Data
public class ChatMessage {

  private String userCode;

  private String userName;

  private String clientId;

  private String content;

  private String sendTime;

}
