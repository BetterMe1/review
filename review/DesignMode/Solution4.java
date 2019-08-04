package exercise.review.DesignMode;

import java.util.Scanner;

/*
简单工厂模式：
一个抽象产品，一些具体产品，一个工厂
缺点：违背开闭原则，每次添加产品都要修改工厂类，可以用反射解决
 */

public class Solution4 {
    public static void main(String[] args) {
        /*System.out.println("请输入您想要的水果：苹果，橙子");
        Scanner sc = new Scanner(System.in);
        String type = sc.next();
        Client client = new Client();
        FruitFactory fruitFactory = new FruitFactory();
        Fruit fruit = fruitFactory.getInstance(type);
        client.buyFruit(fruit);*/
        Client client = new Client();
        Fruit fruit = FruitFactory1.getInstance("exercise.review.DesignMode.Apple");
        if(fruit != null){
            client.buyFruit(fruit);
        }
    }
}