package exercise.review.MyCollection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Description:
 * @Author:Anan
 * @Date:2019/8/9
 */
public class TestTreeSet {
    public static void main(String[] args) {
        /*Set<Person>  set = new TreeSet<>();//内部排序接口
        Set<Person> set = new TreeSet<>()*/
        /*PersonAgeSec personAgeSec = new PersonAgeSec();//外部排序接口
        Set<Person> set = new TreeSet<>(personAgeSec);*/
        Set<Person> set = new HashSet<>();
        set.add(new Person("A",3));
        set.add(new Person("A",4));
        set.add(new Person("b",3));
        System.out.println(set);
    }
}

//外部排序
class PersonAgeSec implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        //年龄升序，年龄相同的按姓名排
        if (o1.getAge() < o2.getAge()) {
            return -1;
        } else if (o1.getAge() > o2.getAge()) {
            return 1;
        }
        return o1.getName().compareTo(o2.getName());
    }
}