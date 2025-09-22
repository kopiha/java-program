import java.util.Scanner;
abstract class Shape{
public staticvoid main(String[] args){
int a,b;
Shape(int n,int m){
a=n;
b=m;
}abstract void printArea();
}class Rectangle extends Shape{
Rectangle(int length,int breadth){
super(length,breadth);
}
void printArea(){
double area=a*b;
System.out.println("Rectangle area:"+area);
}
}
class Circle extends Shape{
Circle(int radius){
super(radius,0);
}
void printArea(){
double area=a*a;
System.out.println("Circle area:"+area);
}
}
class Triangle extends Shape{
Triangle(int base,int height){
super(base,height);
}
void printArea(){
double area=0.5*a*b;
System.out.println("Triangle area:"+area);
}
}}
