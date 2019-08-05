package exercise.review.MyThread;

/*
sleep方法会让当前线程立即交出CPU，但不会释放对象锁
yield()当前线程不会立即交出CPU，交出时间由系统调度
 */
public class TestSleep {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable  = new SleepThread();
        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread.start();
        thread1.start();
        thread2.start();
        thread.join();
        thread1.join();
        thread2.join();
        //等待子线程执行完毕后在执行主线程
        System.out.println("主线程执行完毕");
    }
}

class SleepThread implements Runnable{

    @Override
    public void run() {
        for(int i=0; i<100; i++){
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            Thread.yield();
            System.out.println(Thread.currentThread().getName()+",i="+i);
        }
    }
}