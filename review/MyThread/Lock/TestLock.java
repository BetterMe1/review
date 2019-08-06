package exercise.review.MyThread.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task,"线程1");
        Thread thread1 = new Thread(task,"线程2");
        thread.start();
        thread1.start();
    }
}

class Task implements Runnable{
    private int ticket = 200;
    private Lock ticketLock = new ReentrantLock();

    @Override
    public void run() {
        for(int i=0; i<200; i++){
            //对程序上锁
            try{
                ticketLock.lock();//上锁，等同于synchronized(this)
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"还剩下："+ticket--+"票");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                ticketLock.unlock();//解锁
            }
        }
    }
}