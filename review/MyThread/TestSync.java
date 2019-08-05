package exercise.review.MyThread;

/*
Synchronized
 */
public class TestSync {
    public static void main(String[] args) {
        Task task = new Task();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}

class Sync{
    //线程1进入test(),同一时刻线程2不能进入test2()
    public  static synchronized void test() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"正在打印。。。");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"执行结束");
    }
    public  synchronized void test2() {
        System.out.println(Thread.currentThread().getName()+"test2");
    }
}
class Task implements Runnable{
    Sync sync = new Sync();//情况2
    @Override
    public void run() {
        //情况1
        /*
        Sync sync = new Sync();
        try {
            sync.test();//没有锁住Task对象，相当于三把锁各自锁了自己（Sync对象）
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //情况2：锁住了
        try {
            sync.test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //情况3：Sync的test()加上静态
        /*Sync sync = new Sync();
        try {
            sync.test();//没有锁住Task对象，相当于三把锁各自锁了自己（Sync对象）
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}