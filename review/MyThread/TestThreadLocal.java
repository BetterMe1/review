package exercise.review.MyThread;

/*
ThreadLocal-线程本地变量
	属于线程本地资源，不与其他线程共享
	set() :设置线程私有属性值
	get():设置线程私有属性值
 */
public class TestThreadLocal {
    private static String commStr;
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        //主线程中修改
        commStr = "main-Str";
        threadLocal.set("main-Thread");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //子线程
                commStr = "thread0-Str";
                threadLocal.set("thread0-ThreadLocalStr");
            }
        });
        thread.start();
        thread.join();
        System.out.println(commStr);//thread0-Str
        System.out.println(threadLocal.get());//main-Thread
    }
}
