package exercise.review.MyThread;

/*
线程优先级：线程的优先级越高越有可能先执行，只是可能
线程继承性：若在一个线程中创建了子线程，默认子线程与父线程的优先级相同
 */
public class TestPriority {
    public static void main(String[] args) {
        /*System.out.println(Thread.currentThread().getPriority());//主线程优先级：5*/
        PriThread priThread = new PriThread();
       /* Thread thread1 = new Thread(priThread);
        Thread thread2 = new Thread(priThread);
        Thread thread3 = new Thread(priThread);
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();*/
        Thread thread1 = new Thread(priThread,"子线程A");
        thread1.start();
    }
}

class PriThread implements Runnable{

    @Override
    public void run() {
        for(int i=0; i<3; i++){
           // System.out.println(Thread.currentThread().getName()+",i="+i);
            System.out.println(Thread.currentThread().getName()+"优先级:"+Thread.currentThread().getPriority());
            new Thread(new PriThread(),"子线程B").start();
        }
    }
}