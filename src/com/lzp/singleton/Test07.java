package com.lzp.singleton;

/**
 * 单例模式，懒汉模式，当获取对象实例时new出对象实例，使用静态内部类，当类加载时，类中的内部类并没有加载到内存
 * 等获取示例的时候，直接加载内部类new出对象示例，相当于饿汉模式+懒汉模式的结合
 * 
 * @author zhiping.li
 *
 */
public class Test07 {

	private Test07() {
	}

	private static class InnerClass {
		private static final Test07 INSTANCE = new Test07();
	}

	public static Test07 getInstance() {
		return InnerClass.INSTANCE;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 200; i++) {
			new Thread(() -> System.out.println(Test07.getInstance().hashCode())).start();
		}
	}

}
