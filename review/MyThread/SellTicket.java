package exercise.review.MyThread;

public class SellTicket {
    public static void main(String[] args) {
        TicketTask ticketTask = new TicketTask();
        Thread thread1 = new Thread(ticketTask,"线程A");
        Thread thread2 = new Thread(ticketTask,"线程B");
        Thread thread3 = new Thread(ticketTask,"线程C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class TicketTask implements Runnable{
    private  int ticket =20;
    @Override
    public void run() {
        /*for(int i=0; i<20; i++){
            synchronized (this){//同步代码块：任意时刻只能有一个线程进入
                if(ticket>0){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" 还剩下："+ticket--+"张票");
                }
            }
        }*/
        while (ticket>0){
            sellTicket();
        }
    }
    //同步方法：任意时刻只能有一个线程进入此方法
    public synchronized void sellTicket(){
        if(this.ticket >0){
            System.out.println(Thread.currentThread().getName()+" 还剩下："+ticket--+"张票");
        }
    }
}
