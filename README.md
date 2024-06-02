### Java

Java is a high-level, object-oriented programming language developed by Sun Microsystems (now owned by Oracle). It is platform-independent, meaning that Java programs can run on any system that has a Java Runtime Environment (JRE) installed.

### Java Compilation Process
<img src="https://media.geeksforgeeks.org/wp-content/uploads/java.jpg"/>

1. **Writing Code**: Write Java code in a text editor or an IDE (Integrated Development Environment).
2. **Compilation**: Use the Java compiler (`javac`) to compile the Java source code (`*.java` files) into bytecode (`*.class` files).
3. **Execution**: Use the Java Virtual Machine (JVM) to execute the bytecode, which is platform-independent.


### JDK vs JRE vs JVM

<img src="https://media.geeksforgeeks.org/wp-content/uploads/jvm-3.jpg"/>

<img src="https://miro.medium.com/v2/resize:fit:720/1*_ZZFXuIMYCScducCUAMiZw.png"/>



| **Feature**          | **JDK (Java Development Kit)**                                   | **JRE (Java Runtime Environment)**                                  | **JVM (Java Virtual Machine)**                                      |
|----------------------|------------------------------------------------------------------|---------------------------------------------------------------------|----------------------------------------------------------------------|
| **Description**      | Software development kit used to develop Java applications.     | Environment used to run Java applications without development tools.| Virtual machine that executes Java bytecode.                        |
| **Components**       | Includes JRE, compiler (`javac`), debugger, and other tools.     | Includes JVM, libraries, and other components needed for execution. | Executes Java bytecode and provides runtime environment for Java.    |
| **Usage**            | Needed for Java development.                                     | Needed to run Java applications.                                    | Runtime environment for Java applications.                           |
| **Example Usage**    | Developing and compiling Java applications.                     | Running Java applications on end-user machines.                     | Executing Java bytecode on various platforms.                       |

### Java Variables

#### Types of Variables

1. **Local Variables**: Declared inside a method and have local scope.
2. **Instance Variables**: Belong to an instance of a class and are initialized when the class is instantiated.
3. **Static Variables (Class Variables)**: Belong to the class and are shared among all instances of the class.
4. **Parameters (Method Arguments)**: Variables passed into a method.

#### Examples

```java
public class VariablesExample {
    // Instance variable
    int instanceVar = 10;

    // Static variable
    static int staticVar = 20;

    void method(int localVar) {
        // Local variable
        int methodVar = 30;

        // Using all types of variables
        System.out.println("Instance variable: " + instanceVar);
        System.out.println("Static variable: " + staticVar);
        System.out.println("Local variable: " + localVar);
        System.out.println("Method variable: " + methodVar);
    }

    public static void main(String[] args) {
        VariablesExample obj = new VariablesExample();
        obj.method(40);
    }
}
```

#### Output
```
Instance variable: 10
Static variable: 20
Local variable: 40
Method variable: 30
```

### Data Types in Java

1. **Primitive Data Types**: byte, short, int, long, float, double, char, boolean.
2. **Non-Primitive Data Types**: Arrays, Strings, Classes, Interfaces.

#### Examples

```java
public class DataTypesExample {
    public static void main(String[] args) {
        // Primitive data types
        byte b = 100;
        short s = 1000;
        int i = 10000;
        long l = 100000L;
        float f = 10.5f;
        double d = 10.5;
        char c = 'A';
        boolean bool = true;

        // Non-primitive data types
        String str = "Java";
        int[] arr = {1, 2, 3, 4, 5};

        // Printing the values
        System.out.println("Primitive data types:");
        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + bool);

        System.out.println("\nNon-primitive data types:");
        System.out.println("String: " + str);
        System.out.print("Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

#### Output
```
Primitive data types:
byte: 100
short: 1000
int: 10000
long: 100000
float: 10.5
double: 10.5
char: A
boolean: true

