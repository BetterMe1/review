package exercise.review.DesignMode;

import java.util.Scanner;
/*
模板设计模式
 */
public class Solution3 {
    public static void main(String[] args) {
        Tea tea = new Tea();
        tea.compareDrink();
    }
}


abstract class Drick{
    final void compareDrink(){
        addWater();
        addMaterial();
        brew();
        pour();
        if(customerWantOther()){
            addOther();
        }
    }
    void addWater(){
        System.out.println("加入水");
    }
    void brew(){
        System.out.println("冲泡饮品");
    }
    void pour(){
        System.out.println("倒入杯子");
    }
    boolean customerWantOther(){//钩子方法
        return true;
    }
    abstract void addMaterial();//加入主料
    abstract void addOther();//加入辅料
}

class Tea extends Drick{

    @Override
    void addMaterial() {
        System.out.println("加入茶");
    }

    @Override
    void addOther() {
        System.out.println("加入柠檬");
    }
    boolean customerWantOther(){//钩子方法,需要时选择覆写
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请问需要添加辅料吗？");
            System.out.println("输入yes或no");
            String str = sc.next();
            if(str.equals("yes")){
                return true;
            }
            if(str.equals("no")){
                return false;
            }
        }
    }
}