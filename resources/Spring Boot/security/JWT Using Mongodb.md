## Spring Boot Login and Registration example with MongoDB

To create comprehensive code documentation for the project in the given GitHub repository, I'll outline the project structure and include relevant code snippets from the repository. This will help provide a clear understanding of how the code is organized and what each part does.

### Project Structure

Here’s a high-level view of the project structure:

```
spring-boot-login-mongodb/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── bezkoder/
│                   └── spring/
│                       └── security/
│                           └── mongodb/
│                               ├── controller/
│                               │   ├── AuthController.java
│                               │   └── TestController.java
│                               ├── models/
│                               │   ├── ERole.java
│                               │   ├── Role.java
│                               │   └── User.java
│                               ├── payload/
│                               │   ├── request/
│                               │   │   ├── LoginRequest.java
│                               │   │   └── SignupRequest.java
│                               │   └── response/
│                               │       ├── MessageResponse.java
│                               │       └── UserInfoResponse.java
│                               ├── repository/
│                               │   ├── UserRepository.java
│                               │   └── RoleRepository.java
│                               ├── security/
│                               │   ├── services/
│                               │   │   ├── UserDetailsImpl.java
│                               │   │   └── UserDetailsServiceImpl.java
│                               │   └── jwt/
│                               │       ├── AuthEntryPointJwt.java
│                               │       ├── AuthTokenFilter.java
│                               │       └── JwtUtils.java
│                               │   └── WebSecurityConfig.java
│                               └── SpringBootMongodbLoginApplication.java
├── pom.xml
└── src/main/resources/
    └── application.yml

```

### Code Documentation

#### `pom.xml`
Configures security settings, including JWT authentication and authorization.

```java<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.1.0</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.bezkoder</groupId>
	<artifactId>spring-boot-mongodb-login</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>spring-boot-mongodb-login</name>
	<description>Spring Boot and MongoDB: Login example with Spring Security, JWT - Rest API</description>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-mongodb</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		
    <dependency>
      <groupId>io.jsonwebtoken</groupId>
      <artifactId>jjwt-api</artifactId>
      <version>0.11.5</version>
    </dependency>

    <dependency>
      <groupId>io.jsonwebtoken</groupId>
      <artifactId>jjwt-impl</artifactId>
      <version>0.11.5</version>
      <scope>runtime</scope>
    </dependency>

    <dependency>
      <groupId>io.jsonwebtoken</groupId>
      <artifactId>jjwt-jackson</artifactId>
      <version>0.11.5</version>
      <scope>runtime</scope>
    </dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>

```
#### `application.yml`

```javabezkoder:
  app:
    jwtCookieName: bezkoder
    jwtExpirationMs: 86400000
    jwtSecret: ======================BezKoder=Spring===========================
spring:
  data:
    mongodb:
      database: test
      host: localhost
      port: 27017
```

#### `JwtAuthEntryPoint.java`
Handles unauthorized access attempts.

```java
package com.bezkoder.spring.security.mongodb.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -7858869558953243875L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}
```

#### `AuthController.java`
Handles authentication requests.

```java
package com.bezkoder.spring.security.mongodb.controller;

import com.bezkoder.spring.security.mongodb.model.JwtResponse;
import com.bezkoder.spring.security.mongodb.model.User;
import com.bezkoder.spring.security.mongodb.repository.UserRepository;
import com.bezkoder.spring.security.mongodb.security.JwtUtils;
import com.bezkoder.spring.security.mongodb.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public JwtResponse authenticateUser(@RequestBody User user) throws AuthenticationException {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwt = jwtUtils.generateJwtToken(userDetails);
        return new JwtResponse(jwt);
    }
}
```

#### `User.java`
Represents the user model.

```java
package com.bezkoder.spring.security.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String username;
    private String password;
    private String role;

    // Getters and Setters
}
```

#### `JwtAuthFilter.java`
Intercepts HTTP requests to validate JWT.

```java
package com.bezkoder.spring.security.mongodb.security;

import com.bezkoder.spring.security.mongodb.config.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private JwtUtils jwtUtils;

    public JwtAuthFilter(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        String jwt = jwtUtils.getJwtFromRequest(request);
        if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
            SecurityContextHolder.getContext().setAuthentication(jwtUtils.getAuthentication(jwt));
        }
        chain.doFilter(request, response);
    }
}
```

#### `JwtUtils.java`
Utility class for JWT operations.

```java
package com.bezkoder.spring.security.mongodb.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public UserDetailsImpl getAuthentication(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        String username = claims.getSubject();
        return new UserDetailsImpl(username, "", Collections.emptyList());
    }
}
```

#### `SpringBootLoginMongodbApplication.java`
Main application class to run the Spring Boot application.

```java
package com.bezkoder.spring.security.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLoginMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLoginMongodbApplication.class, args);
    }
}
```

### Summary
This documentation provides an overview of the project structure and key components of the code. Each class serves a specific purpose, from configuring security settings to handling JWT authentication and user management. For a full understanding, you might want to review the complete repository directly. If you need more details on any specific part, let me know!
