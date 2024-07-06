To check the Python installation path on a Mac, you can use the terminal. Open the Terminal application and run the following command:

```bash
which python3
```

This command will give you the path to the Python 3 executable. If you're using Python 2, you can use:

```bash
which python
```

For more detailed information about the Python installation, you can run:

```bash
python3 -m site
```

This command provides information about the site-specific directories related to your Python installation.


Sure, here's a basic Python tutorial to get you started:

### 1. Installing Python

First, ensure Python is installed on your system. You can download it from [python.org](https://www.python.org/downloads/). Python 3.x is recommended.

### 2. Running Python

You can run Python in interactive mode by opening a terminal or command prompt and typing `python3` (or `python` if Python 3 is set as default). You can also write scripts in a `.py` file and run them using `python3 script.py`.

### 3. Python Basics

#### Variables and Data Types

```python
# String
name = "Alice"
print(name)

# Integer
age = 25
print(age)

# Float
height = 5.7
print(height)

# Boolean
is_student = True
print(is_student)
```

#### Lists

```python
# List
fruits = ["apple", "banana", "cherry"]
print(fruits)

# Accessing elements
print(fruits[0])  # apple

# Adding elements
fruits.append("date")
print(fruits)

# Removing elements
fruits.remove("banana")
print(fruits)
```

#### Tuples

```python
# Tuple
person = ("Alice", 25, 5.7)
print(person)

# Accessing elements
print(person[0])  # Alice
```

#### Dictionaries

```python
# Dictionary
student = {
    "name": "Alice",
    "age": 25,
    "is_student": True
}
print(student)

# Accessing elements
print(student["name"])  # Alice

# Adding elements
student["height"] = 5.7
print(student)

# Removing elements
del student["age"]
print(student)
```

#### Conditional Statements

```python
age = 25

if age < 18:
    print("Minor")
elif 18 <= age < 65:
    print("Adult")
else:
    print("Senior")
```

#### Loops

```python
# For loop
fruits = ["apple", "banana", "cherry"]
for fruit in fruits:
    print(fruit)

# While loop
count = 0
while count < 5:
    print(count)
    count += 1
```

#### Functions

```python
# Function definition
def greet(name):
    return f"Hello, {name}!"

# Function call
print(greet("Alice"))
```

### 4. Working with Files

#### Reading a File

```python
with open("example.txt", "r") as file:
    content = file.read()
    print(content)
```

#### Writing to a File

```python
with open("example.txt", "w") as file:
    file.write("Hello, world!")
```

### 5. Modules and Packages

You can import built-in modules or install third-party packages using `pip`.

#### Importing a Module

```python
import math
print(math.sqrt(16))  # 4.0
```

#### Installing and Using a Package

```bash
pip install requests
```

```python
import requests

response = requests.get("https://api.github.com")
print(response.status_code)
```

### 6. Object-Oriented Programming (OOP)

#### Classes and Objects

```python
class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def greet(self):
        return f"Hello, my name is {self.name} and I am {self.age} years old."

# Creating an object
alice = Person("Alice", 25)
print(alice.greet())
```

This covers the basics of Python. For more in-depth learning, you can refer to resources like [Python's official documentation](https://docs.python.org/3/tutorial/index.html) or online tutorials on platforms like [W3Schools](https://www.w3schools.com/python/) and [Real Python](https://realpython.com/).


### Object-Oriented Programming (OOP) in Python

Object-Oriented Programming (OOP) is a programming paradigm based on the concept of "objects", which are instances of classes. OOP allows for organizing code in a way that models real-world entities and relationships.

#### 1. Classes and Objects

A **class** is a blueprint for creating objects. An **object** is an instance of a class.

```python
# Defining a class
class Dog:
    # Class attribute
    species = "Canis familiaris"

    # Initializer / Instance attributes
    def __init__(self, name, age):
        self.name = name
        self.age = age

    # Instance method
    def description(self):
        return f"{self.name} is {self.age} years old."

    # Another instance method
    def speak(self, sound):
        return f"{self.name} says {sound}"

# Creating objects
buddy = Dog("Buddy", 9)
miles = Dog("Miles", 4)

# Accessing class attributes
print(buddy.species)  # Output: Canis familiaris
print(miles.species)  # Output: Canis familiaris

# Accessing instance attributes
print(buddy.name)  # Output: Buddy
print(miles.age)  # Output: 4

# Calling instance methods
print(buddy.description())  # Output: Buddy is 9 years old.
print(miles.speak("Woof Woof"))  # Output: Miles says Woof Woof
```

#### 2. Inheritance

Inheritance allows a class to inherit attributes and methods from another class.

```python
# Parent class
class Animal:
    def __init__(self, name):
        self.name = name

    def speak(self):
        raise NotImplementedError("Subclass must implement abstract method")

# Child class (inherits from Animal)
class Dog(Animal):
    def speak(self):
        return f"{self.name} says Woof!"

# Another child class (inherits from Animal)
class Cat(Animal):
    def speak(self):
        return f"{self.name} says Meow!"

# Creating objects
dog = Dog("Buddy")
cat = Cat("Whiskers")

print(dog.speak())  # Output: Buddy says Woof!
print(cat.speak())  # Output: Whiskers says Meow!
```

#### 3. Encapsulation

Encapsulation is the practice of restricting access to certain attributes and methods to prevent direct modification.

```python
class Car:
    def __init__(self, make, model, year):
        self.make = make
        self.model = model
        self.year = year
        self._odometer_reading = 0  # Protected attribute

    def read_odometer(self):
        return f"This car has {self._odometer_reading} miles on it."

    def update_odometer(self, mileage):
        if mileage >= self._odometer_reading:
            self._odometer_reading = mileage
        else:
            return "You can't roll back an odometer!"

car = Car("Toyota", "Corolla", 2020)
print(car.read_odometer())  # Output: This car has 0 miles on it.
car.update_odometer(150)
print(car.read_odometer())  # Output: This car has 150 miles on it.
```

#### 4. Polymorphism

Polymorphism allows for using a unified interface to interact with objects of different types.

```python
class Bird:
    def fly(self):
        return "Flies in the sky."

class Penguin(Bird):
    def fly(self):
        return "Cannot fly but swims."

def bird_flight(bird):
    print(bird.fly())

sparrow = Bird()
penguin = Penguin()

bird_flight(sparrow)  # Output: Flies in the sky.
bird_flight(penguin)  # Output: Cannot fly but swims.
```

#### 5. Magic Methods (Dunder Methods)

Magic methods are special methods that begin and end with double underscores (`__`). They allow for emulating built-in behavior within user-defined classes.

```python
class Book:
    def __init__(self, title, author, pages):
        self.title = title
        self.author = author
        self.pages = pages

    def __str__(self):
        return f"'{self.title}' by {self.author}"

    def __len__(self):
        return self.pages

book = Book("The Catcher in the Rye", "J.D. Salinger", 277)
print(book)  # Output: 'The Catcher in the Rye' by J.D. Salinger
print(len(book))  # Output: 277
```

These are the fundamental concepts of Object-Oriented Programming in Python. Mastering these concepts will help you create more organized, modular, and reusable code. For further learning, refer to the 
[Python OOP documentation](https://docs.python.org/3/tutorial/classes.html).
<hr>

[Python Tutorial - w3schools](https://www.w3schools.com/python/default.asp).




