### Abstract Class in Java

An abstract class in Java is a class that cannot be instantiated and is declared with the `abstract` keyword. It can have abstract methods (methods without a body) and concrete methods (methods with a body).

### Abstraction in Java

Abstraction is a process of hiding the implementation details and showing only the functionality to the user. It helps in reducing complexity and allows focusing on what an object does instead of how it does it.

### Ways to Achieve Abstraction

1. **Abstract Class**: Achieved through the use of abstract classes.
2. **Interface**: Achieved through the use of interfaces.

### Abstract Method in Java

An abstract method is a method that is declared without an implementation (no method body). It is declared using the `abstract` keyword.

```java
abstract class Animal {
    abstract void makeSound(); // abstract method
}
```

### Example of Abstract Class That Has an Abstract Method

```java
abstract class Animal {
    abstract void makeSound(); // abstract method

    void sleep() {
        System.out.println("Animal is sleeping");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

public class TestAbstract {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.makeSound();
        d.sleep();
    }
}
```

### Understanding the Real Scenario of Abstract Class

In real scenarios, abstract classes are used to provide a base for subclasses to build upon. They provide common methods and define abstract methods that must be implemented by subclasses.

### Another Example of Abstract Class in Java

```java
abstract class Shape {
    abstract void draw(); // abstract method

    void display() {
        System.out.println("Displaying shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Rectangle");
    }
}

public class TestShape {
    public static void main(String[] args) {
        Shape s1 = new Circle();
        s1.draw();
        s1.display();

        Shape s2 = new Rectangle();
        s2.draw();
        s2.display();
    }
}
```

### Abstract Class Having Constructor, Data Member, and Methods

```java
abstract class Vehicle {
    String color;

    Vehicle(String color) {
        this.color = color;
    }

    abstract void start(); // abstract method

    void displayColor() {
        System.out.println("Color: " + color);
    }
}

class Car extends Vehicle {
    Car(String color) {
        super(color);
    }

    @Override
    void start() {
        System.out.println("Car is starting");
    }
}

public class TestVehicle {
    public static void main(String[] args) {
        Car c = new Car("Red");
        c.start();
        c.displayColor();
    }
}
```

### Another Real Scenario of Abstract Class

```java
abstract class Employee {
    String name;
    int empId;

    Employee(String name, int empId) {
        this.name = name;
        this.empId = empId;
    }

    abstract void calculateSalary(); // abstract method

    void displayDetails() {
        System.out.println("Name: " + name + ", EmpId: " + empId);
    }
}

class Developer extends Employee {
    int bonus;

    Developer(String name, int empId, int bonus) {
        super(name, empId);
        this.bonus = bonus;
    }

    @Override
    void calculateSalary() {
        System.out.println("Salary: " + (50000 + bonus));
    }
}

public class TestEmployee {
    public static void main(String[] args) {
        Developer d = new Developer("John", 101, 5000);
        d.calculateSalary();
        d.displayDetails();
    }
}
```

### Interface in Java

An interface in Java is a blueprint of a class that contains static constants and abstract methods. It is used to achieve complete abstraction.

### Difference Between Abstract Class and Interface in Table

| Feature              | Abstract Class                         | Interface                                 |
|----------------------|----------------------------------------|-------------------------------------------|
| Methods              | Can have abstract and concrete methods | Only abstract methods (until Java 7)      |
| Fields               | Can have instance variables            | Only static final constants               |
| Constructors         | Can have constructors                  | Cannot have constructors                  |
| Inheritance          | Can extend one class                   | Can extend multiple interfaces            |
| Access Modifiers     | Can have any access modifiers          | Methods are `public` by default           |
| Implementation       | Partially implemented methods          | No implementation allowed                 |
| Usage                | Used for shared behavior               | Used for defining a contract              |
| Multiple Inheritance | Not supported                          | Supported through multiple interfaces     |

### Java 8 Interface Improvement

Java 8 introduced default and static methods in interfaces.

#### Default Method

Default methods allow the addition of new methods to interfaces without breaking existing implementations.

