### Step 1: Create a Spring Boot Project - Postgres With DB Mapping (@OneToMany,@ManyToMany,@ManyToOne)
)

You can create a Spring Boot project using Spring Initializr or manually create a Maven project. Below are the steps to set it up manually:

1. **Create a new Maven project**. https://github.com/meghnadsaha/java-oops/blob/master/resources/Spring%20Boot/basic/Spring%20Initializr.md
2. **Add the necessary dependencies** to the `pom.xml`.

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
		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.10.1</version>
		</dependency>
</dependencies>
```

### Step 2: Configure `application.yml`

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

### Step 3: Create Entity Classes with Relationships

1. **Student Entity** (`src/main/java/com/example/demo/model/Student.java`):

```java
package com.example.employeeservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_club",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "club_id"))
    private List<Club> clubs;

    @ManyToOne//(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
//    @JsonIgnore  // Add this to avoid cyclic serialization
    private Course course;


}

```

2. **Course Entity** (`src/main/java/com/example/demo/model/Course.java`):

```java
package com.example.employeeservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

//    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY) // Consider using FetchType.EAGER if needed
    @OneToMany(mappedBy = "course")
    @JsonIgnore // Avoid cyclic references in JSON serialization
    private List<Student> students;
}

```

3. **Club Entity** (`src/main/java/com/example/demo/model/Club.java`):

```java
package com.example.employeeservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @ManyToMany(mappedBy = "clubs")
    @JsonIgnore  // Add this to avoid cyclic serialization
    private List<Student> students;


}

```

### Step 4: Create Repositories

1. **StudentRepository** (`src/main/java/com/example/demo/repository/StudentRepository.java`):

```java
package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
```

2. **CourseRepository** (`src/main/java/com/example/demo/repository/CourseRepository.java`):

```java
package com.example.demo.repository;

import com.example.demo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
```

3. **ClubRepository** (`src/main/java/com/example/demo/repository/ClubRepository.java`):

```java
package com.example.demo.repository;

import com.example.demo.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
}
```

### Step 5: Create Services

1. **StudentService** (`src/main/java/com/example/demo/service/StudentService.java`):

```java
package com.example.employeeservice.Service;

import com.example.employeeservice.Repository.StudentRepository;
import com.example.employeeservice.model.Club;
import com.example.employeeservice.model.Course;
import com.example.employeeservice.model.Student;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ClubService clubService;

    public List<Student> getAllStudents () {
        return studentRepository.findAll();
    }

    public Student getStudentById ( Long id ) {
        return studentRepository.findById(id)
                                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
    }

    public Student createStudent ( Student student ) {

        Course course = courseService.getCourseById(student.getCourse().getId());
        student.setCourse(course);

        // Fetch clubs by their IDs
//        List<Long> list = new ArrayList<>();
//        for (Club club : student.getClubs()) {
//            Long id = club.getId();
//            list.add(id);
//        }
//        List<Club> clubs = clubService.getAllClubsByStudentId(
//                list
//        );
        List<Club> clubs = clubService.getAllClubsByStudentId(
                student.getClubs().stream().map(Club::getId).collect(Collectors.toList())
        );
        student.setClubs(clubs);

        return studentRepository.save(student);
    }


    @Transactional
    public Student updateStudent ( Long id , Student studentUpdate ) {
        // Fetch existing student
        Student existingStudent = getStudentById(id);
        // Update student details
        existingStudent.setName(studentUpdate.getName());

        // Fetch and update course
        Course course = courseService.getCourseById(studentUpdate.getCourse().getId());
        existingStudent.setCourse(course);

        // Fetch and update clubs
        List<Club> clubs = clubService.getAllClubsByStudentId(
                studentUpdate.getClubs().stream().map(Club::getId).collect(Collectors.toList()));
        existingStudent.setClubs(clubs);
        // Fetch and update clubs
//        List<Long> list = new ArrayList<>();
//        for (Club club : studentUpdate.getClubs()) {
//            Long clubId = club.getId();
//            list.add(clubId);
//        }
//        List<Club> clubs = clubRepository.findAllById(
//                list
//        );

        return studentRepository.save(existingStudent);
    }


    public void deleteStudent ( Long id ) {
        studentRepository.deleteById(id);
    }
}