Non-primitive data types:
String: Java
Array: 1 2 3 4 5
```

Here are examples of non-primitive data types in Java:

### Arrays
```java
public class ArrayExample {
    public static void main(String[] args) {
        // Declaration and initialization of an integer array
        int[] numbers = {1, 2, 3, 4, 5};

        // Accessing elements of the array
        System.out.println("Element at index 2: " + numbers[2]); // Output: 3

        // Modifying an element of the array
        numbers[2] = 10;
        System.out.println("Modified element at index 2: " + numbers[2]); // Output: 10

        // Iterating through the array
        System.out.print("Array elements: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
```

### Strings
```java
public class StringExample {
    public static void main(String[] args) {
        // Declaration and initialization of a String
        String str = "Hello, World!";

        // String length
        System.out.println("Length of the string: " + str.length()); // Output: 13

        // Concatenation
        String newStr = str.concat(" Welcome");
        System.out.println("Concatenated string: " + newStr); // Output: Hello, World! Welcome

        // Substring
        String subStr = str.substring(7);
        System.out.println("Substring: " + subStr); // Output: World!
    }
}
```

### Classes
```java
public class Person {
    String name;
    int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display information
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        person.display();
    }
}
```

### Interfaces
```java
interface Animal {
    void eat();
    void sleep();
}

class Dog implements Animal {
    public void eat() {
        System.out.println("Dog is eating");
    }

    public void sleep() {
        System.out.println("Dog is sleeping");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.sleep();
    }
}
```

These examples demonstrate the use of arrays, strings, classes, and interfaces, which are non-primitive data types in Java.
### Java OOPs Concepts

Object-Oriented Programming is a methodology or paradigm to design a program using classes and objects. It simplifies software development and maintenance by providing some concepts:
1. **Object**: An entity that has state and behavior is known as an object.
2. **Class**: Collection of objects is called class. It is a logical entity. A class can also be defined as a blueprint from which you can create an individual object. Class doesn't consume any space.
3. **Inheritance**: When one object acquires all the properties and behaviors of a parent object, it is known as inheritance. It provides code reusability. It is used to achieve runtime polymorphism.
4. **Polymorphism**: If one task is performed in different ways, it is known as polymorphism. 
4. **Abstraction**: Hiding internal details and showing functionality is known as abstraction. For example phone call, we don't know the internal processing.
4. **Encapsulation**: Binding (or wrapping) code and data together into a single unit are known as encapsulation. For example, a capsule, it is wrapped with different medicines.


#### Apart from these concepts, there are some other terms which are used in Object-Oriented design:
1. **Coupling**: Coupling refers to the knowledge or information or dependency of another class. It arises when classes are aware of each other. If a class has the details information of another class, there is strong coupling. In Java, we use private, protected, and public modifiers to display the visibility level of a class, method, and field. You can use interfaces for the weaker coupling because there is no concrete implementation.

2. **Cohesion**: Cohesion refers to the level of a component which performs a single well-defined task. A single well-defined task is done by a highly cohesive method. The weakly cohesive method will split the task into separate parts. The java.io package is a highly cohesive package because it has I/O related classes and interface. However, the java.util package is a weakly cohesive package because it has unrelated classes and interfaces.

3. **Association**: Association represents the relationship between the objects. Here, one object can be associated with one object or many objects. There can be four types of association between the objects:

    1. **One to One**
    2. **One to Many**
    3. **Many to One, and**
    4. **Many to Many**

Let's understand the relationship with real-time examples. For example, One country can have one prime minister (one to one), and a prime minister can have many ministers (one to many). Also, many MP's can have one prime minister (many to one), and many ministers can have many departments (many to many).

Association can be undirectional or bidirectional.

4.**Aggregation**: Aggregation is a way to achieve Association. Aggregation represents the relationship where one object contains other objects as a part of its state. It represents the weak relationship between objects. It is also termed as a has-a relationship in Java. Like, inheritance represents the is-a relationship. It is another way to reuse objects.

5.**Composition**: The composition is also a way to achieve Association. The composition represents the relationship where one object contains other objects as a part of its state. There is a strong relationship between the containing object and the dependent object. It is the state where containing objects do not have an independent existence. If you delete the parent object, all the child objects will be deleted automatically. 

Java naming conventions are guidelines for naming classes, methods, variables, packages, and other elements in Java programs. Following these conventions makes code more readable and maintainable.

### Class Naming
- **Convention**: Classes should be written in PascalCase (also known as UpperCamelCase), where each word in the name begins with a capital letter.
- **Example**: `MyClass`, `LibraryManagementSystem`, `EmployeeDetails`

### Interface Naming
- **Convention**: Interfaces should also be written in PascalCase.It should start with the uppercase letter.
- **Example**: `Runnable`, `ActionListener`, `Comparable`

### Method Naming
- **Convention**: Methods should be written in camelCase, where the first word is in lowercase, and each subsequent word starts with an uppercase letter.
- **Example**: `getName()`, `calculateTotal()`, `printDetails()`

### Variable Naming
- **Convention**: Variables should be written in camelCase.
- **Example**: `userName`, `totalAmount`, `maxValue`

### Constant Naming
- **Convention**: Constants should be written in uppercase letters with words separated by underscores.
- **Example**: `PI`, `MAX_SIZE`, `DEFAULT_TIMEOUT`

### Package Naming
- **Convention**: Packages should be written in all lowercase letters and typically use the reverse domain name convention to avoid name conflicts.
- **Example**: `com.example.myapp`, `org.company.project`

### Enum Naming
- **Convention**: Enum types should be written in PascalCase, while enum constants should be written in uppercase letters with words separated by underscores.
- **Example**:
    ```java
    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }
    ```

### Type Parameter Naming
- **Convention**: Type parameter names should be a single uppercase letter.
- **Example**: `E` for element, `K` for key, `V` for value, `T` for type
    ```java
    public class Box<T> {
        private T t;
        public void set(T t) { this.t = t; }
        public T get() { return t; }
    }
    ```

### Naming Examples in a Java Project

#### Class Example
```java
public class LibraryManagementSystem {
    // Fields
    private String libraryName;
    private List<Book> books;
    private List<Member> members;

