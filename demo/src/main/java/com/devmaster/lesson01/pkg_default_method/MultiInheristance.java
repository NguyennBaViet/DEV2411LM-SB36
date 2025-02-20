package com.devmaster.lesson01.pkg_default_method;

public class MultiInheristance implements Shape, Interface1, Interface2{
    @Override
    public void draw() {
        
    }

    @Override
    public void setColor(String color) {
        Shape.super.setColor(color);
    }

    @Override
    public void method1() {
        Interface1.super.method1();
    }

    @Override
    public void method2() {
        Interface2.super.method2();
    }

    public static void main(String[] args) {
        MultiInheristance m = new MultiInheristance();
        m.draw();
    }
}
