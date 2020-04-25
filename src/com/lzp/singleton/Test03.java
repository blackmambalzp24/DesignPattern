package com.lzp.singleton;

/**
 * 单例模式，懒汉模式，当获取对象实例时new出对象实例，线程不安全
 * 
 * @author zhiping.li
 *
 */
public class Test03 {

	private static Test03 instance = null;

	private Test03() {
	}

	public static Test03 getInstance() {
		if (instance == null) {// 当线程1进来判断为null时，准备new，还未创建实例，
								// 另外一个线程2来了，并更快的创建出实例，线程1和线程分别创建了两个不同的实例
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Test03();
		}
		return instance;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(() -> System.out.println(Test03.getInstance().hashCode())).start();
		}
	}

}
