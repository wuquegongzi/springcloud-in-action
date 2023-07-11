package com.iwufang.websocket.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.security.Principal;
import java.util.Date;
import java.util.Random;

@Data
@NoArgsConstructor
@ToString
public class User implements Principal{


	private String type ="";
	private String token ="";

	// 员工号
	private String userCode ="";

	// clientid
	private String clientId ="";

	// 登录时间
	private Date joinTime = new Date();

	public User(String type, String userCode,String clientId,String token) {
		this.type = type;
		this.userCode = userCode;
		this.clientId = clientId;
		this.token = token;
		this.joinTime = new Date();
	}

	@Override
	public String getName() {
		return this.userCode+"||"+this.clientId;
	}
}
