package com.devmaster.lesson01.pkg_lambda_expression;

import java.util.Arrays;
import java.util.List;

public class LambdaExpression4 {
    public static void main(String[] args) {
        List<String> lst = Arrays.asList("Java SpringBoot",
                "C# NetCore",
                "PHP",
                "JavaScript");
        lst.forEach(x->System.out.println(x));
        System.out.println("==============");
        lst.forEach(System.out::println);

        //filter
        lst.stream().filter(x->x.length()>10).forEach(System.out::println);
        System.out.println("==============");
        lst.stream().filter(x->x.contains("C")).forEach(System.out::println);
    }
}