    // Methods
    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }
}
```

#### Interface Example
```java
public interface Borrowable {
    void borrowItem(String itemId);
    void returnItem(String itemId);
}
```

#### Enum Example
```java
public enum BookGenre {
    FICTION, NON_FICTION, SCIENCE, HISTORY, FANTASY, BIOGRAPHY
}
```

### Objects and Classes in Java

#### What is an Object in Java?
An object is a basic unit of Object-Oriented Programming (OOP) that represents a real-world entity. It is an instance of a class and contains both data (attributes) and methods (functions).

#### An Object has Three Characteristics:
1. **State**: Represented by attributes of the object.
2. **Behavior**: Represented by methods of the object.
3. **Identity**: A unique identifier for each object, typically the memory address in Java.

#### Object Definitions:
An object can be defined as an instance of a class that encapsulates data and behavior related to that data.

#### What is a Class in Java?
A class is a blueprint or prototype from which objects are created. It defines a datatype by bundling data and methods that work on the data into one single unit.

#### A Class in Java Can Contain:
- **Fields (Attributes)**: Variables that hold the state of the object.
- **Methods**: Functions that define the behavior of the object.
- **Constructors**: Special methods used to initialize objects.
- **Blocks**: Code blocks such as static blocks and instance initializer blocks.
- **Nested Classes**: Classes defined within another class.

#### Instance Variable in Java:
Instance variables are variables defined in a class for which each instantiated object of the class has a separate copy, or instance.

#### Advantage of Method:
- **Code Reusability**: Methods allow for code to be written once and used many times.
- **Modularity**: Methods break the code into smaller, manageable sections.
- **Maintainability**: Methods make code easier to read and maintain.

#### new Keyword in Java:
The `new` keyword is used to create new objects. It allocates memory for the new object and initializes it by calling the constructor.

### Object and Class Examples

#### Example: Main within the Class
```java
public class Student {
    int id;
    String name;

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.id = 101;
        student1.name = "John";
        System.out.println(student1.id + " " + student1.name);
    }
}
```

#### Example: Main Outside the Class
```java
public class Student {
    int id;
    String name;
}

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.id = 101;
        student1.name = "John";
        System.out.println(student1.id + " " + student1.name);
    }
}
```

### 3 Ways to Initialize an Object
1. **By Reference Variable**
    ```java
    Student student1 = new Student();
    student1.id = 101;
    student1.name = "John";
    ```
2. **By Method**
    ```java
    public class Student {
        int id;
        String name;

        void insertRecord(int r, String n) {
            id = r;
            name = n;
        }
    }

    public class Main {
        public static void main(String[] args) {
            Student student1 = new Student();
            student1.insertRecord(101, "John");
        }
    }
    ```
3. **By Constructor**
    ```java
    public class Student {
        int id;
        String name;

        Student(int i, String n) {
            id = i;
            name = n;
        }
    }

    public class Main {
        public static void main(String[] args) {
            Student student1 = new Student(101, "John");
        }
    }
    ```

### Anonymous Object
An anonymous object is an object that is instantiated but not stored in a reference variable. It's typically used for a single method call.
```java
new Student().display();
```

### Creating Multiple Objects of One Type
```java
Student student1 = new Student();
Student student2 = new Student();
Student student3 = new Student();
```

### Real World Example: Account
```java
public class Account {
    int accountNumber;
    double balance;

    public Account(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void displayBalance() {
        System.out.println("Account Number: " + accountNumber + ", Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Account account1 = new Account(12345, 1000.0);
        account1.deposit(500.0);
        account1.withdraw(200.0);
        account1.displayBalance();
    }
}
```

This example demonstrates the use of classes and objects, encapsulating account details and operations within the `Account` class, and creating and manipulating `Account` objects in the `Main` class.



<img src="https://static.javatpoint.com/core/images/method-in-java.png"/>


### What is a Method in Java?
In Java, a method is a block of code that performs a specific task. It is similar to a function in other programming languages. Methods are used to break down a program into smaller, manageable pieces, making the code more organized and easier to understand.

### Method Declaration and Explanation with Examples
#### Method Signature:
The method signature consists of the method name and the parameter list. It does not include the return type or the method body.

Example:
```java
public void printMessage(String message) {
    System.out.println(message);
}
```

#### Access Specifier Types Example with Different Package and Main Method

<img src="https://media.geeksforgeeks.org/wp-content/uploads/20230409122917/Access-Modifiers-in-Java-1-768.webp"/>


Access specifiers control the visibility of a method. There are four types: `public`, `private`, `protected`, and default (no specifier).

<img src="https://media.geeksforgeeks.org/wp-content/uploads/20210423031253/AccessModifiersinJava.png"/>


Example:
```java
package com.example.package1;

public class MyClass {
    public void publicMethod() {
        System.out.println("This is a public method.");
    }

    private void privateMethod() {
        System.out.println("This is a private method.");
    }

    protected void protectedMethod() {
        System.out.println("This is a protected method.");
    }

    void defaultMethod() {
        System.out.println("This is a default method.");
    }
}

package com.example.package2;

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.publicMethod();    // Accessible
        // obj.privateMethod(); // Not accessible
        // obj.protectedMethod(); // Not accessible
        // obj.defaultMethod();  // Not accessible
    }
}
```

#### Return Type and Explanation with Examples
The return type specifies the type of value that the method returns. If the method does not return a value, the return type is `void`.

Example:
```java
public int add(int a, int b) {
    return a + b;
}
```
In Java, a method's return type determines the type of value that the method can return. Here are some common return types with explanations and examples:

1. **void**: Indicates that the method does not return any value.

   ```java
   public void greet() {
       System.out.println("Hello!");
   }
   ```

2. **Primitive types (int, double, boolean, etc.)**: Methods can return primitive data types.

   ```java
   public int add(int a, int b) {
       return a + b;
   }
   ```

3. **Object types**: Methods can return objects of any class, including custom classes.

   ```java
   public String getGreeting() {
       return "Hello!";
   }
   ```

4. **Array types**: Methods can return arrays of any type.

   ```java
   public int[] getNumbers() {
       return new int[]{1, 2, 3, 4, 5};
   }
   ```

5. **Interface types**: Methods can return objects that implement an interface.

   ```java
   public List<String> getList() {
       return Arrays.asList("Java", "Python", "C++");
   }
   ```

6. **Generic types**: Methods can return a generic type.


```java
public class GenericMethodExample {
    // Method to return the maximum of two integers
    public static <T extends Comparable<T>> T maximum(T x, T y) {
        return x.compareTo(y) > 0 ? x : y;
    }

