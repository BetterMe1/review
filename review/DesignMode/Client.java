package exercise.review.DesignMode;

interface Fruit{
    abstract void printFruit();
}
class Client{
    public void buyFruit(Fruit fruit){
        if(fruit != null){
            fruit.printFruit();
        }
    }
}
class Apple implements Fruit{

    @Override
    public void printFruit() {
        System.out.println("吃苹果");
    }
}

class Orange implements Fruit{

    @Override
    public void printFruit() {
        System.out.println("吃橙子");
    }
}
//简单工厂
class FruitFactory{
    public static Fruit getInstance(String type){
        if(type.equals("苹果")){
            return new Apple();
        }
        if(type.equals("橙子")){
            return new Orange();
        }
        return null;
    }
}

//反射模式下的简单工厂
class FruitFactory1{
    //构造方法私有
    private FruitFactory1(){ }
    public static Fruit getInstance(String className){
        try {
            //反射获取
            Class classz = Class.forName(className);
            return (Fruit) classz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
//工厂方法
interface  FruitFactory2{
    Fruit createFruit();
}

class AppleFactory implements FruitFactory2{

    @Override
    public Fruit createFruit() {
        return new Apple();
    }
}

class OrangeFactory implements FruitFactory2{

    @Override
    public Fruit createFruit() {
        return new Orange();
    }
}

//抽象工厂
class  Client1{
    public void buyFruit(Fruit fruit){
        if(fruit != null){
            fruit.printFruit();
        }
    }
    public void buyDrink(Drink drink){
        if(drink != null){
            drink.printDrink();
        }
    }
}
interface Drink{
    void printDrink();
}

class Tea1 implements Drink{

    @Override
    public void printDrink() {
        System.out.println("喝茶");
    }
}
class juice implements Drink{

    @Override
    public void printDrink() {
        System.out.println("喝果汁");
    }
}
interface Factory{
    Fruit createFruit();
    Drink createDrink();
}
class AppleFactory2 implements Factory{

    @Override
    public Fruit createFruit() {
        return new Apple();
    }

    @Override
    public Drink createDrink() {
        return new juice();
    }
}

class OrangeFactory2 implements Factory{

    @Override
    public Fruit createFruit() {
        return new Orange();
    }

    @Override
    public Drink createDrink() {
        return new Tea1();
    }
}