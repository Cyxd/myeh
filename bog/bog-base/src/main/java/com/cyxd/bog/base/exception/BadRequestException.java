package com.cyxd.bog.base.exception;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.bog.base.exception.BadRequestException
 * <li>ClassName: BadRequestException
 * <li>CreateDateTime: 2016年11月22日 上午10:36:18
 *
 * <p>
 * Description:应对400错误请求异常
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see
 * @see
 *
 */
public class BadRequestException extends RuntimeException {

    /**
     * long serialVersionUID is
     */
    private static final long serialVersionUID = -6531576081264660182L;

    public BadRequestException(String msg) {
	super(msg);
    }

}
