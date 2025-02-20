package com.devmaster.lesson01.pkg_lambda_expression;

interface SayHello2 {
    void sayHello2(String name);
}
public class LambdaExpression2 {
    public static void main(String[] args) {
        SayHello2 sayHello2 = (name) -> {
            System.out.println("Hello " + name);
        };
        sayHello2.sayHello2("Việt");
        //Ngắn gọn
        sayHello2 = (name) -> {
            System.out.println("Hello " + name);
        };
        sayHello2.sayHello2("Việt");
        //Ngắn gọn hơn
        sayHello2 = name -> System.out.println("Hello " + name);
        sayHello2.sayHello2("Việt");
    }
}
