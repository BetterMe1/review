package exercise.review.MyThread;

/*
线程名称
 */
public class TestName {
    public static void main(String[] args) {
        Runnable runnable = new NameThread();
        Thread thread1 = new Thread(runnable,"线程1");
        Thread thread2 = new Thread(runnable);
        thread2.setName("线程2");
        thread1.start();
        thread2.start();
    }
}

class NameThread implements Runnable{

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println(Thread.currentThread().getName()+",i="+i);
        }
    }
}