```java
interface MyInterface {
    void display();

    default void newMethod() {
        System.out.println("Newly added default method");
    }
}

class MyClass implements MyInterface {
    @Override
    public void display() {
        System.out.println("Implemented method");
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.display();
        obj.newMethod();
    }
}
```

#### Static Method

Static methods in interfaces are defined using the `static` keyword and can be called independently of class instances.

```java
interface MyInterface {
    static void staticMethod() {
        System.out.println("Static method in interface");
    }
}

public class TestInterface {
    public static void main(String[] args) {
        MyInterface.staticMethod();
    }
}
```

### Internal Addition by the Compiler

The compiler adds the `public` and `abstract` modifiers to methods in an interface if not explicitly declared.

### The Relationship Between Classes and Interfaces

A class implements an interface to provide the behavior defined by the interface. Interfaces allow classes to achieve multiple inheritance-like behavior.

### Java Interface Example: Bank

```java
interface Bank {
    float getRateOfInterest();
}

class SBI implements Bank {
    public float getRateOfInterest() {
        return 8.4f;
    }
}

class ICICI implements Bank {
    public float getRateOfInterest() {
        return 7.3f;
    }
}

public class TestBank {
    public static void main(String[] args) {
        Bank b = new SBI();
        System.out.println("SBI Rate of Interest: " + b.getRateOfInterest());

        b = new ICICI();
        System.out.println("ICICI Rate of Interest: " + b.getRateOfInterest());
    }
}
```

### Multiple Inheritance in Java by Interface

Java supports multiple inheritance through interfaces, allowing a class to implement multiple interfaces.

```java
interface Printable {
    void print();
}

interface Showable {
    void show();
}

class TestMultipleInheritance implements Printable, Showable {
    public void print() {
        System.out.println("Printable interface method");
    }

    public void show() {
        System.out.println("Showable interface method");
    }

    public static void main(String[] args) {
        TestMultipleInheritance obj = new TestMultipleInheritance();
        obj.print();
        obj.show();
    }
}
```

### Q) Multiple Inheritance is Not Supported Through Class in Java, But It Is Possible by an Interface. Why?

Multiple inheritance is not supported through classes in Java to avoid the complexity and ambiguity caused by the diamond problem. Interfaces solve this problem as they only declare methods without providing their implementation, allowing multiple inheritance without ambiguity.

### Interface Inheritance

An interface can extend another interface, inheriting its abstract methods.

```java
interface A {
    void methodA();
}

interface B extends A {
    void methodB();
}

class C implements B {
    public void methodA() {
        System.out.println("Method A");
    }

    public void methodB() {
        System.out.println("Method B");
    }

    public static void main(String[] args) {
        C obj = new C();
        obj.methodA();
        obj.methodB();
    }
}
```

### Java 8 Default Method in Interface

Default methods provide the ability to add new functionality to interfaces without breaking the classes that implement them.

```java
interface MyInterface {
    void existingMethod(String str);

    default void newMethod() {
        System.out.println("Newly added default method");
    }
}

class MyClass implements MyInterface {
    public void existingMethod(String str) {
        System.out.println("String is: " + str);
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.existingMethod("Java 8");
        obj.newMethod();
    }
}
```

### Java 8 Static Method in Interface

Static methods in interfaces can be called independently of class instances.

```java
interface MyInterface {
    static void staticMethod() {
        System.out.println("Static method in interface");
    }
}

public class TestStaticMethod {
    public static void main(String[] args) {
        MyInterface.staticMethod();
    }
}
```

### Q) What is Marker or Tagged Interface?

A marker or tagged interface in Java is an interface with no methods or fields. It is used to mark a class for some special behavior by the JVM or other frameworks. Examples include `Serializable`, `Cloneable`, and `Remote`.

### Nested Interface in Java

A nested interface is an interface declared within another interface or class.

```java
class A {
    interface NestedInterface {
        void nestedMethod();
    }
}

class B implements A.NestedInterface {
   

 public void nestedMethod() {
        System.out.println("Nested interface method");
    }

    public static void main(String[] args) {
        B obj = new B();
        obj.nestedMethod();
    }
}
```

This nested interface can be implemented by any class, providing a way to logically group interfaces with the classes that use them.