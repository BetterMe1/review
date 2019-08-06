package exercise.review.MyThread;

/*
多个生产者-消费者
 */
public class TestMulCP {
    public static void main(String[] args) throws InterruptedException {
        Goods goods = new Goods(3);
        Pro pro = new Pro(goods);
        Cons cons = new Cons(goods);
        Thread producerThread = new Thread(pro,"生产者1");
        Thread producerThread2 = new Thread(pro,"生产者2");
        Thread producerThread3 = new Thread(pro,"生产者3");
        Thread consumerThread = new Thread(cons,"消费者1");
        Thread consumerThread2 = new Thread(cons,"消费者2");
        Thread consumerThread3 = new Thread(cons,"消费者3");
        Thread consumerThread4 = new Thread(cons,"消费者4");
        consumerThread.start();
        producerThread.start();
        producerThread2.start();
        producerThread3.start();
        consumerThread2.start();
        consumerThread3.start();
        consumerThread4.start();
    }
}

class Goods{
    private String goodsName;
    private int count;
    private int maxCount;

    public Goods(int maxCount) {
        this.maxCount = maxCount;
    }

    public synchronized  void set(String goodsName){
        while (count == maxCount){
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
        //唤醒所有消费者和生产者
        this.notifyAll();
    }
    public synchronized  void get(){
        while(count == 0){
            System.out.println("商品已卖完，需要等待卖家上架");
            try {
                this.wait();//消费者阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName()+"消费"+this);
        //唤醒所有消费者和生产者
        this.notifyAll();
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", count=" + count +
                '}';
    }
}
class Pro implements Runnable{
    private Goods goods;

    public Pro(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
       while(true){
           this.goods.set("一个小黑瓶");
       }
    }
}

class Cons implements Runnable{
    private Goods goods;

    public Cons(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true){
            this.goods.get();
        }
    }
}