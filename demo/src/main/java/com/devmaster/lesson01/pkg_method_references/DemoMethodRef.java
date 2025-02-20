package com.devmaster.lesson01.pkg_method_references;
@FunctionalInterface
interface ExcuteFunction{
    public int excute(int a,int b);
}
class MathUtils{
    public MathUtils(){}
    public MathUtils(String str){
        System.out.println("MathUtils: "+str);
    }
    public static int add(int a, int b){
        return a+b;
    }
    public static int subtract(int a, int b){
        return a-b;
    }
    public static int multiply(int a, int b){
        return a*b;
    }
    public static int divide(int a, int b){
        return a/b;
    }
}
public class DemoMethodRef {
    public static int doAction(int a, int b,ExcuteFunction f){
        return f.excute(a,b);
    }
    public static void main(String[] args) {
        int a=22,b=11;
        int sum = doAction(a,b,MathUtils::add);
        System.out.println("Add"+ sum);

        int sub = doAction(a,b,MathUtils::subtract);
        System.out.println("Subtract"+ sub);
        int mul = doAction(a,b,MathUtils::multiply);
        System.out.println("Multiply"+ mul);
        int div = doAction(a,b,MathUtils::divide);
        System.out.println("Divide"+ div);
    }
}
