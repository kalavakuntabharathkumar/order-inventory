# Distributed Order & Inventory Management Microservices Platform

Java 11 / Spring Boot / JPA / PostgreSQL / React / Docker / Jenkins

Four independently runnable services:
- user-service: users and roles
- inventory-service: stock management
- order-service: order creation and inventory reservation
- notification-service: notification events

The repository includes Docker Compose, PostgreSQL schema/seed scripts, a React dashboard,
and a Jenkins pipeline. The included seed script generates a reproducible UCI Online Retail
style transaction dataset with 541,909 rows.

## Run
docker compose up --build

Frontend: http://localhost:3000
User API: http://localhost:8081
Inventory API: http://localhost:8082
Order API: http://localhost:8083
Notification API: http://localhost:8084

This is a portfolio-ready reference implementation; benchmark figures in the project
description should be treated as target/illustrative measurements unless independently
reproduced in your environment.