```

2. **CourseService** (`src/main/java/com/example/demo/service/CourseService.java`):

```java
package com.example.employeeservice.Service;

import com.example.employeeservice.Repository.CourseRepository;
import com.example.employeeservice.model.Course;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses () {
        return courseRepository.findAll();
    }

    public Course getCourseById ( Long id ) {
        return courseRepository.findById(id)
                               .orElseThrow(() -> new EntityNotFoundException("Course not found"));
    }

    public Course createCourse ( Course course ) {
        return courseRepository.save(course);
    }

    public Course updateCourse ( Long id , Course courseDetails ) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            course.setTitle(courseDetails.getTitle());
//            course.setStudent(courseDetails.getStudent());
            return courseRepository.save(course);
        }
        return null;
    }

    public void deleteCourse ( Long id ) {
        courseRepository.deleteById(id);
    }


}

```

3. **ClubService** (`src/main/java/com/example/demo/service/ClubService.java`):

```java
package com.example.employeeservice.Service;

import com.example.employeeservice.Repository.ClubRepository;
import com.example.employeeservice.model.Club;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;

    public List<Club> getAllClubs () {

        return clubRepository.findAll();
    }

    public Club getClubById ( Long id ) {

        return clubRepository.findById(id)
                             .orElseThrow(() -> new EntityNotFoundException("No clubs found for the provided IDs"));

    }

    public List<Club> getAllClubsByStudentId ( List<Long> list ) {

        List<Club> clubs = clubRepository.findAllById(list).stream()
                                         .filter(club -> club != null) // Ensure no null clubs
                                         .collect(Collectors.toList());

        // Check if the result is empty and throw an exception if necessary
        if (clubs.isEmpty()) {
            throw new EntityNotFoundException("No clubs found for the provided IDs");
        }

        return clubs;

    }

    public Club createClub ( Club club ) {
        return clubRepository.save(club);
    }

    public Club updateClub ( Long id , Club clubDetails ) {
        Club club = clubRepository.findById(id).orElse(null);
        if (club != null) {
            club.setName(clubDetails.getName());
            club.setStudents(clubDetails.getStudents());
            return clubRepository.save(club);
        }
        return null;
    }

    public void deleteClub ( Long id ) {
        clubRepository.deleteById(id);
    }
}

```

### Step 6: Create Controllers

1. **StudentController** (`src/main/java/com/example/demo/controller/StudentController.java`):

```java
package com.example.employeeservice.controller;

import com.example.employeeservice.Repository.ClubRepository;
import com.example.employeeservice.Repository.CourseRepository;
import com.example.employeeservice.Service.ClubService;
import com.example.employeeservice.Service.CourseService;
import com.example.employeeservice.Service.StudentService;
import com.example.employeeservice.model.Club;
import com.example.employeeservice.model.Course;
import com.example.employeeservice.model.Student;
import com.example.employeeservice.util.CommonUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CommonUtil commonUtil;


    @GetMapping
    public List<Student> getAllStudents () {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById ( @PathVariable(value = "id") Long id ) {
        Student student = studentService.getStudentById(id);
        return student != null?ResponseEntity.ok().body(student):ResponseEntity.notFound().build();
    }

    @PostMapping
    public Student createStudent ( @Valid @RequestBody Student student ) {
        commonUtil.printJson("Student object : ",student);
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long id,
                                                 @Valid @RequestBody Student studentDetails) {
        commonUtil.printJson("Student Details object : ",studentDetails);
        Student updatedStudent = studentService.updateStudent(id, studentDetails);
        return updatedStudent != null ? ResponseEntity.ok().body(updatedStudent) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent ( @PathVariable(value = "id") Long id ) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}

```

2. **CourseController** (`src/main/java/com/example/demo/controller/CourseController.java`):

```javapackage com.example.employeeservice.controller;

import com.example.employeeservice.Repository.CourseRepository;
import com.example.employeeservice.Repository.StudentRepository;
import com.example.employeeservice.Service.CourseService;
import com.example.employeeservice.dto.CourseRequest;
import com.example.employeeservice.exception.ResourceNotFoundException;
import com.example.employeeservice.model.Course;
import com.example.employeeservice.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable(value = "id") Long id) {
        Course course = courseService.getCourseById(id);
        return course != null ? ResponseEntity.ok().body(course) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Course createCourse(@Valid @RequestBody Course course) {
        return courseService.createCourse(course);
    }

//    @PostMapping
//    public ResponseEntity<Course> createCourse(@RequestBody CourseRequest courseRequest) {
//        // Check if studentId is provided
//        if (courseRequest.getStudentId() == null) {
//            return ResponseEntity.badRequest().body(null); // or handle as needed
//        }
//
//        Student student = studentRepository.findById(courseRequest.getStudentId())
//                                           .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
//
//        Course course = new Course();
//        course.setTitle(courseRequest.getTitle());
//        course.setStudent(student);
//
//        Course savedCourse = courseRepository.save(course);
//
//        return ResponseEntity.ok(savedCourse);
//    }


    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable(value = "id") Long id,
                                               @Valid @RequestBody Course courseDetails) {
        Course updatedCourse = courseService.updateCourse(id, courseDetails);
        return updatedCourse != null ? ResponseEntity.ok().body(updatedCourse) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable(value = "id") Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }
}