    // Method to return the minimum of two integers
    public static <T extends Comparable<T>> T minimum(T x, T y) {
        return x.compareTo(y) < 0 ? x : y;
    }

    // Method to return the length of a string
    public static <T> int length(T[] array) {
        return array.length;
    }

    // Method to return the first element of an array
    public static <T> T firstElement(T[] array) {
        return array.length > 0 ? array[0] : null;
    }

    // Method to return the last element of an array
    public static <T> T lastElement(T[] array) {
        return array.length > 0 ? array[array.length - 1] : null;
    }

    public static void main(String[] args) {
        // Using the maximum method with integers
        int maxInt = maximum(5, 10);
        System.out.println("Maximum Integer: " + maxInt);

        // Using the minimum method with doubles
        double minDouble = minimum(3.14, 2.71);
        System.out.println("Minimum Double: " + minDouble);

        // Using the length method with a string array
        String[] fruits = {"Apple", "Banana", "Orange"};
        int arrayLength = length(fruits);
        System.out.println("Array Length: " + arrayLength);

        // Using the firstElement method with an integer array
        Integer[] numbers = {1, 2, 3, 4, 5};
        Integer firstNum = firstElement(numbers);
        System.out.println("First Element: " + firstNum);

        // Using the lastElement method with a character array
        Character[] chars = {'a', 'b', 'c'};
        Character lastChar = lastElement(chars);
        System.out.println("Last Element: " + lastChar);
    }
}
```


7. **void vs. return types**: Methods with a return type of `void` do not return a value, while methods with other return types must use the `return` keyword to return a value of that type.

#### Method Name and Explanation with Examples
The method name is a unique identifier for the method within the class.

Example:
```java
public void printMessage() {
    System.out.println("Hello, World!");
}
```

#### Parameter List and Explanation with Examples
The parameter list specifies the type and order of parameters that the method accepts. It is optional and can be empty.

In Java, a method's parameter list defines the type and order of the parameters that the method expects to receive when it is called. Here's an explanation of method parameters with multiple :
Examples:

1. **No Parameters**: A method can have no parameters.

   ```java
   public void printMessage() {
       System.out.println("Hello!");
   }
   ```

2. **Single Parameter**: A method can have a single parameter.

   ```java
   public void printMessage(String message) {
       System.out.println(message);
   }
   ```

3. **Multiple Parameters**: A method can have multiple parameters of different types.

   ```java
   public int add(int a, int b) {
       return a + b;
   }
   ```

4. **Varargs Parameter**: A method can have a variable number of parameters (varargs) of the same type. The varargs parameter must be the last parameter in the parameter list.

   ```java
   public int sum(int... numbers) {
       int sum = 0;
       for (int num : numbers) {
           sum += num;
       }
       return sum;
   }
   ```

5. **Array Parameter**: A method can have an array as a parameter.

   ```java
   public void printArray(int[] numbers) {
       for (int num : numbers) {
           System.out.println(num);
       }
   }
   ```

6. **Passing Objects**: You can pass objects as parameters to methods.

   ```java
   public void printPersonDetails(Person person) {
       System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
   }
   ```

7. **Passing Enum Types**: Enum types can be used as parameters.

   ```java
   public void printDayOfWeek(DayOfWeek dayOfWeek) {
       System.out.println("Today is " + dayOfWeek);
   }
   ```

8. **Passing Functional Interfaces**: Functional interfaces can be passed as parameters, allowing for the implementation of functional programming concepts like lambda expressions.

   ```java
   public void processString(String str, Function<String, String> processor) {
       String result = processor.apply(str);
       System.out.println(result);
   }
   ```

Method parameters are specified within the parentheses following the method name. Each parameter is defined by its type followed by its name, separated by a comma. The parameter list is optional, and if present, it must match the method signature specified in the method declaration.

#### Method Body and Explanation with Examples
The method body contains the statements that define what the method does. It is enclosed in curly braces `{}`.

Example:
```java
public void printMessage() {
    System.out.println("Hello, World!");
}
```

#### Naming a Method and Explanation with Examples
Method names should be meaningful and descriptive, following camelCase convention.

Example:
```java
public void calculateSum(int a, int b) {
    int sum = a + b;
    System.out.println("Sum: " + sum);
}
```

### Predefined Methods
Predefined methods are built-in methods provided by Java's standard API. These methods are ready to use and provide functionality for common tasks.

Example:
```java
public class PredefinedMethodsExample {
    public static void main(String[] args) {
        // Using predefined methods
        String text = "Hello, World!";
        System.out.println("Length of the text: " + text.length());

        int[] numbers = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum of numbers: " + sum);
    }
}
```

### User-defined Methods
User-defined methods are created by the programmer to perform specific tasks that are not covered by predefined methods. These methods are defined within a class and can be called from other parts of the program to execute the code inside them.

Example:
```java
public class UserDefinedMethodsExample {
    // User-defined method
    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        // Calling the user-defined method
        int result = add(10, 20);
        System.out.println("Result of addition: " + result);
    }
}
```

### Static Method
A static method belongs to the class rather than an instance of the class. It can be called without creating an instance of the class.

Example:
```java
public class StaticMethodExample {
    // Static method
    public static void greet() {
        System.out.println("Hello, World!");
    }

