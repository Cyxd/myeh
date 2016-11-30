package com.cyxd.demo.exception.runtime;

/**
 * @author cyxd
 *
 */
public class ServiceTxErrorRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceTxErrorRuntimeException() {
		super();
	}

	public ServiceTxErrorRuntimeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceTxErrorRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceTxErrorRuntimeException(String message) {
		super(message);
	}

	public ServiceTxErrorRuntimeException(Throwable cause) {
		super(cause);
	}

}
