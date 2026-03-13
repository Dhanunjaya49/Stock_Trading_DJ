# Stock Trading Backend

Spring Boot + PostgreSQL based stock trading simulation system.

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Hibernate

## Day 1 Progress
- Connected PostgreSQL
- Created User entity
- Hibernate auto-created users table
- Verified DB connection via pgAdmin

## How to Run
1. Install PostgreSQL
2. Create database `stockdb`
3. Update application.properties with DB credentials
4. Run StockDjApplication.java


📅 DAY 2 (90 Minutes)
🎯 Goal:

Create Repository layer
Insert a User into DB
Fetch user from DB
Understand how JPA works


DAY 3

What Service layer does
Dependency injection
Constructor injection
Clean separation of concerns
Basic business validation

# Stock Trading Backend

Spring Boot + PostgreSQL based stock trading simulation system.

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Hibernate
- Lombok

---

# Day 4 – REST API Layer (User)

### ✅ Implemented:
- Created `UserController`
- Added REST endpoints:
  - `POST /users` → Create user
  - `GET /users` → Get all users
- Used `@RequestBody` for JSON mapping
- Connected Service layer properly
- Tested using Postman
- Verified DB persistence in pgAdmin

### 🔍 Concepts Learned:
- RESTful endpoint design
- Controller → Service separation
- JSON to Object mapping
- Why DTOs are important (future improvement)

---

# Day 5 – Stock Module

### ✅ Implemented:
- Created `Stock` entity
- Added:
  - `symbol` (unique business key)
  - `name`
  - `price`
- Added unique constraint on `symbol`
- Created `StockRepository`
  - `findBySymbol`
  - `existsBySymbol`
- Implemented `StockService`
  - Validation (price > 0)
  - Duplicate prevention
  - Fetch by symbol
- Created `StockController`
  - `POST /stocks`
  - `GET /stocks`
  - `GET /stocks/{symbol}`
- Tested full flow using Postman
- Stored multiple Nifty stocks manually
- Verified persistence in PostgreSQL

---

## Architecture So Far

Controller → Service → Repository → Database

- Business logic isolated in Service
- Repository handles DB operations
- Controller handles HTTP layer
- Unique constraints handled at both Service + DB level



📅 DAY 6 — Order Entity + Buy Logic + Transaction
🎯 Goal Today

When user buys stock:

1️⃣ Check user exists
2️⃣ Check stock exists
3️⃣ Check sufficient balance
4️⃣ Deduct balance
5️⃣ Create order
6️⃣ Store purchase price snapshot
7️⃣ Wrap everything in one transaction


DAY 7 :

Enum mapping issues
DB column type mismatch
Wrong repository method
Case sensitivity in paths
Constructor assignment bugs
Relationship-based query derivation


# Day 8 – Portfolio API Implementation

Today we implemented the **Portfolio API** for the Stock Trading Backend.
This endpoint calculates and returns the **stocks currently owned by a user** based on all their past buy and sell transactions.

The system follows a **ledger-based approach**, where every buy/sell action is stored as an order.
Portfolio holdings are derived by replaying these transactions.

# Day 9 – DTO Introduction & Portfolio API Improvement

## Overview

Today we improved the **Portfolio API** by introducing a **DTO (Data Transfer Object)** instead of returning raw `Map<String,Object>` structures.

This makes the API cleaner, type-safe, and closer to production-level backend design.

---

## Why DTO Was Introduced

Previously the portfolio endpoint returned:

```json
{
  "name": "Dhanu",
  "stocks": {
    "RELIANCE": 3,
    "TCS": 1
  }
}
```

This was implemented using:

```java
Map<String,Object>
```

However, using raw maps in APIs is not recommended because:

* It lacks type safety
* Harder to maintain
* Difficult for frontend developers to understand structure
* Not scalable when response grows

DTOs solve these problems by defining **explicit response structures**.

---




