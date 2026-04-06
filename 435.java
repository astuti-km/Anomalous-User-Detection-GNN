import java.util.*;
class Parent{
    private int x;
    void set(int x){
        this.x=x;
    }
    void showParent(){
        System.out.println("Parent x: "+x);
    }
}
class child extends Parent{
    void showchild(){
        System.out.println("Child cannot access private variable directly.");
    }
}
public class TestPrivate{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of x:");
        child obj=new child();
        int v=in.nextInt();
        obj.set(v);
        obj.showParent();
        obj.showchild();
    }
}
output
Enter the value of x:
11
Parent x: 11
Child cannot access private variable directly.


class Grandparent{
    void gp(){
        System.out.println("Grandparent class");
    }
}
class Parent extends Grandparent {
    void p(){
        System.out.println("Parent class ");
    }
}
class Child extends Parent{
    void c(){
        System.out.println("Child class");
    }
}
public class multilevel {
    public static void main(String[] args) {
        Child s=new Child();
        s.gp();
        s.p();
        s.c();
    }
}
output
Grandparent class
Parent class 
Child class



import java.util.*;
class Base{
    void b(String n){
        System.out.println("Base class: "+n);
    }
}
    class Derived extends Base{
        void d(String p){
            System.out.println("Derived class: "+p);
        }
    }
public class Constructor {
  public static void main(String[] args) {
      Scanner in=new Scanner(System.in);
      Derived obj=new Derived();
      String n=in.nextLine();
      String p=in.nextLine();
      obj.b(n);
      obj.d(p);
  }  
}
output
As
Astuti
Base class: As
Derived class: Astuti

class Person{
    String name;
    int age;
    Person(String n,int a){
        name=n;
        age=a;
    }
    void display(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
    }
}
class Employee extends Person{
    double salary;
    Employee(String n,int a,double s){
        super(n,a);
        salary=s;
    }
    void display(){
        super.display();
        System.out.println("Salary: "+salary);
    }
}

public class TestPerson {
    public static void main(String[] args) {
        Person p=new Person("Rahul",20);
        System.out.println("Persons detail:");
        p.display();
        System.out.println();
        Employee e=new Employee("Aman",20,500);
        System.out.println("Employee dtails: ");
        e.display();
    }
}
output
Persons detail:
Name: Rahul
Age: 20

Employee dtails:
Name: Aman
Age: 20
Salary: 500.0


class Bank{
    int rateofinterest(){
        return 0;
    }}
    class SBI extends Bank{
        int rateofinterest(){
            return 9;
        }
    }
    class PNB extends Bank{
        int rateofinterest(){
            return 10;
        }
    }
    class BOB extends Bank{
        int rateofinterest(){
            return 11;
        }
    }

    public class Interest {
    public static void main(String[] args) {
        SBI s=new SBI();
        PNB p=new PNB();
        BOB b=new BOB();
        System.out.println("SBI rate: "+s.rateofinterest()+"%");
        System.out.println("PNB rate: "+p.rateofinterest()+"%");
        System.out.println("BOB rate: "+b.rateofinterest()+"%");
    }
}
output
SBI rate: 9%
PNB rate: 10%
BOB rate: 11%

import java.util.*;
class base{
    base(String name){
        System.out.println("Bse constructor class: "+name);
    }
}
class Derived extends base{
    Derived(String name,int age){
        super(name);
        System.out.println("Derived constructor class: "+age);
    }
}
public class construct {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);    
            String name=in.nextLine();
            int age=in.nextInt();
        Derived d=new Derived(name,age);
    }
}
output
Astuti
19
Bse constructor class: Astuti
Derived constructor class: 19


final class Vehicle{
    final void speed(){
        System.out.println("speed is fixed.");
    }
}
public class keyword {
    public static void main(String[] args) {
        Vehicle v= new Vehicle();
        v.speed();
    }
}
output
speed is fixed.


***with user input***
import java.util.*;

final class Vehicle {
    String name;
    int speed;

    // Constructor to take input
    Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    // Method to display
    final void display() {
        System.out.println("Vehicle name: " + name);
        System.out.println("Speed: " + speed + " km/h");
    }
}

public class Keyword {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter vehicle name: ");
        String vname = in.nextLine();

        System.out.print("Enter vehicle speed: ");
        int vspeed = in.nextInt();

        Vehicle v = new Vehicle(vname, vspeed);
        v.display();
    }
}


interface shape{
    void draw();
}
class Circle implements shape{
    public void draw(){
        System.out.println("Drawing circle");
    }
}
public class Method {
public static void main(String[] args) {
    Circle c=new Circle();
    c.draw();
}
}
    output
Drawing circle
**
take it as user input
import java.util.*;

interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing Square");
    }
}

class Triangle implements Shape {
    public void draw() {
        System.out.println("Drawing Triangle");
    }
}

public class Method {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Choose a shape to draw:");
        System.out.println("1 = Circle, 2 = Square, 3 = Triangle");
        int choice = in.nextInt();

        Shape s; // interface reference

        switch(choice) {
            case 1:
                s = new Circle();
                break;
            case 2:
                s = new Square();
                break;
            case 3:
                s = new Triangle();
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        s.draw(); // call draw() method
    }
}


abstract class Addition{
    abstract void add(int... num);
    }
class Demo extends Addition{
    void add(int... num){
        int sum=0;
        for(int n:num){
            sum+=n;
        }
        System.out.println("sum is: "+sum);
    }
}
public class Arguments {
    public static void main(String[] args) {
        Demo d=new Demo();
        d.add(10,20,30);
    }
}
output
sum is: 60
*********
take it as user input
import java.util.*;

abstract class Addition {
    abstract void add(int... nums); // abstract method with varargs
}

class Demo extends Addition {
    void add(int... nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        System.out.println("Sum is: " + sum);
    }
}

public class Arguments {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("How many numbers do you want to add? ");
        int n = in.nextInt();

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = in.nextInt();
        }

        Demo d = new Demo();
        d.add(numbers); // pass the array to varargs
    }
}

public class Demo {
    public static void main(String args[]){
        try {
            int a=10;
            int b=0;
            int c=a/b;
            int arr[]={1,2,3};
        } catch ( ArithmeticException e) {
            System.out.println("Arithmetic exception: cannot divide byzero");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array index exception");
        }
        catch (Exception e){
            System.out.println("General exception");
        }
    }
}
output
Arithmetic exception: cannot divide byzero

public class builtin {
    public static void main(String[] args) {
        try {
            String s=null;
            System.out.println(s.length());
        } catch (Exception e) {
            System.out.println("Null pointer exception");
        }
        try {
            int arr[]=new int[3];
            arr[4]=10;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bound  exception");
        }
    }
}
output
Null pointer exception
Array index out of bound  exception

lass MyException extends Exception{
    MyException(String m){
        super(m);
    }
}
public class userdefined {
    public static void main(String[] args) {
        try {
            throw new MyException("This is user defined exception");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
output
This is user defined exception
