package exercise.review.MyCollection;


import java.util.*;

public class TestList {
    public static void main(String[] args) {
        List<Person> people = new LinkedList<>();
        Person person1 = new Person("小明",8);
        Person person2 = new Person("小张",5);
        Person person3 = new Person("小红",3);
        Person person4= new Person("小明",8);
        System.out.println(person1.equals(person4));
    }
}

class Person implements Comparable<Person>{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Person)){
            return false;
        }
        Person person = (Person)o;
        return this.age.equals(person.age) && (person.name.equals(this.name));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,age);
    }

    @Override
    public int compareTo(Person o) {
        if(this.age < o.age){
            return -1;
        }else if(this.age > o.age){
            return 1;
        }
        return this.name.compareTo(o.name);
    }
}
