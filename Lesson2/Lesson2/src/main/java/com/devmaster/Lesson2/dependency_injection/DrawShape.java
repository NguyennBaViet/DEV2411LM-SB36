package com.devmaster.Lesson2.dependency_injection;
interface Shape{
    void draw();
}
class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Circle draw");
    }
}
class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Rectangle draw");
    }
}
public class DrawShape {
    private Shape shapes;
    public DrawShape(Shape shapes) {
        this.shapes = shapes;
    }
    public void draw() {
        shapes.draw();
    }

    public static void main(String[] args) {
        DrawShape drawShape = new DrawShape(new Circle());
        drawShape.draw();

        drawShape = new DrawShape(new Rectangle());
        drawShape.draw();
    }
}
