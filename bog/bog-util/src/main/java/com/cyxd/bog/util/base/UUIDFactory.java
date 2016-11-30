package com.cyxd.bog.util.base;

import java.util.UUID;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.bog.util.base.UUIDFactory
 * <li>ClassName: UUIDFactory
 * <li>CreateDateTime: 2016年10月13日 下午2:36:10
 *
 * <p>
 * Description:UUIDFactory
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see UUID
 * @see UUID#randomUUID()
 *
 */
public class UUIDFactory {

    /**
     * <p>
     * generate<br>
     * Description:产生32位UUID
     *
     * @author Slil
     * @version 1.0.0
     * @since 1.0.0
     * 
     * @return
     * 
     * @see UUID
     * @see UUID#randomUUID()
     *
     */
    public static String generate() {
	return UUID.randomUUID().toString().replace("-", "");
    }

}
