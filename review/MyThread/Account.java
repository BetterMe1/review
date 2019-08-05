package exercise.review.MyThread;

/*
使用多把锁锁住不同的资源
 */
class Account {
    int sal;//余额
    String password;//密码
    //余额资源的锁
    private Object salLock = new Object();
    //密码资源的锁
    private Object passwordLock = new Object();
    public int getSal() {
       synchronized (salLock){
           return sal;
       }
    }

    public void setSal(int sal) {
        synchronized (salLock){
            this.sal = sal;
        }
    }

    public String getPassword() {
        synchronized (passwordLock){
            return password;
        }
    }

    public void setPassword(String password) {
        synchronized (passwordLock){
            this.password = password;
        }
    }
    //转账：
    //A -= 100;
    //B += 100;
    //保护有关联关系的对象：使用同一把锁
    public void zhuanzhang(Account A,Account B){
        synchronized (Account.class){
            A.sal -= 100;
            B.sal += 100;
        }
    }
}
