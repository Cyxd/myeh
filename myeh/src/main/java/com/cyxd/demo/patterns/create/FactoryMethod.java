package com.cyxd.demo.patterns.create;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.demo.patterns.create.FactoryMethod
 * <li>ClassName: FactoryMethod
 * <li>CreateDateTime: 2016年11月22日 下午5:23:43
 *
 * <p>
 * Description:工厂方法测试类
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see Car
 * @see BMW
 * @see BYD
 * @see Factory
 *
 */
public class FactoryMethod {
    
    public static void main(String[] args) {
	Factory factory = new Factory();
	System.out.println("Factory Method --> Begin");
	System.out.println("Simple Factory Method -->");
	Car bmw1 = factory.buildCarByName("bmw");
	bmw1.run();
	Car byd1 = factory.buildCarByName("byd");
	byd1.run();
	
	System.out.println("Normal Factory Method -->");
	Car bmw2 = factory.buildCarBMW();
	bmw2.run();
	Car byd2 = factory.buildCarBYD();
	byd2.run();
	
	System.out.println("Static Factory Method -->");
	Car bmw3 = Factory.buildCarBMWStatic();
	bmw3.run();
	Car byd3 = Factory.buildCarBYDStatic();
	byd3.run();
	System.out.println("Factory Method --> End");
    }

}


/**
 * Factory Method Pattern
 * */

interface Car{
    void run();
}
class BMW implements Car{
    @Override
    public void run() {
	System.out.println(this.getClass().getName() + "-->run");
    }
}
class BYD implements Car{
    @Override
    public void run() {
	System.out.println(this.getClass().getName() + "-->run");
    }
}

/**
 * <p>
 * <li>ClassFullName: com.cyxd.demo.patterns.create.Factory
 * <li>ClassName: Factory
 * <li>CreateDateTime: 2016年11月22日 下午5:09:00
 *
 * <p>
 * Description:工厂类，使用其中的方法来产生对象<br>
 * 【分别对应简单工厂方法、普通工厂方法、静态工厂方法】<br>
 * <ul>
 * 	<li>Factory{@link #buildCarByName(String)} -> 根据标志来产生“Car”子类</li>
 * 	<li>Factory{@link #buildCarBMW()}{@link #buildCarBYD()} ->调用具体方法产生具体“Car”子类</li>
 * 	<li>Factory{@link #buildCarBMWStatic()}{@link #buildCarBYDStatic()} ->调用具体静态方法产生具体“Car”子类</li>
 * </ul>
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see Factory#buildCarByName(String)
 * @see Factory#buildCarBMW()
 * @see Factory#buildCarBYD()
 * @see Factory#buildCarBMWStatic()
 * @see Factory#buildCarBYDStatic()
 *
 */
class Factory{
    public Car buildCarByName(String carName){
	if("bmw".equalsIgnoreCase(carName))
	    return new BMW();
	if("byd".equalsIgnoreCase(carName))
	    return new BYD();
	return null;
    }
    
    public Car buildCarBMW(){
	return new BMW();
    }
    public Car buildCarBYD(){
	return new BYD();
    }
    
    public static Car buildCarBMWStatic(){
	return new BMW();
    }
    public static Car buildCarBYDStatic(){
	return new BYD();
    }
    
}

 
