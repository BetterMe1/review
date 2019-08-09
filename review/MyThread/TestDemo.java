package exercise.review.MyThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
线程创建方式一：
 */
class MyThread1 extends Thread{
    private String title;
    private int ticket = 100;
    public MyThread1(String title){
        this.title = title;
    }
    public void run(){
        while(ticket>0){
            System.out.println("当前线程为："+title+",还剩："+(--ticket));
        }
    }
}

/*
线程创建方式2
 */
class MyThread2 implements Runnable{
    private String title;
    private int ticket = 100;
    public MyThread2(String title){
        this.title = title;
    }
    public void run(){
        while(ticket>0){
            System.out.println("当前线程为："+title+",还剩："+(--ticket));
        }
    }
}
/*
方式三:附带返回值
 */
class MyThread3 implements Callable{
    private int ticket = 1000;
    @Override
    public Object call() throws Exception {
        while(ticket>0){
            System.out.println("当前线程为："+Thread.currentThread().getName()+",还剩："+(--ticket));
        }
        return "票卖完了";
    }
}

public class TestDemo{
    public static void main(String[] args) {
        /*
        Thread thread1 =  new MyThread1("mythread1");
        Thread thread2 =  new MyThread1("mythread2");
        Thread thread3 =  new MyThread1("mythread3");
        thread1.start();
        thread2.start();
        thread3.start();*/
        /*
        MyThread2 mt2 = new MyThread2("mythread1");//实现共享
        Thread thread1 =  new Thread(mt2);
        Thread thread2 =  new Thread(mt2);
        Thread thread3 =  new Thread(mt2);
        thread1.start();
        thread2.start();
        thread3.start();*/

        //产生Callable对象
        MyThread3 myThread3 = new MyThread3();//实现了Callable接口
        //产生FutureTask对象
        FutureTask<String> futureTask = new FutureTask<>(myThread3);
        FutureTask<String> futureTask1 = new FutureTask<>(myThread3);
        FutureTask<String> futureTask3 = new FutureTask<>(myThread3);
        Thread thread = new Thread(futureTask,"线程1");
        Thread thread1 = new Thread(futureTask1,"线程2");
        Thread thread2= new Thread(futureTask3,"线程3");
        thread2.start();
        thread.start();
        thread1.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
