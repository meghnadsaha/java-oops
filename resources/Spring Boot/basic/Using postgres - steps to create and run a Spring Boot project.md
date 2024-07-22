To create a Spring Boot project with the given dependencies and configurations, and implement a CRUD API for employee management, follow these steps:

### Step 1: Create a Spring Boot Project

You can create a Spring Boot project using Spring Initializr:

1. Go to [Spring Initializr](https://start.spring.io/).
2. Select:
   - Project: Maven Project
   - Language: Java
   - Spring Boot: 2.7.x (or the latest stable version)
3. Add dependencies:
   - Spring Web
   - Spring Data JPA
   - PostgreSQL Driver
   - Spring Boot DevTools
   - Lombok
   - Spring Boot Starter Validation
   - Spring Boot Starter Test
   - Spring Boot Starter WebSocket
4. Generate the project and unzip it.

### Step 2: Add Dependencies to `pom.xml`

If you haven't added the dependencies in Spring Initializr, add them manually to your `pom.xml`:

```xml
<dependencies>
    <!-- Spring Boot Starter Web for RESTful APIs -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Starter Data JPA for working with databases -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- PostgreSQL Driver -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Spring Boot Starter Test for testing -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>

    <!-- Spring Boot DevTools for development -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>

    <!-- Spring Boot Starter Validation for input validation -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>

    <!-- Lombok for reducing boilerplate code -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>

    <!-- Jackson Data-bind for JSON processing -->
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
    </dependency>

    <!-- Spring Boot Starter for WebSocket -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-websocket</artifactId>
    </dependency>

    <!-- Spring Messaging (required for WebSocket) -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-messaging</artifactId>
    </dependency>
</dependencies>
```

### Step 3: Configure `application.yml`

Create an `application.yml` file in `src/main/resources` with the following content:

```yaml
spring:
  application:
    name: dish-api

  datasource:
    url: jdbc:postgresql://localhost:5432/postgres
    username: postgres
    password: mysecretpassword
    driver-class-name: org.postgresql.Driver
  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
      ddl-auto: update

server:
  port: 8081
```


### 3.1. Build and Run the Spring Boot Application
Navigate to the project directory and run the application using Maven.

#### Skip Tests and Run
To skip tests during the build and run the application:

```bash
mvn clean install -DskipTests
mvn spring-boot:run
```

#### Direct Run without Installing
Alternatively, you can directly run the Spring Boot application without installing it to the local repository:

```bash
mvn spring-boot:run -DskipTests
```

This command compiles the application and starts it, skipping the test phase.




### Step 4: Create Employee Entity

Create an `Employee` entity in `src/main/java/com/example/demo/model/Employee.java`:

```java
package com.example.demo.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @NotNull(message = "Age is mandatory")
    private Integer age;

    @NotBlank(message = "Department is mandatory")
    private String department;

    @NotBlank(message = "Status is mandatory")
    private String status;
}
```

### Step 5: Create Employee Repository

Create an `EmployeeRepository` interface in `src/main/java/com/example/demo/repository/EmployeeRepository.java`:

```java
package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
```

### Step 6: Create Employee Service

Create an `EmployeeService` class in `src/main/java/com/example/demo/service/EmployeeService.java`:

```java
package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setName(employeeDetails.getName());
            employee.setAddress(employeeDetails.getAddress());
            employee.setAge(employeeDetails.getAge());
            employee.setDepartment(employeeDetails.getDepartment());
            employee.setStatus(employeeDetails.getStatus());
            return employeeRepository.save(employee);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
```

### Step 7: Create Employee Controller

Create an `EmployeeController` class in `src/main/java/com/example/demo/controller/EmployeeController.java`:

```java
package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long id, @Valid @RequestBody Employee employeeDetails) {
        Employee employee = employeeService.updateEmployee(id, employeeDetails);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(value = "id") Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
```

### Step 8: Run the Project

To build and run the project, open a terminal and navigate to the project directory. Execute the following commands:

```bash
mvn clean install -DskipTests
mvn spring-boot:run
```

Your Spring Boot application should now be running on `http://localhost:8081`.

### Summary

You've created a Spring Boot project with the necessary dependencies, configured a PostgreSQL datasource, and implemented a CRUD API for employee management.



Here are the `curl` commands for all CRUD operations for the `Employee` entity, including adding 10 employee objects:

### 1. Create Employees

```bash
# Create Employee 1
curl -X POST http://localhost:8081/api/employees \
-H "Content-Type: application/json" \
-d '{
  "name": "John Doe",
  "address": "123 Main St",
  "age": 30,
  "department": "HR",
  "status": "Active"
}'

# Create Employee 2
curl -X POST http://localhost:8081/api/employees \
-H "Content-Type: application/json" \
-d '{
  "name": "Jane Smith",
  "address": "456 Oak St",
  "age": 25,
  "department": "Finance",
  "status": "Active"
}'

# Create Employee 3
curl -X POST http://localhost:8081/api/employees \
-H "Content-Type: application/json" \
-d '{
  "name": "Alice Johnson",
  "address": "789 Pine St",
  "age": 28,
  "department": "IT",
  "status": "Active"
}'

# Create Employee 4
curl -X POST http://localhost:8081/api/employees \
-H "Content-Type: application/json" \
-d '{
  "name": "Bob Brown",
  "address": "321 Maple St",
  "age": 35,
  "department": "Marketing",
  "status": "Active"
}'

# Create Employee 5
curl -X POST http://localhost:8081/api/employees \
-H "Content-Type: application/json" \
-d '{
  "name": "Charlie Davis",
  "address": "654 Elm St",
  "age": 32,
  "department": "Sales",
  "status": "Active"
}'

# Create Employee 6
curl -X POST http://localhost:8081/api/employees \
-H "Content-Type: application/json" \
-d '{
  "name": "Diana Evans",
  "address": "987 Cedar St",
  "age": 29,
  "department": "R&D",
  "status": "Active"
}'

# Create Employee 7
curl -X POST http://localhost:8081/api/employees \
-H "Content-Type: application/json" \
-d '{
  "name": "Edward Harris",
  "address": "135 Birch St",
  "age": 40,
  "department": "Operations",
  "status": "Active"
}'

# Create Employee 8
curl -X POST http://localhost:8081/api/employees \
-H "Content-Type: application/json" \
-d '{
  "name": "Fiona Green",
  "address": "246 Spruce St",
  "age": 26,
  "department": "Logistics",
  "status": "Active"
}'

# Create Employee 9
curl -X POST http://localhost:8081/api/employees \
-H "Content-Type: application/json" \
-d '{
  "name": "George Hill",
  "address": "357 Willow St",
  "age": 31,
  "department": "Customer Service",
  "status": "Active"
}'

# Create Employee 10
curl -X POST http://localhost:8081/api/employees \
-H "Content-Type: application/json" \
-d '{
  "name": "Hannah King",
  "address": "468 Poplar St",
  "age": 27,
  "department": "Legal",
  "status": "Active"
}'
```

### 2. Read All Employees

```bash
curl -X GET http://localhost:8081/api/employees
```

### 3. Read Single Employee

```bash
# Replace {id} with the actual employee ID
curl -X GET http://localhost:8081/api/employees/{id}
```

### 4. Update Employee

```bash
# Replace {id} with the actual employee ID
curl -X PUT http://localhost:8081/api/employees/{id} \
-H "Content-Type: application/json" \
-d '{
  "name": "Updated Name",
  "address": "Updated Address",
  "age": 33,
  "department": "Updated Department",
  "status": "Updated Status"
}'
```

### 5. Delete Employee

```bash
# Replace {id} with the actual employee ID
curl -X DELETE http://localhost:8081/api/employees/{id}
```

### Example of Using IDs

Assuming the IDs of the created employees are 1 to 10, here are the `curl` commands for operations on those employees:

#### Read All Employees

```bash
curl -X GET http://localhost:8081/api/employees
```

#### Read Employee with ID 1

```bash
curl -X GET http://localhost:8081/api/employees/1
```

#### Update Employee with ID 1

```bash
curl -X PUT http://localhost:8081/api/employees/1 \
-H "Content-Type: application/json" \
-d '{
  "name": "John Doe Updated",
  "address": "123 Main St Updated",
  "age": 31,
  "department": "HR Updated",
  "status": "Inactive"
}'
```

#### Delete Employee with ID 1

```bash
curl -X DELETE http://localhost:8081/api/employees/1
```

You can repeat the update and delete commands for other employee IDs by replacing the ID in the URL and the JSON payload as needed.
