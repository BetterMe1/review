package exercise.review.reflect;

import java.lang.reflect.Field;

public class Solution11 {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("exercise.review.reflect.Student");
            Field[] fields = cls.getFields();//获取父类中可访问的属性
            for(Field field :fields){
                System.out.println(field);
            }
            System.out.println("------");
            Field[] fields1 = cls.getDeclaredFields();//获取本类的所有属性
            for(Field field : fields1){
                System.out.println(field);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Student extends Person{
    private String school;
}


