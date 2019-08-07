package exercise.review.MyThread;

/*
线程池
 */
import java.util.concurrent.*;

public class TestExecutor {
    public static void main1(String[] args) throws ExecutionException, InterruptedException {
        //创建线程池对象
        ExecutorService executorService = new ThreadPoolExecutor(2,
                3,60, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        CallableTest callableTest = new CallableTest();
        Future<String> submit = null;
        for(int i=0; i<5; i++){
           /* executorService.submit(callableTest);//并发执行*/
            submit = executorService.submit(callableTest);
            //System.out.println(submit.get());//thread-1全部执行完，Future接口中的get方法会阻塞当前线程直到取得Callable的返回值
        }
        System.out.println(submit.get());//阻塞后面一行，并行
        executorService.shutdown();//关闭线程池
    }

    public static void main(String[] args) {
        /*ExecutorService executorService = Executors.newFixedThreadPool(3);//固定线程池*/
        //ExecutorService executorService = Executors.newSingleThreadExecutor();//单线程池
        //ExecutorService executorService = Executors.newCachedThreadPool();//缓存线程池
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);//定时线程池
        for(int i=0 ;i<5; i++){
           /* executorService.schedule(new RunnableTest(),2,TimeUnit.SECONDS);//延迟2秒执行任务*/
            executorService.scheduleAtFixedRate(new RunnableTest(),2,
                    3,TimeUnit.SECONDS);//延迟2秒，每隔3秒执行一次任务
        }
       /* for(int i=0; i<10; i++){
            *//*try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*//*
            executorService.submit(new RunnableTest());
        }*/
        executorService.shutdown();
    }
}

class CallableTest implements Callable<String>{
    private int ticket = 20;

    @Override
    public String call() throws Exception {
        for(int i=0; i<20; i++){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName()+" 还剩下:"+ticket--+"张票");
            }
        }
        return Thread.currentThread().getName()+"票卖完了";
    }
}

class RunnableTest implements Runnable{

    @Override
    public void run() {
        for(int i=0; i<3; i++){
            /*try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
