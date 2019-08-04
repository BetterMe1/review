package exercise.review;

/*
抽象类分内部类和外部类，内部抽象类可以是static的，外部不能
 */
public class Solution2 extends A.B{

    @Override
    public void printB() {
        System.out.println("B");
    }
}

abstract class A{
    public abstract void printA();
    static abstract class B{
        public abstract void printB();
    }
}