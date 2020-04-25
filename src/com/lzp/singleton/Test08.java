package com.lzp.singleton;

/**
 * 枚举单例，不仅可以保持线程同步安全，还可以防止反序列化
 * @author zhiping.li
 *
 */
public enum Test08 {

	INSTANCE;
	
	public void test() {}

	public static void main(String[] args) {
		for (int i = 0; i < 200; i++) {
			
			new Thread(() -> System.out.println(Test08.INSTANCE.hashCode()) ).start();
		}
	}

}
