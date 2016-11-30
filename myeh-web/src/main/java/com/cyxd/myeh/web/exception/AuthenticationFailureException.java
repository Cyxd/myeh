package com.cyxd.myeh.web.exception;

/**
 * 自定义异常，权限验证失败时使用
 * 
 * @author cyxd
 *
 */
public class AuthenticationFailureException extends RuntimeException {

	private static final long serialVersionUID = 991512083751505645L;

	public AuthenticationFailureException(String message) {
		super(message);
	}

}
