package com.lzp.observer.v1;

/**
 * @Author: lzp
 * @Date: 2020-06-21 12:54
 * @Description: DesignPattern/com.lzp.observer.v1
 * @Version :1.0
 */
/**
 * 面向对象的傻等
 */

class Child {
    private boolean cry = false;

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        System.out.println("Waked Up! Crying wuwuwuwu...");
        cry = true;
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                child.wakeUp();
            }
        }).start();
        while(!child.isCry()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("observing...");
        }

    }
}
