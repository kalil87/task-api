# Task API - Spring Boot

Simple REST API for task management built with Spring Boot.

This project was created as a backend practice project to implement a RESTful API with validation, service layer separation, and global exception handling.

---

## Features

- Create tasks
- Get all tasks
- Get task by id
- Update tasks
- Delete tasks
- Request validation using `@Valid`
- Global exception handling
- Clean layered architecture (Controller → Service → Repository)

---

## Tech Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Jakarta Validation
- Maven

---

## Requirements

- Java 17+
- Maven

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

## Health / Test Endpoint

You can test the API using:

GET `/api/tasks`

Example response:

```json
[
  {
    "id": 1,
    "title": "Learn Spring Boot",
    "completed": false
  }
]
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

##  Architecture

Controller → Service → Repository → Database

---

## How to Run

Clone the repository:

`git clone https://github.com/kalil87/task-api.git`

Navigate to the project folder:

`cd task-api`

Run the application:

`./mvnw spring-boot:run`

The API will start at:

`http://localhost:8080`

---

##  Author

GitHub: https://github.com/kalil87