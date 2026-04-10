# 🎼 Symphony Lite API

Backend API project designed to demonstrate scalable system design, clean architecture, and data-driven thinking.

---

# 🚀 Overview

Symphony Lite API is a backend system that allows users to:

* Create and join spaces
* Track user interactions (event-driven)
* Analyze data (top & trending spaces)

This project focuses on **clean architecture, scalability, and analytics**, simulating real-world backend systems.

---

# 🧠 Key Concepts Implemented

## 1. Clean Architecture

* Controller → Service → Repository separation
* DTOs for request/response
* Exception handling layer

## 2. Event Tracking System

All user actions are stored as interactions:

* JOIN
* (Extensible for future events)

This enables analytics and data-driven features.

## 3. Analytics Engine

* Top spaces (historical)
* Trending spaces (time-based)

Implemented using:

* SQL aggregation
* JOIN optimization (no N+1 problem)
* Projections for clean data handling

## 4. Scalability Considerations

* Avoided N+1 queries
* Used projections instead of Object[]
* Designed extensible event model

---

# 🛠️ Tech Stack

* Java 25
* Spring Boot 4
* Spring Data JPA
* H2 Database (in-memory)
* Lombok

---

# 📦 Project Structure

```
controller → API endpoints
service → business logic
repository → data access
model → entities
DTO → request/response
exception → global error handling
projection → analytics projections
```

---

# ⚙️ How to Run

## 1. Clone the repository

```
git clone https://github.com/your-username/symphony-lite-api.git
cd symphony-lite-api
```

## 2. Run the application

From IntelliJ or:

```
mvn spring-boot:run
```

---

# 🧪 API Endpoints

## Users

```
POST /api/users
```

## Spaces

```
POST /api/spaces
POST /api/spaces/{spaceId}/join/{userId}
```

## Analytics

```
GET /api/spaces/top
GET /api/spaces/trending?hours=24
```

---

# 🧪 Testing with Postman

Create a collection with:

* Create User
* Create Space
* Join Space
* Get Top Spaces
* Get Trending Spaces

---

# 🗄️ H2 Database

Access the in-memory database:

```
http://localhost:8080/h2-console
```

JDBC URL:

```
jdbc:h2:mem:symphony
```

---

# 📊 Example Use Case

1. Users join spaces
2. Interactions are tracked
3. System calculates:

    * Most popular spaces
    * Currently trending spaces

---

# 🚀 Future Improvements

* PostgreSQL + Docker
* Authentication (JWT)
* Real-time analytics
* Recommendation system

---

# 💡 What This Project Demonstrates

* Backend system design
* Data modeling and relationships
* Analytics and aggregation
* Performance optimization
* Clean and maintainable code

---

# 👨‍💻 Author

Software Engineering student focused on backend systems, data engineering, and scalable architectures.

---

# 🔥 Final Note

This project is designed not just as a CRUD API, but as a **data-driven backend system**, similar to real-world
platforms like Spotify or analytics-driven applications.
