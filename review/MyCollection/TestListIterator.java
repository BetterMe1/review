package exercise.review.MyCollection;

import java.util.*;

/**
 * @Description:
 * @Author:Anan
 * @Date:2019/8/9
 */
public class TestListIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("world");
        ListIterator<String> iterator = list.listIterator();
        //从前向后
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }
        System.out.println("-----");
        //从前向后
        while (iterator.hasPrevious()){
            String str = iterator.previous();
            System.out.println(str);
        }
        System.out.println("-----");
        //遍历时删除元素，调用迭代器的remove()，否则抛出异常
        while (iterator.hasNext()){
            String str = iterator.next();
            if(str.equals("hello")){
               /* list.remove(str);*///ConcurrentModificationException
                iterator.remove();
            }
            System.out.println(str);
        }


        System.out.println("-----");
        Vector<String> vector = new Vector<>();
        vector.add("hello");
        vector.add("world");
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
    }
}
