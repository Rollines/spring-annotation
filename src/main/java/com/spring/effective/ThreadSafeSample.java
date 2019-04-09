package com.spring.effective;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @date 2019-03-27 15:14
 *
 * 你可以编译并执行，可以看到，仅仅是两个线程的低度并发，
 * 就非常容易碰到former和latter不相等的情况。这是因为，在两次取值的过程中，其他线程可能已经修改
 * 了sharedState。
 */
public class ThreadSafeSample {
    public int sharedState;
    public void nonSafeAction() {
        while (sharedState < 100000) {
            int former = sharedState++;
            int latter = sharedState;
            if (former != latter - 1) {
                System.out.printf("Observed data race, former is " +
                        former + ", " + "latter is " + latter);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ThreadSafeSample sample = new ThreadSafeSample();
        Thread threadA = new Thread(){
            public void run(){
                sample.nonSafeAction();
            }
        };
        Thread threadB = new Thread(){
            public void run(){
                sample.nonSafeAction();
            }
        };
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
    }
}
