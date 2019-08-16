package exercise.review.MyCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author:Anan
 * @Date:2019/8/15
 */
public class TestCollections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"1","2","3");
        Collections.reverse(list);
        System.out.println(list);

    }
}
