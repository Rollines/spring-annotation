package com.spring.effective;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @date 2019-03-25 17:13
 */
public class VolitailTest {
    private static volatile int i;
    private static int j;

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                i = 0;
                i = 10;
            }
        };
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                j = i;
                System.out.println(j);
            }
        };
        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable1);
        thread.start();
        thread1.start();

    }
}
