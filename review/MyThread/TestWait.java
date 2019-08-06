package exercise.review.MyThread;

public class TestWait {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        synchronized (object){
            System.out.println("wait()开始。。。");
            object.wait(1000);//等待一段时间3
            System.out.println("wait()结束");
        }
    }
}
