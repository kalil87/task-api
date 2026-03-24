# Task API

Simple REST API for task management built with Spring Boot, PostgreSQL (Neon), and deployed on Railway.

This project was created as a backend practice project to implement a RESTful API with validation, service layer separation, and global exception handling.

---

## Features

- RESTful API design
- CRUD operations for tasks
- Request validation using @Valid
- Global exception handling
- Layered architecture (Controller → Service → Repository)

---

## Tech Stack

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

## Requirements

- Java 17+
- Maven 3+

---

## 🌐 Live API

Base URL:
https://taskapi.up.railway.app

---

## 📄 Documentation (Swagger)

Swagger UI:
https://taskapi.up.railway.app/swagger-ui/index.html

---

## API Endpoints

| Method | Endpoint | Description |
|------|------|------|
| GET | /api/tasks | Get all tasks |
| GET | /api/tasks/{id} | Get task by id |
| POST | /api/tasks | Create task |
| PUT | /api/tasks/{id} | Update task |
| DELETE | /api/tasks/{id} | Delete task |

---

## Example Request

POST `/api/tasks`

```json
{
  "title": "Learn Spring Boot",
  "completed": false
}
```

## Example Response

```json
{
  "id": 1,
  "title": "Learn Spring Boot",
  "completed": false
}
```

## Validation Example

If validation fails, the API returns structured errors.

```json
{
  "title": "must not be blank"
}
```

## Error Handling

The API uses a **GlobalExceptionHandler** to handle errors like:

- Validation errors
- Task not found

Example error response:

```json
{
  "timestamp": "2026-03-09 12:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Task not found",
  "path": "/tasks/5"
}
```

## Health Check

Endpoint to verify the API is running:

GET `/api/health`

Example response:

```json
{
  "status": "OK"
}
```

---

## Project Structure

- controller
- service
- repository
- model
- dto
- mapper
- exception

---

## Architecture

Controller → Service → Repository → Database

---

## ⚙️ Environment Variables

The application requires the following environment variables:

- DB_URL
- DB_USER
- DB_PASSWORD
- PORT (optional, automatically provided by Railway)

---

## Profiles

The application uses Spring profiles:

- local → local development
- prod → production (Railway)

Railway uses environment variables to configure the database connection.

---

## Run locally

```json
1. Clone the repository

git clone https://github.com/kalil87/task-api.git

2. Go to the project folder

cd task-api

3. Configure database (application-prod.properties)

DB_URL=jdbc:postgresql://localhost:5432/your_db  
DB_USER=your_user  
DB_PASSWORD=your_password

4. Run the application

./mvnw spring-boot:run -Dspring-boot.run.profiles=prod

The API will start at:

http://localhost:8080
```

---

### API Usage

Base URL:

http://localhost:8080

Example endpoint:

GET http://localhost:8080/api/v1/tasks

---

## Author

GitHub: https://github.com/kalil87

---

This project is part of my backend development learning path.