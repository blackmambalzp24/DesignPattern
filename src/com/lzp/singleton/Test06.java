package com.lzp.singleton;

/**
 * 单例模式，懒汉模式，当获取对象实例时new出对象实例，加同步代码块只能锁住代码块，但是加上双层加锁，线程安全 ,但会每次获取实例都需要拿锁，导致性能降低
 * 
 * @author zhiping.li
 *
 */
public class Test06 {

	private static volatile Test06 instance = null;

	private Test06() {
	}

	public static Test06 getInstance() {
		if (instance == null) {
			/**
			 * * 只加了同步代码块，因此与Test03是一样的，两个线程同时调用方法，线程2先拿到同步代码块锁，
			 * new出一个对象，线程1等线程2释放锁然后继续判断为null，然后继续加锁new出对象，不为null，直接返回
			 */
			synchronized (Test06.class) {
				if (instance == null) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					instance = new Test06();
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 200; i++) {
			new Thread(() -> System.out.println(Test06.getInstance().hashCode())).start();
		}
	}

}
