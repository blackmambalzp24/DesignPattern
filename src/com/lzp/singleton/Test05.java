package com.lzp.singleton;

/**
 * 单例模式，懒汉模式，当获取对象实例时new出对象实例，加同步代码块只能锁住代码块，线程不安全 ,但会每次获取实例都需要拿锁，导致性能降低
 * 
 * @author zhiping.li
 *
 */
public class Test05 {

	private static Test05 instance = null;

	private Test05() {
	}

	public static Test05 getInstance() {
		if (instance == null) {
			/**
			 * * 只加了同步代码块，因此与Test03是一样的，两个线程同时调用方法，线程2先拿到同步代码块锁，
			 * new出一个对象，线程1等线程2释放锁然后又new出一个对象，两个线程获取的示例不一样
			 */
			synchronized (Test05.class) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				instance = new Test05();
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 200; i++) {
			new Thread(() -> System.out.println(Test05.getInstance().hashCode())).start();
		}
	}

}
