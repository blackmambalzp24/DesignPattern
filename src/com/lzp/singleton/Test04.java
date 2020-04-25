package com.lzp.singleton;

/**
 * 单例模式，懒汉模式，当获取对象实例时new出对象实例，方法加同步锁，线程安全,但会每次获取实例都需要拿锁，导致性能降低
 * 
 * @author zhiping.li
 *
 */
public class Test04 {

	private static Test04 instance = null;

	private Test04() {
	}

	public static synchronized Test04 getInstance() {
		if (instance == null) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Test04();
		}
		return instance;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(() -> System.out.println(Test04.getInstance().hashCode())).start();
		}
	}

}
