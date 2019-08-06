package exercise.review.MyThread;

/*
单个生产者-消费者
 */
public class TestCP {
    public static void main(String[] args) throws InterruptedException {
        Good good = new Good();
        Producer producer = new Producer(good);
        Consumer consumer = new Consumer(good);
        Thread producerThread = new Thread(producer,"生产者");
        Thread consumerThread = new Thread(consumer,"消费者");
        producerThread.start();
        Thread.sleep(1000);
        consumerThread.start();
    }
}
class Good{
    private String goodsName;
    private int count;
    public synchronized  void set(String goodsName){
        if(count == 1){
            System.out.println("此时还有产品，需要等待消费者消费");
            try {
                this.wait();//生产者阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.goodsName = goodsName;
        count++;
        System.out.println(Thread.currentThread().getName()+"生产"+this);
        //唤醒消费者来消费
        this.notify();
    }
    public synchronized  void get(){
        if(count == 0){
            System.out.println("商品已卖完，需要等待卖家上架");
            try {
                this.wait();//消费者阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName()+"消费"+this);
        //唤醒生产者生产
        this.notify();
    }

    @Override
    public String toString() {
        return "Good{" +
                "goodsName='" + goodsName + '\'' +
                ", count=" + count +
                '}';
    }
}
class Producer implements Runnable{
    private Good good;

    public Producer(Good good) {
        this.good = good;
    }

    @Override
    public void run() {
        this.good.set("一个小黑瓶");
    }
}

class Consumer implements Runnable{
    private Good good;

    public Consumer(Good good) {
        this.good = good;
    }

    @Override
    public void run() {
        this.good.get();
    }
}