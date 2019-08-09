package exercise.review.MyCollection;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author:Anan
 * @Date:2019/8/9
 */
public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"haha");
        map.put(2,"呵呵");
        map.put(1,"哈哈");
        Set<Integer> key = map.keySet();
        Iterator<Integer> iterator = key.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            System.out.println(i+"="+map.get(i));
        }
        //标准输出
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator1 = set.iterator();
        while (iterator1.hasNext()){
            Map.Entry<Integer,String> entry = iterator1.next();
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}