    public static void main(String[] args) {
        // Calling the static method
        greet();
    }
}
```

### Instance Method
An instance method belongs to an instance of the class and can access instance variables and other instance methods.

Example:
```java
public class InstanceMethodExample {
    // Instance method
    public void greet() {
        System.out.println("Hello, World!");
    }

    public static void main(String[] args) {
        // Creating an instance of the class
        InstanceMethodExample obj = new InstanceMethodExample();
        // Calling the instance method using the instance
        obj.greet();
    }
}
```

#### Accessor Method
Accessor methods, also known as getter methods, are used to retrieve the value of an instance variable.

Example:
```java
public class AccessorMethodExample {
    private int number;

    // Accessor method
    public int getNumber() {
        return number;
    }

    public static void main(String[] args) {
        AccessorMethodExample obj = new AccessorMethodExample();
        obj.number = 10;
        System.out.println("Number: " + obj.getNumber());
    }
}
```

#### Mutator Method
Mutator methods, also known as setter methods, are used to modify the value of an instance variable.

Example:
```java
public class MutatorMethodExample {
    private int number;

    // Mutator method
    public void setNumber(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        MutatorMethodExample obj = new MutatorMethodExample();
        obj.setNumber(20);
        System.out.println("Number: " + obj.number);
    }
}
```

### Abstract Method
An abstract method is a method that is declared in an abstract class but does not have an implementation. Subclasses of the abstract class must provide an implementation for the abstract method.

Example:

### Example 1: Payment Gateway Integration
In a payment processing system, you might have different payment gateways like PayPal, Stripe, and Square. Each payment gateway requires a different implementation for processing payments. You can use an abstract class with an abstract method to define a template for payment processing and let each payment gateway subclass provide its implementation.

```java
abstract class PaymentGateway {
    abstract void processPayment(double amount);
}

class PayPalGateway extends PaymentGateway {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing payment via PayPal for amount: " + amount);
        // PayPal specific implementation
    }
}

class StripeGateway extends PaymentGateway {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing payment via Stripe for amount: " + amount);
        // Stripe specific implementation
    }
}

public class PaymentGatewayExample {
    public static void main(String[] args) {
        PaymentGateway gateway = new PayPalGateway();
        gateway.processPayment(100.0);

        gateway = new StripeGateway();
        gateway.processPayment(200.0);
    }
}
```

### Example 2: Database Connection Pooling
In a web application, you often need to manage database connections efficiently to handle multiple client requests. You can use an abstract class to define a template for managing database connections and let subclasses provide their implementation for creating, reusing, and closing connections.

```java
import java.sql.Connection;

abstract class ConnectionPool {
    abstract Connection getConnection();
    abstract void releaseConnection(Connection connection);
}

class MySQLConnectionPool extends ConnectionPool {
    @Override
    Connection getConnection() {
        System.out.println("Creating MySQL database connection");
        // Create and return MySQL database connection
        return null;
    }

    @Override
    void releaseConnection(Connection connection) {
        System.out.println("Releasing MySQL database connection");
        // Release MySQL database connection
    }
}

class OracleConnectionPool extends ConnectionPool {
    @Override
    Connection getConnection() {
        System.out.println("Creating Oracle database connection");
        // Create and return Oracle database connection
        return null;
    }

    @Override
    void releaseConnection(Connection connection) {
        System.out.println("Releasing Oracle database connection");
        // Release Oracle database connection
    }
}

