package exercise.review.MyCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author:Anan
 * @Date:2019/8/15
 */
public class TestStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"Java","Python","C","JavaScript");
        //返回带Java的元素个数
        System.out.println(list.stream().filter((e) -> e.contains("Java")).count());
        //返回带Java的元素并形成新的集合
        List<String> resultList = list.stream().filter((e-> e.contains("Java"))).collect(Collectors.toList());
        System.out.println(resultList);
    }
}
