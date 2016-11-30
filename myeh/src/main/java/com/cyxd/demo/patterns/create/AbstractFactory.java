package com.cyxd.demo.patterns.create;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.demo.patterns.create.AbstractFactory
 * <li>ClassName: AbstractFactory
 * <li>CreateDateTime: 2016年11月22日 下午5:24:48
 *
 * <p>
 * Description:抽象工厂测试类
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see Car
 * @see BMW
 * @see BYD
 * @see AFactory
 * @see BMWFactory
 * @see BYDFactory
 *
 */
public class AbstractFactory {
    
    public static void main(String[] args) {
	
	System.out.println("Abstract Method --> Begin");
	AFactory af1 = new BMWFactory();
	Car bmw1 = af1.buildCar();
	bmw1.run();
	AFactory af2 = new BYDFactory();
	Car byd1 = af2.buildCar();
	byd1.run();
	System.out.println("Abstract Method --> End");
	
    }

}

/**
 * <p>
 * <li>ClassFullName: com.cyxd.demo.patterns.create.AFactory
 * <li>ClassName: AFactory
 * <li>CreateDateTime: 2016年11月22日 下午5:34:47
 *
 * <p>
 * Description:抽象工厂
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see BMWFactory
 * @see BYDFactory
 *
 */
interface AFactory{
    Car buildCar();
}

/**
 * <p>
 * <li>ClassFullName: com.cyxd.demo.patterns.create.BMWFactory
 * <li>ClassName: BMWFactory
 * <li>CreateDateTime: 2016年11月22日 下午5:35:22
 *
 * <p>
 * Description:“BMW”汽车工厂
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 */
class BMWFactory implements AFactory{
    @Override
    public Car buildCar() {
	return new BMW();
    }
}

/**
 * <p>
 * <li>ClassFullName: com.cyxd.demo.patterns.create.BYDFactory
 * <li>ClassName: BYDFactory
 * <li>CreateDateTime: 2016年11月22日 下午5:35:40
 *
 * <p>
 * Description:“BYD”汽车工厂
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 */
class BYDFactory implements AFactory{
    @Override
    public Car buildCar() {
	return new BYD();
    }
}

