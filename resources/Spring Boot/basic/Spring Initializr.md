## Set up a Spring Boot project using Spring Initializr

To manually set up a Spring Boot project using Spring Initializr with Maven, follow these steps:

### 1. **Go to Spring Initializr**
   - Open your browser and go to [Spring Initializr](https://start.spring.io).

### 2. **Configure Project Metadata**
   - **Project:** Choose "Maven Project".
   - **Language:** Select "Java".
   - **Spring Boot:** Choose the desired version.
   - **Project Metadata:**
     - **Group:** e.g., `com.example`
     - **Artifact:** e.g., `demo`
     - **Name:** e.g., `Demo`
     - **Description:** e.g., `A demo Spring Boot project`
     - **Package name:** e.g., `com.example.demo`
     - **Packaging:** Choose "Jar" or "War" depending on your needs.
     - **Java:** Choose the version compatible with your setup.

### 3. **Add Dependencies**
   - **Spring Web:** For REST APIs and web applications.
   - **Spring Data JPA:** For database operations.
   - **H2 Database:** For in-memory database (optional, for testing).
   - **Spring Boot DevTools:** For easier development.

### 4. **Generate the Project**
   - Click the "Generate" button. This will download a ZIP file containing your project.

### 5. **Extract the Project**
   - Unzip the downloaded file to a directory of your choice.

### 6. **Open the Project in Your IDE**
   - Open your IDE (e.g., IntelliJ IDEA, Eclipse).
   - Import the project as a Maven project.

### 7. **Build and Run the Project**
   - In your IDE, navigate to the main class (e.g., `DemoApplication.java` in `src/main/java/com/example/demo`).
   - Right-click on the file and select "Run" to start the application.
   - Alternatively, you can run the application from the command line:
     ```bash
     ./mvnw spring-boot:run
     ```

### 8. **Verify the Application**
   - Open your browser and navigate to `http://localhost:8080` to ensure the application is running.

### 9. **Customize Your Application**
   - Start adding your custom code, such as controllers, services, and repositories.

### Example Directory Structure:
```
demo
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── demo
│   │   │               ├── DemoApplication.java
│   │   │               └── ...
│   │   └── resources
│   │       ├── application.properties
│   │       └── ...
├── .gitignore
├── pom.xml
└── ...
```

You now have a basic Spring Boot application set up and ready for development!
