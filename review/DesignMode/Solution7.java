package exercise.review.DesignMode;

/*
代理模式
两个子类同时实现一个接口，一个负责真实业务，一个负责辅助业务
 */
public class Solution7 {
    public static void main(String[] args) {
        ComputerFactory computerFactory = new ComputerFactory();
        Client2 client2 = new Client2();
        client2.buyComputer(computerFactory.getInstace());
    }
}
class Client2{
    void buyComputer(ProxySubject proxySubject){
        proxySubject.buyComputer();
    }
}
interface ISubject{
    void buyComputer();//买电脑
}
//真实业务
class RealSubject implements ISubject{
    public void buyComputer(){
        System.out.println("买电脑");
    }
}
class ProxySubject implements ISubject{
    private RealSubject realSubject;

    public ProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void buyComputer() {
        createComputer();
        this.realSubject.buyComputer();
        afterSale();
    }
    public void createComputer(){
        System.out.println("生产电脑");
    }
    public void afterSale(){
        System.out.println("电脑售后");
    }
}

class ComputerFactory{
    public static ProxySubject getInstace(){
        return new ProxySubject(new RealSubject());
    }
}