package exercise.review.DesignMode;

/*
抽象工厂：
抽象产品，具体产品，抽象工厂（声明一组抽象产品的方法），具体工厂（实现一组具体产品），
与工厂方法相比，抽象工厂可以在工厂中创建多个产品
优点：可以将一组产品关联起来
       很好的实现开闭原则
       抽象工厂模式中我们可以定义实现不止一个接口，一个工厂也可以生成不止一个产品类 对于复杂对象的生产相当灵活易扩展
缺点：
      扩展产品族相当麻烦 而且扩展产品族会违反OCP,因为要修改所有的工厂
      由于抽象工厂模式是工厂方法模式的扩展 总体的来说 很笨重
 */
public class Solution6 {
    public static void main(String[] args) {
        Client1 client = new Client1();
        AppleFactory2 appleFactory2 = new AppleFactory2();
        client.buyFruit(appleFactory2.createFruit());
        client.buyDrink(appleFactory2.createDrink());
    }
}
