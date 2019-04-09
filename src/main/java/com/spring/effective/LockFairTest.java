package com.spring.effective;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @date 2019-03-27 15:28
 *     ReentrantLock fairLock = new ReentrantLock(true);
 *     公平锁
 */
public class LockFairTest implements Runnable{
    private static ReentrantLock lock = new ReentrantLock(true);
    public void run(){
        while (true){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"锁获得");

            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        LockFairTest lockFairTest=new LockFairTest();
        Thread th1=new Thread(lockFairTest);
        Thread th2=new Thread(lockFairTest);
        th1.start();
        th2.start();
    }
}
