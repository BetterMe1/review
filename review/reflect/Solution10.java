package exercise.review.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Solution10 {
    public static void main(String[] args) {
        Class<?> cls = Person.class;
        Constructor<?>[] constructors = cls.getConstructors();//获取类中的全部构造
        for(Constructor constructor : constructors){
            System.out.println(constructor);
        }
        System.out.println("-------");
        Object obj = null;
        try {
            obj = cls.newInstance();
            System.out.println(obj);//只能调用类中国的无参构造，没有无参构造不能使用newInstance()
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("-------");
        Method[] methods = cls.getMethods();//获取类中全部的普通方法
        for(Method method : methods){
            System.out.println(method);
        }
        System.out.println("-------");
        try {
            Method setMethod = cls.getMethod("setName", String.class);//获取指定方法
            setMethod.invoke(obj,"小明");//调用方法
            Method getMethod = cls.getMethod("getName");
            Object o = getMethod.invoke(obj);
            System.out.println(o);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class Person{
    public String name;
    private int age;
    public Person(){}
    public Person(String name){
        this.name = name;
    }
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}