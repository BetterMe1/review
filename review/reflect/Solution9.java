package exercise.review.reflect;

/*
反射
 */
public class Solution9 {
    public static void main(String[] args) {
        Class<?> cls = CLS.class;//获取类
        System.out.println(cls.getPackage().getName());//获取包名
        System.out.println(cls.getSuperclass().getName());//获取父类
       Class<?>[] classes = cls.getInterfaces();//获取父接口
       for(Class c :classes){
           System.out.println(c.getName());
       }
    }
}

interface IFruit{}
interface IMessage{}
class CLS implements IFruit,IMessage{}