package com.cyxd.bog.base.exception;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.bog.base.exception.UnknownResourceException
 * <li>ClassName: UnknownResourceException
 * <li>CreateDateTime: 2016年11月22日 上午10:36:40
 *
 * <p>
 * Description:Simulated business-logic exception indicating a desired business
 * entity or record cannot be found.
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see
 * @see
 *
 */
public class UnknownResourceException extends RuntimeException {

    /**
     * long serialVersionUID is
     */
    private static final long serialVersionUID = 8652981634650232681L;

    public UnknownResourceException(String msg) {
	super(msg);
    }
}
