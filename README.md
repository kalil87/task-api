# 📌 Task API
![Release](https://img.shields.io/github/v/release/kalil87/task-api)
[![CI](https://github.com/kalil87/task-api/actions/workflows/release.yml/badge.svg)](https://github.com/kalil87/task-api/actions/workflows/release.yml)

Simple REST API for task management built with Spring Boot, PostgreSQL (Neon), and deployed on Railway.

This project was created as a backend practice project to implement a RESTful API with validation, service layer separation, and global exception handling.

---

## ⚙️ Features

- RESTful API design
- CRUD operations for tasks
- Request validation using @Valid
- Global exception handling
- Layered architecture (Controller → Service → Repository)

---

## 📦 Tech Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA (Hibernate)
- Jakarta Validation
- Maven
- PostgreSQL (Neon)
- Railway (deploy)
- Swagger (OpenAPI)

---

## ⚙️ Requirements

- Java 17+
- Maven 3+

---

## 🌐 Live API

Base URL:

https://taskapi.up.railway.app/api/v1/tasks

---

## 📝 Documentation (Swagger)

Swagger UI:

https://taskapi.up.railway.app/swagger-ui/index.html

---

## 📡 API Endpoints

| Method | Endpoint | Description |
|------|------|------|
| GET | /api/v1/tasks | Get all tasks |
| GET | /api/v1/tasks/{id} | Get task by id |
| POST | /api/v1/tasks | Create task |
| PUT | /api/v1/tasks/{id} | Update task |
| DELETE | /api/v1/tasks/{id} | Delete task |

---
## ⚙️ Pagination

You can paginate results using query parameters:

GET /api/v1/tasks?page=0&size=5&sort=id,asc

Parameters:

- page → page number (starts from 0)
- size → number of elements per page
- sort → field and direction (e.g., id,asc, title,desc or completed,asc)

---

## 📤 Example Request

POST `/api/v1/tasks`

```json
{
  "title": "Learn Spring Boot",
  "completed": false
}
```

## 📤 Example Response

```json
{
  "id": 1,
  "title": "Learn Spring Boot",
  "completed": false
}
```

## ⚠️ Error Handling

The API uses a **GlobalExceptionHandler** to handle errors like:

- Task not found
- Validation errors

Example Task Not Found error response:

```json
{
  "timestamp": "2026-03-09 12:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Task not found",
  "path": "/tasks/5"
}
```

Example Validation errors response:

If validation fails, the API returns structured errors.

```json
{
  "timestamp": "2026-03-26T14:29:24.2376194",
  "status": 400,
  "error": "Validation Error",
  "message": "Invalid request",
  "path": "/api/v1/tasks",
  "errors": {
    "completed": "completed must not be null",
    "title": "title must be between 3 and 50 characters"
  }
}
```

---
## 📊 Monitoring (Actuator)

Spring Boot Actuator is enabled to monitor application health.

Base URL:

https://taskapi.up.railway.app/actuator

Endpoint:

GET /actuator/health → application health status

Example:

también válido:

🩺 GET https://taskapi.up.railway.app/actuator/health

📈 GET https://taskapi.up.railway.app/actuator/info


```json
{
  "status": "UP"
}
```

---

## 📁 Project Structure

- controller
- service
- repository
- model
- dto
- mapper
- exception

---

## 📁 Architecture

Controller → Service → Repository → Database

---

## 🔐 Environment Variables

The application requires the following environment variables:

- DB_URL
- DB_USER
- DB_PASSWORD
- PORT (optional, automatically provided by Railway)

---

## ☁️ Profiles

The application uses Spring profiles:

- local → local development
- prod → production (Railway)

Railway uses environment variables to configure the database connection.

---

## 🚀 Run locally
        
1. **Clone the repository**

`git clone https://github.com/kalil87/task-api.`
        
2. **Go to the project directory**

`cd task-api`
        
3. **Run the application**

`./run-local.sh`

4. **API URL**

`http://localhost:8080/api/v1/tasks`


---

## 🧪 H2 Console (optional)

You can inspect the in-memory database at:

`http://localhost:8080/h2-console`

**JDBC URL:** `jdbc:h2:mem:testdb`  
**User:** `sa`  
**Password:** (empty)

---

### ⚙️ API Usage

Base URL:

`http://localhost:8080`

Example endpoint:

GET http://localhost:8080/api/v1/tasks

---

## 👤 Author

GitHub: https://github.com/kalil87

---

This project is part of my backend development learning path.