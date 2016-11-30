package com.cyxd.demo.patterns.create;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.demo.patterns.create.Single
 * <li>ClassName: Single
 * <li>CreateDateTime: 2016年11月22日 下午5:38:24
 *
 * <p>
 * Description:单例模式测试类
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see
 * @see
 *
 */
public class Single {

}

class ChineseWife {

    private static ChineseWife cwInstance = new ChineseWife();

    public static ChineseWife newInstance() {
	return cwInstance;
    }

}

class Moon{
    
}

class Sun{
    
}
