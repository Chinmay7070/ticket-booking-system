# 🎬 Movie Ticket Booking System – Microservices Architecture (Backend Only)

This is a **backend-only Movie Ticket Booking System** built using **Spring Boot Microservices**.  
There is **NO frontend/UI** — all interactions happen through **REST APIs** using Postman or any HTTP client.

The project demonstrates a real microservices architecture using:
- API Gateway
- Eureka Service Registry
- Booking Service
- Payment Service
- Docker & Docker Compose
- Inter-service REST communication
- DTOs, Entities, Service Interfaces, Repositories

---
## 📌 Architecture Overview

```
  Client (Postman / API Client)
           │
           ▼
    API Gateway (Routing)
           │
 ┌─────────┴──────────┐
 ▼                    ▼
Booking Service → Payment Service
           │
           ▼
    Eureka Service Registry
    
----------------------------------------------------------------------------    

 🧑‍💻 Client → 🚪 API Gateway → 🎟️ Booking Service → 💳 Payment Service  
                       ↓
                📘 Eureka Server


```

Each microservice runs independently and registers itself in **Eureka**.  
The **API Gateway** routes all API requests to appropriate microservices.

---

## 🏗 Microservices Included

### 🔹 1. **API Gateway**
- Acts as the single entry point for all client requests
- Routes requests to Booking and Payment services
- Built using **Spring Cloud Gateway**
- Supports simple load balancing

---

### 🔹 2. **Eureka Server (Service Registry)**
- All services register dynamically
- Enables discovery of microservices
- Avoids hardcoding service URLs

---

### 🔹 3. **Booking Service**
Handles:
- Creating a booking
- Validating input
- Communicating with Payment Service
- Returning booking status

Includes:
- `IBookingService` (interface)
- `BookingServiceIMpl` (implementation)
- `BookingRepository` (JPA)
- DTOs, Entities
- Exception handling

---

### 🔹 4. **Payment Service**
Responsible for:
- Payment initialization
- Payment verification
- Returning payment status

Includes:
- Payment service interface & implementation
- `IPaymentRepo`
- DTOs, Entities
- Razorpay (optional integration)

---

## 🚀 Technologies Used

| Component | Technology |
|----------|------------|
| Backend | Spring Boot |
| Routing | Spring Cloud Gateway |
| Service Discovery | Eureka Netflix |
| Build Tool | Maven |
| Communication | REST APIs |
| Language | Java |
| Deployment | Docker, Docker Compose |

---

## 🗂 Project Structure
## 🗂 Project Structure

```
📂 New folder/
├── 📁 api_gateway/
├── 📁 booking_Service/
├── 📁 movie-services-registry/
├── 📁 payment_sservice/
├── 🐳 docker-compose.yaml
├── 📄 pom.xml
└── 📘 README.md
```
## ⚙️ How to Run the Project

This project is **backend-only**, so everything is tested using **Postman / API clients**.  
You can run the services **manually** or using **Docker Compose**.

---

### ▶️ **1️⃣ Start Eureka Server**
```
cd movie-services-registry
mvn spring-boot:run
```

### ▶️ **2️⃣ Start API Gateway**
```
cd api_gateway
mvn spring-boot:run
```

### ▶️ **3️⃣ Start Booking Service**
```
cd booking_Service
mvn spring-boot:run
```

### ▶️ **4️⃣ Start Payment Service**
```
cd payment_sservice
mvn spring-boot:run
```

---

## 🐳 Run Using Docker (Recommended)

This project includes **Dockerfile** for each microservice and a **docker-compose.yaml** to start everything together.

### ▶️ **Start All Services**
```
docker-compose up --build
```

### ▶️ **Stop All Services**
```
docker-compose down
```

### 🧩 Services Started by Docker
| Service | Port |
|---------|------|
| 🟦 Eureka Server | 8761 |
| 🟩 API Gateway | 8080 |
| 🟧 Booking Service | 8081 |
| 🟥 Payment Service | 8082 |

You can open Eureka Dashboard at:

👉 **http://localhost:8761/**

