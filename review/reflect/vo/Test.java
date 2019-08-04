package exercise.review.reflect.vo;

public class Test {
    public static void main(String[] args) throws Exception {
        EmpAction empAction = new EmpAction();
        String str = "emp.ename:jack|emp.job:java Coder";
        empAction.setValue(str);
        System.out.println(empAction.getEmp());
    }
}
