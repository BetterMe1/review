package exercise.review.MyThread.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestTryLock {
    public static void main(String[] args) {
        TaskTime taskTime = new TaskTime();
        Thread thread = new Thread(taskTime,"线程A");
        Thread thread2 = new Thread(taskTime,"线程B");
        thread.start();
        thread2.start();
    }
}

class TaskTime implements Runnable{

    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        testA();
    }
    public void testA(){
        boolean flag = false;
        try {
            flag = lock.tryLock(1, TimeUnit.SECONDS);
            if(flag){//最多等1秒
                System.out.println(Thread.currentThread().getName()+"获取锁成功");
                Thread.sleep(2000);
            }else{
                System.out.println(Thread.currentThread().getName()+"获取锁失败，线程退出");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(flag){
                lock.unlock();
            }
        }
    }
}