public class ConnectionPoolExample {
    public static void main(String[] args) {
        ConnectionPool pool = new MySQLConnectionPool();
        Connection connection = pool.getConnection();
        pool.releaseConnection(connection);

        pool = new OracleConnectionPool();
        connection = pool.getConnection();
        pool.releaseConnection(connection);
    }
}
```

In both examples, the abstract class defines a template for a specific functionality (payment processing, database connection pooling) while allowing concrete subclasses to provide their implementations for specific use cases.

### Factory Method
A factory method is a static method that creates and returns instances of a class.

Example:
Sure, here are two more examples of the factory method pattern in Java:

### Example 1: Shape Factory
```java
interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class ShapeFactory {
    // Factory method to create shapes
    public static Shape createShape(String type) {
        if (type.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (type.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else {
            throw new IllegalArgumentException("Invalid shape type");
        }
    }
}

public class FactoryMethodExample {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.createShape("circle");
        circle.draw();

        Shape rectangle = ShapeFactory.createShape("rectangle");
        rectangle.draw();
    }
}
```

### Example 2: Currency Factory
```java
interface Currency {
    String getSymbol();
}

class Dollar implements Currency {
    @Override
    public String getSymbol() {
        return "USD";
    }
}

class Euro implements Currency {
    @Override
    public String getSymbol() {
        return "EUR";
    }
}

class CurrencyFactory {
    // Factory method to create currencies
    public static Currency createCurrency(String country) {
        if (country.equalsIgnoreCase("USA")) {
            return new Dollar();
        } else if (country.equalsIgnoreCase("EUROPE")) {
            return new Euro();
        } else {
            throw new IllegalArgumentException("Invalid country");
        }
    }
}

public class FactoryMethodExample {
    public static void main(String[] args) {
        Currency dollar = CurrencyFactory.createCurrency("USA");
        System.out.println("Currency Symbol for USA: " + dollar.getSymbol());

        Currency euro = CurrencyFactory.createCurrency("EUROPE");
        System.out.println("Currency Symbol for Europe: " + euro.getSymbol());
    }
}
```


#### How to Create a User-defined Method
To create a user-defined method, use the following syntax:
```java
<access specifier> <return type> <method name>(<parameter list>) {
    // Method body
}
```

#### How to Call or Invoke a User-defined Method
To call or invoke a user-defined method, use the following syntax:
```java
<method name>(<arguments>);
```


### Summary
- Methods in Java are blocks of code that perform specific tasks.
- The method signature consists of the method name and the parameter list.
- Access specifiers control the visibility of a method.
- The return type specifies the type of value that the method returns.
- The method name is a unique identifier for the method within the class.
- The parameter list specifies the type and order of parameters that the method accepts.
- The method body contains the statements that define what the method does.
- Method names should be meaningful and follow camelCase convention.
- There are static methods, instance methods, and factory methods in Java.



### Constructors in Java

#### Rules for Creating Java Constructor
1. Constructor name must be the same as its class name.
2. A Constructor must have no explicit return type.
3. A Java constructor cannot be abstract, static, final, or synchronized.

#### Types of Java Constructors
1. **Default Constructor (No-Arg Constructor)**: This is a constructor with no parameters. If you don't define any constructor in your class, the compiler automatically adds a default constructor.

2. **Parameterized Constructor**: This is a constructor with parameters.
### Default Constructor (No-Arg Constructor)

Example:
```java
class Person {
    private String name;
    private int age;

    // Default constructor
    public Person() {
        this.name = "John Doe";
        this.age = 30;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Person person = new Person(); // Default constructor called
        person.display(); // Output: Name: John Doe, Age: 30
    }
}
```

### Parameterized Constructor
A parameterized constructor is a constructor with parameters. It allows you to initialize an object with specific values at the time of creation.

Example:
```java
class Person {
    private String name;
    private int age;

    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Person person = new Person("Alice", 25); // Parameterized constructor called
        person.display(); // Output: Name: Alice, Age: 25
    }
}
```

In the examples above, the `Person` class demonstrates both a default constructor and a parameterized constructor. The default constructor initializes the `name` to "John Doe" and `age` to 30, while the parameterized constructor allows you to specify the `name` and `age` values at the time of object creation.

#### Constructor Overloading in Java
Constructor overloading is the ability to define multiple constructors in a class with different parameters.

Constructor overloading in Java allows a class to have multiple constructors with different parameter lists. The compiler uses the number and types of parameters to determine which constructor to invoke. Here's an example demonstrating constructor overloading:

```java
class Rectangle {
    private int length;
    private int width;

    // Default constructor
    public Rectangle() {
        this.length = 0;
        this.width = 0;
    }

    // Parameterized constructor with one parameter
    public Rectangle(int side) {
        this.length = side;
        this.width = side;
    }

    // Parameterized constructor with two parameters
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void display() {
        System.out.println("Length: " + length + ", Width: " + width);
    }

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(); // Default constructor called
        rectangle1.display(); // Output: Length: 0, Width: 0

        Rectangle rectangle2 = new Rectangle(5); // Parameterized constructor with one parameter called
        rectangle2.display(); // Output: Length: 5, Width: 5

