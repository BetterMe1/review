package exercise.review.DesignMode;

/*
单例模式、多例模式
 */
public class Solution8 {
    public static void main(String[] args) {
        //饿汉式
        Singleton1 singleton1 = Singleton1.getInstance();
        singleton1.print();
        //懒汉式
        Singleton2 singleton2 = Singleton2.getInstance();
        singleton2.print();
        //多例模式
        Sex sex = Sex.getInstance(Sex.MALE_FLAG);
        System.out.println(sex);
    }
}

/*
饿汉式:
构造方法私有，只能通过static方法获取实例化对象
 */
class Singleton1{
    private final static Singleton1 singleton = new Singleton1();
    private Singleton1(){}
    public static Singleton1 getInstance(){
        return singleton;
    }
    public void print(){
        System.out.println("Hello");
    }
}
/*
懒汉式
懒汉式存在线程安全问题，在多线程下可能创建的不止一个对象，所以需要加锁
 */
class Singleton2{
    private static volatile Singleton2 singleton2 = null;
    private Singleton2(){}
    public static Singleton2 getInstance(){
        if(singleton2 == null){
            synchronized (Singleton2.class){
                if(singleton2 == null){
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }
    public void print(){
        System.out.println("Hello");
    }
}

class Sex{
    private String title;
    public final static int MALE_FLAG = 1;
    public final static int FEMALE_FLAG = 2;
    private final static Sex MALE = new Sex("男");
    private final static Sex FEMALE = new Sex("女");
    private Sex(String title){
        this.title = title;
    }
    public static Sex getInstance(int flag){
        if(flag == MALE_FLAG){
            return MALE;
        }if(flag == FEMALE_FLAG){
            return FEMALE;
        }else{
            return null;
        }
    }
    public String toString(){
        return title;
    }
}