package exercise.review.MyThread;

public class TestDaemon {
    public static void main(String[] args) throws InterruptedException {
        DaemonThread daemonThread = new DaemonThread();
        Thread thread1 = new Thread(daemonThread);
        Thread thread2 = new Thread(daemonThread);
        thread1.setDaemon(true);
        thread1.start();
        thread2.start();
        Thread.sleep(3000);
        //中断thread2
        thread2.interrupt();
        Thread.sleep(5000);
        System.out.println("代码结束");
    }
}

class DaemonThread implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("当前线程是否为守护线程："+Thread.currentThread().isDaemon());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("当前线程是否为守护线程："+Thread.currentThread().isDaemon());
                System.out.println("线程被终止");
                return;
            }
        }
    }
}