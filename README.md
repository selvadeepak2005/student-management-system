# 🎓 Student Management System

A **Spring Boot REST API** application developed to manage **Students** and **Departments** efficiently. The project follows a layered architecture using **Controller, DTO, Service, Service Implementation, Repository, and Entity** layers. It provides RESTful APIs for performing CRUD operations with proper exception handling and MySQL database integration.

---

## 🚀 Features

- 👨‍🎓 Student Management
  - Add Student
  - Get Student by ID
  - Get All Students
  - Update Student
  - Delete Student

- 🏢 Department Management
  - Add Department
  - Get Department Details

- 📦 DTO Pattern
- 🏗️ Layered Architecture
- ⚡ Spring Data JPA
- 💾 MySQL Database
- 🚨 Custom Exception Handling
- 🌐 RESTful APIs
- 🔄 Hibernate ORM

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- MySQL
- Maven
- Lombok
- Postman
- IntelliJ IDEA

---

## 📂 Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.selva.student_management_system
│   │       ├── Controller
│   │       │      ├── StudentController.java
│   │       │      └── DepartmentController.java
│   │       │
│   │       ├── Dto
│   │       │      ├── CreateStudentRequest.java
│   │       │      ├── CreateDepartmentRequest.java
│   │       │      ├── StudentResponse.java
│   │       │      └── DepartmentResponse.java
│   │       │
│   │       ├── Entity
│   │       │      ├── Student.java
│   │       │      └── Department.java
│   │       │
│   │       ├── Repository
│   │       │      ├── StudentRepository.java
│   │       │      └── DepartmentRepository.java
│   │       │
│   │       ├── Service
│   │       │      ├── StudentService.java
│   │       │      └── DepartmentService.java
│   │       │
│   │       ├── ServiceImpl
│   │       │      ├── StudentServiceImpl.java
│   │       │      └── DepartmentServiceImpl.java
│   │       │
│   │       ├── Exception
│   │       │      ├── DuplicateResourceException.java
│   │       │      └── ResourceNotFoundException.java
│   │       │
│   │       └── StudentManagementSystemApplication.java
│   │
│   └── resources
│       └── application.properties
│
└── pom.xml
```

---

## 🗄️ Database

```sql
CREATE DATABASE student_management_db;
```

Update the database configuration in:

```
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_management_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ How to Run

### Clone the Repository

```bash
git clone https://github.com/<YOUR_USERNAME>/student-management-system-springboot.git
```

### Navigate to the Project

```bash
cd student-management-system-springboot
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

Or run the `StudentManagementSystemApplication` class directly from IntelliJ IDEA.

---

## 🌐 REST API Endpoints

### Student APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/students` | Add Student |
| GET | `/students` | Get All Students |
| GET | `/students/{id}` | Get Student by ID |
| PUT | `/students/{id}` | Update Student |
| DELETE | `/students/{id}` | Delete Student |

### Department APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/departments` | Add Department |
| GET | `/departments/{id}` | Get Department by ID |

> **Note:** Update the endpoint paths if your controllers use different mappings.

---

## 🧪 Testing

Use **Postman** to test all REST APIs.

Example Student Request:

```json
{
  "studentName": "Selva Deepak",
  "email": "selva@gmail.com",
  "age": 21,
  "departmentId": 1
}
```

---

## 📚 Concepts Covered

- Spring Boot
- Spring Data JPA
- Hibernate ORM
- RESTful Web Services
- CRUD Operations
- DTO Pattern
- Layered Architecture
- Dependency Injection
- Exception Handling
- MySQL Integration
- Maven Build Tool

---

## 🔮 Future Enhancements

- Student Search
- Pagination and Sorting
- JWT Authentication
- Swagger API Documentation
- File Upload Support

---

## 👨‍💻 Author

**Selva Deepak**

- 🎓 BE – Electronics and Communication Engineering
- 💻 Java Full Stack Developer
- 🌱 Passionate about Java, Spring Boot, Hibernate, and Full Stack Development

---

## ⭐ Support

If you found this project useful, consider giving it a **⭐ Star** on GitHub.
