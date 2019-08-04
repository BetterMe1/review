package exercise.review.DesignMode;

/*
工厂方法：
一个抽象产品，一些具体产品，一个抽象工厂，一些具体工厂（一个工厂只生产一个具体产品）
增加一个子产品时，不需要修改代码，实现开闭原则
但是当增加其他产品族时，需要修改抽象工厂，违背了OCP  -open close principle
 */
public class Solution5 {
    public static void main(String[] args) {
        Client client = new Client();
        client.buyFruit(new AppleFactory().createFruit());
    }
}
