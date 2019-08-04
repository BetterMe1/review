package exercise.review;

/*
多态性：转型
 */
public class Solution1{
    public static void main(String[] args) {
        Person person = new Student();
        person.test1();
        person.test2();
        ((Student) person).test3();//向下转型调用
    }
}
class Person {
    public void test1(){
        System.out.println("person1");
    }
    public void test2(){
        System.out.println("person2");
    }
}
class Student extends Person {
    public void test1(){
        System.out.println("Student1");
    }
    public void test3(){
        System.out.println("Student3");
    }
}