        Rectangle rectangle3 = new Rectangle(10, 7); // Parameterized constructor with two parameters called
        rectangle3.display(); // Output: Length: 10, Width: 7
    }
}
```

In this example, the `Rectangle` class has three constructors: a default constructor, a parameterized constructor with one parameter (for creating a square), and a parameterized constructor with two parameters (for creating a rectangle with custom length and width). Depending on the number of arguments passed, the appropriate constructor is called.

#### Difference Between Constructor and Method in Java
| Feature           | Constructor                           | Method                                |
|-------------------|---------------------------------------|---------------------------------------|
| Name              | Same as class name                    | Any valid identifier                  |
| Return Type       | No return type (not even void)        | Can have a return type                |
| Invocation        | Automatically invoked on object creation | Explicitly called using object       |
| Purpose           | Initializes object state              | Performs some functionality           |
| Keyword           | Uses `new` keyword for object creation | Does not use `new` keyword           |
| Overloading       | Can be overloaded                     | Can be overloaded                     |
| Inheritance       | Not inherited                         | Inherited unless marked final or static |
| Access Modifiers  | Can have access modifiers             | Can have access modifiers             |
| Abstract          | Cannot be abstract                   | Can be abstract                       |
| Static            | Cannot be static                     | Can be static                         |

These are general differences and may vary based on specific programming languages and contexts.

#### Java Copy Constructor
A copy constructor is a constructor that creates an object by copying the values of another object.

Example:
```java
class Student {
    private String name;

    // Copy constructor
    public Student(Student other) {
        this.name = other.name;
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Student student1 = new Student("Alice");
        Student student2 = new Student(student1); // Using copy constructor
        System.out.println(student2.getName()); // Output: Alice
    }
}
```

#### Copying Values Without Constructor
Values of one object can be copied into another in Java by assigning the values or by using the `clone()` method.

Example:
```java
class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Student student1 = new Student("Alice");
        Student student2 = new Student("");
        student2.name = student1.name; // Copying values without constructor
        System.out.println(student2.getName()); // Output: Alice
    }
}
```

#### Other Questions
- **Does Constructor Return Any Value?**: No, constructors do not return any value.
- **Can Constructor Perform Other Tasks Instead of Initialization?**: Yes, a constructor can perform other tasks, but it is primarily used for object initialization.
- **Is There a Constructor Class in Java?**: No, there is no special class called Constructor in Java.
- **What Is the Purpose of Constructor Class?**: Constructors are used to create and initialize objects in Java.



### Java `static` Keyword

#### Purpose
The `static` keyword in Java is used to indicate that a particular variable, method, block, or nested class is a class-level entity and belongs to the class itself rather than to instances of the class.

#### Types of `static` Entities
1. **Variable (Class Variable)**: A variable that is declared as `static` is called a class variable. It is initialized only once, at the start of the execution, and shared among all instances of the class.

Example of static variable:
```java
class Counter {
    static int count = 0; // Static variable

    Counter() {
        count++;
    }

    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();

        System.out.println("Number of objects created: " + count); // Output: 3
    }
}
```

2. **Method (Class Method)**: A method that is declared as `static` is called a static method. It belongs to the class and can be called without creating an instance of the class.

Example of static method:
```java
class StaticMethod {
    static void display() {
        System.out.println("This is a static method");
    }

    public static void main(String[] args) {
        display(); // Calling static method without instance
    }
}
```

#### Why is the Java `main` Method Static?
The `main` method in Java is declared as `static` because it is called by the Java Virtual Machine (JVM) to run the program without creating an instance of the class.

3. **Static Block**: A static block is used to initialize static variables or perform any other one-time initialization tasks for a class. It is executed only once, when the class is loaded into memory.

Example of static block:
```java
class StaticBlock {
    static {
        System.out.println("This is a static block");
    }

    public static void main(String[] args) {
        // Main method
    }
}
```
Yes, that's correct. In Java, the `static` keyword can be applied to:

1. **Variable**: Also known as a class variable, a static variable is shared among all instances of a class. It is initialized only once, at the start of the execution.

2. **Method**: Also known as a class method, a static method belongs to the class rather than to instances of the class. It can be invoked without the need for creating an instance of the class.

3. **Block**: A static block is a block of code enclosed in braces (`{}`) that is executed when the class is loaded into memory. It is used to initialize static variables or perform any other one-time initialization tasks for the class.

4. **Nested Class**: A nested class declared as `static` is called a static nested class. It belongs to the outer class and can be accessed without creating an instance of the outer class.

Here's an example demonstrating these concepts:

```java
class Outer {
    static int staticVariable = 10; // Static variable

    static { // Static block
        System.out.println("Static block: " + staticVariable);
    }

    static void staticMethod() { // Static method
        System.out.println("Static method");
    }

    static class NestedStaticClass { // Static nested class
        void display() {
            System.out.println("Nested static class");
        }
    }
}

public class StaticExample {
    public static void main(String[] args) {
        // Accessing static variable
        System.out.println("Static variable: " + Outer.staticVariable);

        // Calling static method
        Outer.staticMethod();

        // Creating instance of static nested class
        Outer.NestedStaticClass nested = new Outer.NestedStaticClass();
        nested.display();
    }
}
```

In this example, `staticVariable` is a static variable, `staticMethod()` is a static method, the static block initializes the static variable, and `NestedStaticClass` is a static nested class.


### Example of Static Variable
```java
class Counter {
    static int count = 0; // Static variable

    Counter() {
        count++;
    }

    void display() {
        System.out.println("Count: " + count);
    }

    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();

        c1.display(); // Output: Count: 3
    }
}
```

### Program without Static Variable
```java
class Counter {
    int count = 0; // Instance variable

