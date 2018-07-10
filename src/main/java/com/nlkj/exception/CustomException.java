/**
 * 
 */
package com.nlkj.exception;

/**
 * @author 石凯强
 *
 * @date 2018年7月5日
 */
public class CustomException extends Throwable{

	public CustomException() {
		super();
	}

	public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomException(String msg) {
		super(msg);
	}

	public CustomException(Throwable cause) {
		super(cause);
	}
	

}
