package exercise.review.MyThread;

/*
线程停止的三种方法
1.设置标记位（不能处理线程阻塞时停止问题）
2.调用Thread类提供的stop方法强行关闭线程（不推荐使用，因为会产生不完整数据）
3.调用Thread类提供的interrupt()：
    a.若线程中没有使用类似sleep()/wait()/join()时，调用此线程对象的interrupt()并不会真正中断线程，
    只是简单的将线程的状态置为 interrupt而已，可以根据状态进一步处理
    Thread类提供了isInterrupted()可检测当前线程状态是否是中断状态
    b.若线程中调用了阻塞线程的方法：sleep()/wait()/join()时，调用此线程对象的interrupt()会抛出异常InterruptedException，
    同时将线程状态还原(isInterrupt = false),可以在catch块中处理

 */
public class TestStop {
    public static void main(String[] args) throws InterruptedException {
        StopThread stopThread = new StopThread();
        Thread thread = new Thread(stopThread);
        thread.start();
        thread.sleep(1000);
        //方法一
        //休眠1s将标记设为false关闭
       /*stopThread.setFlag();*/

        //方法二
        /*thread.stop();*/

        //方法三
        thread.interrupt();
    }
}
class StopThread implements Runnable{
    private boolean flag = true;
    public void setFlag(){
        this.flag = false;
    }
    @Override
    public void run() {
        int i = 0;
        while (flag){
            //情况b
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("抛出中断异常");
                return;
            }
            //情况a
            boolean bool = Thread.currentThread().isInterrupted();
            System.out.println("当前线程状态为："+bool);
            if(bool){
                System.out.println("线程被置为中断状态");
                return;
            }
            System.out.println(Thread.currentThread().getName()+",i="+i++);
        }
        System.out.println("线程停止");
    }
}