    Counter() {
        count++;
    }

    void display() {
        System.out.println("Count: " + count);
    }

    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();

        c1.display(); // Output: Count: 1
    }
}
```

### Program with Static Variable
```java
class Counter {
    static int count = 0; // Static variable

    Counter() {
        count++;
    }

    void display() {
        System.out.println("Count: " + count);
    }

    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();

        c1.display(); // Output: Count: 3
    }
}
```

In the first program, `count` is a static variable, so it is shared among all instances of the class `Counter`. Each time a new instance is created, the `count` is incremented, leading to a final count of 3.

In the second program, `count` is an instance variable, so each instance of the class `Counter` has its own `count` variable. Each time a new instance is created, the `count` is incremented for that instance only, leading to a count of 1 for each instance.

The third program is the same as the first, demonstrating the use of a static variable.

#### Can We Execute a Program Without `main()` Method?
No, we cannot execute a Java program without the `main()` method because it is the entry point for the JVM to start the execution of the program.

In summary, the `static` keyword in Java is used to define class-level entities such as variables, methods, blocks, and nested classes. These entities belong to the class itself rather than to instances of the class.


### `this` Keyword in Java

The `this` keyword in Java is a reference to the current object. It can be used in several contexts:

1. **To refer to current class instance variable**: When there is a local variable with the same name as an instance variable, `this` can be used to refer to the instance variable.

Example:
```java
class Student {
    String name; // Instance variable

    Student(String name) {
        this.name = name; // Using 'this' to refer to the instance variable
    }

    void display() {
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        Student s = new Student("Alice");
        s.display(); // Output: Name: Alice
    }
}
```

2. **To invoke current class method (implicitly)**: When you call a method without using `this`, it is implicitly understood that you are referring to the current object.

Here's an example demonstrating how a method can be invoked without using `this`, which implicitly refers to the current object:

```java
class Counter {
    int count; // Instance variable

    Counter() {
        count = 0;
    }

    void increment() {
        count++; // Implicitly referring to the instance variable 'count'
    }

    void display() {
        System.out.println("Count: " + count);
    }

    public static void main(String[] args) {
        Counter c1 = new Counter();
        c1.increment(); // Implicitly calling the 'increment' method on 'c1'
        c1.display(); // Output: Count: 1
    }
}
```

In this example, the `increment` method is invoked without using `this`, but it is understood that `count++` refers to the instance variable `count` of the current object. The `increment` method is implicitly called on the `c1` object, which increments the `count` variable to 1.

3. **To pass as an argument in the constructor call**: `this` can be used to pass the current object as a parameter to another method or constructor.

Example:
```java
class Student {
    String name;

    Student() {
        this("Alice"); // Calling parameterized constructor using 'this'
    }

    Student(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        Student s = new Student();
        s.display(); // Output: Name: Alice
    }
}
```

4. **To return the current class instance**: `this` can be used to return the current object from a method.

```java
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    // Method to return the current object
    Person getPerson() {
        return this;
    }

    void display() {
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        Person person1 = new Person("Alice");
        Person person2 = person1.getPerson(); // Using 'this' to return the current object

        System.out.print("Person 1: ");
        person1.display(); // Output: Name: Alice

        System.out.print("Person 2: ");
        person2.display(); // Output: Name: Alice
    }
}
```

In this example, the `getPerson` method returns the current object using `this`. When `person1.getPerson()` is called, it returns the `person1` object itself. The `person2` object now refers to the same object as `person1`, and both `person1` and `person2` can be used interchangeably to access the same object's properties and methods.

5. **To pass as an argument in the method call**: `this` can be passed as an argument in the method call.
   Here's an example demonstrating how `this` can be passed as an argument in a method call:

```java
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    // Method that takes another Person object as an argument
    void displayOtherPerson(Person otherPerson) {
        System.out.println("Other Person's name: " + otherPerson.name);
    }

    void display() {
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        Person person1 = new Person("Alice");
        Person person2 = new Person("Bob");

        System.out.print("Person 1: ");
        person1.display(); // Output: Name: Alice

        System.out.print("Person 2: ");
        person2.display(); // Output: Name: Bob

        // Passing 'person2' object as an argument to the 'displayOtherPerson' method of 'person1'
        person1.displayOtherPerson(person2); // Output: Other Person's name: Bob
    }
}
```

In this example, the `displayOtherPerson` method of the `Person` class takes another `Person` object as an argument. Inside the `main` method, we create two `Person` objects (`person1` and `person2`). We then pass `person2` as an argument to the `displayOtherPerson` method of `person1`, effectively passing the `person2` object itself to the method.
6. **To call the constructor of the same class**: `this()` can be used to call the constructor of the same class from another constructor. This is known as constructor chaining.

Example:
```java
class Student {
    String name;

    Student() {
        this("Alice"); // Calling parameterized constructor using 'this'
    }

    Student(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        Student s = new Student();
        s.display(); // Output: Name: Alice
    }
}
```

In summary, the `this` keyword in Java is used to refer to the current object. It can be used to access instance variables, invoke methods, pass as an argument, return the current object, and call the constructor of the same class.


