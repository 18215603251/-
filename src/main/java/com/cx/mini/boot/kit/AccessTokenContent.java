package com.cx.mini.boot.kit;

public class AccessTokenContent {
	private static String access_token;

	public static String getAccess_token() {
		return access_token;
	}

	public static void setAccess_token(String access_token) {
		AccessTokenContent.access_token = access_token;
	}

}
