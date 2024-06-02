
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
Access specifiers control the visibility of a method. There are four types: `public`, `private`, `protected`, and default (no specifier).

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
   public <T> T getFirst(List<T> list) {
       return list.get(0);
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
```java
public abstract class AbstractMethodExample {
    // Abstract method
    public abstract void display();

    public static void main(String[] args) {
        // Cannot create an instance of an abstract class
        // AbstractMethodExample obj = new AbstractMethodExample();
    }
}

public class ConcreteClass extends AbstractMethodExample {
    // Implementation of the abstract method
    @Override
    public void display() {
        System.out.println("Abstract method implementation");
    }

    public static void main(String[] args) {
        ConcreteClass obj = new ConcreteClass();
        obj.display();
    }
}
```

### Factory Method
A factory method is a static method that creates and returns instances of a class.

Example:
```java
public class FactoryMethodExample {
    private int value;

    private FactoryMethodExample(int value) {
        this.value = value;
    }

    // Factory method
    public static FactoryMethodExample createInstance(int value) {
        return new FactoryMethodExample(value);
    }

    public static void main(String[] args) {
        FactoryMethodExample obj = FactoryMethodExample.createInstance(100);
        System.out.println("Value: " + obj.value);
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