```

3. **ClubController** (`src/main/java/com/example/demo/controller/ClubController.java`):

```java
package com.example.demo.controller;

import com.example.demo.model.Club;
import com.example.demo.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping
    public List<Club> getAllClubs() {
        return clubService.getAllClubs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Club> getClubById(@PathVariable(value = "id") Long id) {
        Club club = clubService.getClubById(id);
        return club != null ? ResponseEntity.ok().body(club) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Club createClub(@Valid @RequestBody Club club) {
        return clubService.createClub(club);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Club> updateClub(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Club clubDetails) {
        Club updatedClub = clubService.updateClub(id, clubDetails);
        return updatedClub != null ? ResponseEntity.ok().body(updatedClub) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClub(@PathVariable(value = "id") Long id) {
        clubService.deleteClub(id);
        return ResponseEntity.ok().build();
    }
}
```

### Step 7: Build and Run the Project

1. **Clean and build the project** using Maven:

```bash
mvn clean install -DskipTests
```

2. **Run the application**:

```bash
mvn spring-boot:run
```

This setup will give you a fully functional Spring Boot application with CRUD APIs for `Student`, `Course`, and `Club` entities, including one-to-many, many-to-one, and many-to-many relationships.

### Additional Notes:

- **Ensure PostgreSQL is running** and accessible with the credentials provided in `application.yml`.
- **Make sure you have Lombok installed** in your IDE to avoid compilation errors.
- **Add more validation and error handling** as needed in the services and controllers.


Here are the cURL commands for interacting with `CourseController`, `StudentController`, and `ClubController`. I will include the cURL commands for basic CRUD operations and provide commands to create 10 objects for each entity.

### **PostMan Collection `**
https://api.postman.com/collections/37581217-4238e1d2-a36b-4e14-af97-11a2634a9e70?access_key=PMAT-01J53KTGGA2WZ13ZE1KCKS9QCJ


The `Student` class has two relationships: a `ManyToMany` relationship with the `Club` class and a `ManyToOne` relationship with the `Course` class. Here's a detailed explanation of each relationship and how they work in the context of your application:

### 1. **Many-to-Many Relationship with Club**

#### Code:
```java
@ManyToMany
@JoinTable(
    name = "student_club",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "club_id")
)
private List<Club> clubs;
```

#### Explanation:

- **`@ManyToMany` Annotation**: 
  - This annotation indicates that the `Student` class has a many-to-many relationship with the `Club` class. In a many-to-many relationship, each student can be associated with multiple clubs, and each club can have multiple students.

- **`@JoinTable` Annotation**:
  - The `@JoinTable` annotation specifies the join table that will be used to manage this many-to-many relationship in the database. This table will link the `students` table with the `clubs` table.

- **`name = "student_club"`**:
  - The `name` attribute specifies the name of the join table. In this case, the table is named `student_club`.

- **`@JoinColumn(name = "student_id")`**:
  - The `joinColumns` attribute specifies the foreign key column in the join table that refers to the `Student` entity. Here, `student_id` is the foreign key column that references the `id` of the `Student`.

- **`@JoinColumn(name = "club_id")`**:
  - The `inverseJoinColumns` attribute specifies the foreign key column in the join table that refers to the `Club` entity. Here, `club_id` is the foreign key column that references the `id` of the `Club`.

#### SQL Representation:

This relationship creates a new join table in the database:

```sql
CREATE TABLE student_club (
    student_id BIGINT,
    club_id BIGINT,
    PRIMARY KEY (student_id, club_id),
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (club_id) REFERENCES clubs(id)
);
```

This table will contain entries that link students to clubs, allowing a student to be a member of multiple clubs and each club to have multiple members.

### 2. **Many-to-One Relationship with Course**

#### Code:
```java
@ManyToOne
@JoinColumn(name = "course_id")
private Course course;
```

#### Explanation:

- **`@ManyToOne` Annotation**:
  - This annotation indicates a many-to-one relationship between `Student` and `Course`. Many students can be associated with a single course, but each student can only be enrolled in one course at a time.

- **`@JoinColumn(name = "course_id")`**:
  - This annotation specifies the foreign key column in the `students` table that links to the `Course` entity. The `course_id` column will store the `id` of the associated `Course`.

#### SQL Representation:

This relationship adds a foreign key column in the `students` table:

```sql
CREATE TABLE students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    course_id BIGINT,
    FOREIGN KEY (course_id) REFERENCES courses(id)
);
```

### How These Relationships Work Together:

- **Many-to-Many with Clubs**:
  - Each student can join multiple clubs, and each club can have multiple students. This is managed by the `student_club` join table.
  
- **Many-to-One with Course**:
  - Each student is enrolled in one course, and this relationship is managed directly within the `students` table by the `course_id` foreign key.

### Example Scenario:

1. **Joining Clubs**:
   - Student "John Doe" can join both the "Photography Club" and the "Debate Club". The `student_club` table will have entries linking John Doe's `student_id` to the `club_id` of each club.

2. **Enrolling in a Course**:
   - John Doe can be enrolled in the "Computer Science" course. The `course_id` in the `students` table for John Doe will reference the `id` of the "Computer Science" course.

### Summary:
- The `ManyToMany` relationship between `Student` and `Club` allows students to participate in multiple clubs, with the relationship managed through a join table.
- The `ManyToOne` relationship between `Student` and `Course` assigns each student to one course, with the foreign key stored directly in the `students` table. 

This structure allows the application to manage students' club memberships and course enrollments efficiently.



Based on the relationships between `Club`, `Student`, and `Course` in your Spring Boot application, the SQL table structure and sample queries would be as follows:

### 1. **SQL Table Structure**

#### `courses` Table
```sql
CREATE TABLE courses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
```

#### `clubs` Table
```sql
CREATE TABLE clubs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
```

#### `students` Table
```sql
CREATE TABLE students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    course_id BIGINT,
    FOREIGN KEY (course_id) REFERENCES courses(id)
);
```

#### `student_club` (Join Table for Many-to-Many Relationship between `students` and `clubs`)
```sql
CREATE TABLE student_club (
    student_id BIGINT,
    club_id BIGINT,
    PRIMARY KEY (student_id, club_id),
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (club_id) REFERENCES clubs(id)
);
```

### 2. **Sample SQL Queries**

#### Insert a Course
```sql
INSERT INTO courses (name) VALUES ('Computer Science');
```

#### Insert a Club
```sql
INSERT INTO clubs (name) VALUES ('Photography Club');
```

#### Insert a Student
```sql
INSERT INTO students (name, course_id) VALUES ('John Doe', 1);
```

#### Enroll a Student in a Club
```sql
INSERT INTO student_club (student_id, club_id) VALUES (1, 1);
```

#### Select All Students Enrolled in a Specific Course
```sql
SELECT s.id, s.name 
FROM students s
JOIN courses c ON s.course_id = c.id
WHERE c.name = 'Computer Science';
```

#### Select All Clubs a Specific Student is Enrolled In
```sql
SELECT c.id, c.name 
FROM clubs c
JOIN student_club sc ON c.id = sc.club_id
JOIN students s ON s.id = sc.student_id
WHERE s.name = 'John Doe';
```

#### Select All Students in a Specific Club
```sql
SELECT s.id, s.name 
FROM students s
JOIN student_club sc ON s.id = sc.student_id
JOIN clubs c ON c.id = sc.club_id
WHERE c.name = 'Photography Club';
```

### Summary:
- The `courses` and `clubs` tables store course and club data.
- The `students` table stores student data and includes a foreign key `course_id` to associate a student with a course.
- The `student_club` table is a join table to manage the many-to-many relationship between students and clubs.
- Sample SQL queries demonstrate how to insert and retrieve data related to students, courses, and clubs.

This structure and these queries provide a robust foundation for managing the relationships between students, courses, and clubs in your application.



In JPA (Java Persistence API), `EAGER` and `LAZY` loading strategies control how and when related entities are fetched from the database. Here’s a detailed explanation of both strategies, including when to use each and examples.

### **EAGER Loading**

**Definition:**
- `EAGER` loading means that related entities are fetched immediately with the parent entity. When you retrieve the parent entity, all related entities are fetched as well.

**When to Use:**
- **When you always need the related entities:** Use `EAGER` loading if you frequently require the related data alongside the parent entity and want to avoid multiple queries.
- **When the amount of related data is manageable:** `EAGER` loading can lead to performance issues if related data is large or complex, resulting in long load times.

**Example Scenario:**
- A `Student` entity has a `Course` entity, and you always need the course details whenever you retrieve a student.

**Code Example:**

```java
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER) // EAGER loading
    @JoinColumn(name = "course_id")
    private Course course;

    // Getters and Setters
}
```

In this example, every time you retrieve a `Student`, the associated `Course` is also fetched immediately.

### **LAZY Loading**

**Definition:**
- `LAZY` loading means that related entities are fetched only when they are accessed. The related entities are loaded on-demand, i.e., when you actually access them.

**When to Use:**
- **When related data is not always needed:** Use `LAZY` loading if the related data is optional or if it might not be needed in every scenario.
- **When dealing with large data sets:** `LAZY` loading helps in reducing initial load times and avoids performance issues associated with fetching large amounts of data.

**Example Scenario:**
- A `Course` entity has multiple `Student` entities, and you do not always need to load all students when you fetch a course.

**Code Example:**

```java
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY) // LAZY loading
    private List<Student> students;

    // Getters and Setters
}
```

In this example, the `students` list in `Course` is fetched only when you explicitly access it. This reduces the initial load time of a `Course` entity.

### **Example Comparison**

**Scenario:**
- Suppose you have an `Author` entity with a collection of `Books`, and you want to fetch an `Author` along with their `Books`.

**Using EAGER Loading:**

```java
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER) // EAGER loading
    private List<Book> books;

    // Getters and Setters
}
```

**Using LAZY Loading:**

```java
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY) // LAZY loading
    private List<Book> books;

    // Getters and Setters
}
```

**Behavior:**

- **EAGER:** Fetching an `Author` will also fetch all associated `Books` in one query. This might be useful if you always need the books whenever you access an author.
- **LAZY:** Fetching an `Author` will not immediately fetch the `Books`. Instead, when you access the `books` collection, a separate query will be executed to fetch the books. This approach helps in optimizing performance if you don’t always need the related data.

### **When to Choose Each:**

- **EAGER Loading**: Use when:
  - The related data is always needed with the parent entity.
  - The size of related data is manageable and doesn’t impact performance.

- **LAZY Loading**: Use when:
  - The related data is not always needed.
  - You want to avoid loading unnecessary data to improve performance.
  - Dealing with potentially large datasets or complex object graphs.

### **Summary:**

- **EAGER Loading** fetches related data immediately, which can be beneficial when you always need the data but might cause performance issues with large datasets.
- **LAZY Loading** fetches related data only when accessed, improving initial performance and reducing memory usage but potentially causing multiple queries when accessing related data. 

Choose the loading strategy based on your application’s requirements and performance considerations.
