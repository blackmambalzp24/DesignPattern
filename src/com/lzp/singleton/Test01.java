package com.lzp.singleton;

/**
 * 单例模式，饿汉模式，类加载时将new出对象，线程安全 构造函数private，除了这个类别的地方new不出来这个对象
 * 
 * @author zhiping.li
 *
 */
public class Test01 {

	private static final Test01 instance = new Test01();

	private Test01() {
	}

	public static Test01 getInstance() {
		return instance;
	}

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {

           //  labmada表达式写法		{}中是线程run方法中具体的执行逻辑，如果只有一句话，可以不用大括号	
			 new Thread(() ->{System.out.println("test01"); System.out.println(Test01.getInstance().hashCode());}).start();
			new Thread(() -> System.out.println(Test01.getInstance().hashCode())).start();
		}
	}

}
