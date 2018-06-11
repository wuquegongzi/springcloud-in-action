package com.iwufang.websocket.service;

import com.iwufang.websocket.model.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

	private final ConcurrentHashMap<String, User> users;
	private final ConcurrentHashMap<String, Integer> counts;

	public UserService() {
		users = new ConcurrentHashMap<>();
		counts = new ConcurrentHashMap<>();
	}

	public boolean addUser(User user) {
		String key = user.getUserCode()+"||"+user.getClientId();
		int count =0;

		boolean isExist = users.containsKey(key);

		if (isExist) {
			count = counts.get(key);
			counts.put(key,count++);
			return false;
		}
		users.put(key, user);
		counts.put(key,count++);
		System.out.println("当前在线个数："+users.size());
		return true;
	}

	public boolean deleteUser(User user) {
		String key = user.getUserCode()+"||"+user.getClientId();
		boolean isExist = users.containsKey(key);
		if (!isExist) {
			return false;
		}
		int count = counts.get(key);
		count--;

		if(count ==0){
			users.remove(user.getUserCode()+"||"+user.getClientId());
		}

		System.out.println("当前在线个数："+users.size());
		return true;
	}

	public User getByUserCode(String userCode) {
		return users.get(userCode);
	}

}
