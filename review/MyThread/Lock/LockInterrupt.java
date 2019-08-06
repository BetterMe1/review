package exercise.review.MyThread.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterrupt {
    public static void main(String[] args) throws InterruptedException {
        TaskInterupt taskInterupt = new TaskInterupt();
        Thread thread = new Thread(taskInterupt);
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }
}

class TaskInterupt implements Runnable{
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            while (true){
                lock.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            System.out.println("线程响应中断");
            return;
        } finally {
            lock.unlock();
        }
    }
}