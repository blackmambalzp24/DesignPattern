package com.lzp.singleton;

/**
 * 单例模式，饿汉模式，类加载时将new出对象(通过静态块)，线程安全
 * 
 * @author zhiping.li
 *
 */
public class Test02 {

	private static final Test02 instance;

	private Test02() {
	}

	static {
		instance = new Test02();
	}

	public static Test02 getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(() -> System.out.println(Test02.getInstance().hashCode())).start();
		}
	}

}
