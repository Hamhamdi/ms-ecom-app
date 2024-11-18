# Microservice Application

## Project Overview

This is a Spring Boot microservice application built with Java 21 and Spring Cloud, utilizing a microservices architecture with service discovery, API gateway, and multiple domain-specific services.

## Technologies Used

- **Java Version**: 21
- **Spring Boot**: 3.3.5
- **Spring Cloud**: 2023.0.3
- **Key Frameworks and Libraries**:
    - Spring Cloud Netflix Eureka (Service Discovery)
    - Spring Cloud Gateway (API Gateway)
    - Spring Data JPA
    - Spring Web
    - Lombok
    - H2 Database (for development)

## Microservices Architecture

### 1. Discovery Service
- **Artifact**: discovery-service
- **Role**: Netflix Eureka Server for service registration and discovery

### 2. Gateway Service
- **Artifact**: gateway-service
- **Role**: API Gateway for routing and load balancing

### 3. Customer Service
- **Artifact**: customer-service
- **Role**: Manages customer-related operations

### 4. Inventory Service
- **Artifact**: inventory-service
- **Role**: Manages product and inventory-related operations

### 5. Billing Service
- **Artifact**: billing-service
- **Role**: Handles billing and financial transactions

## Prerequisites

- Java Development Kit (JDK) 21
- Maven
- An IDE with Spring Boot support

## Building and Running the Application

1. Clone the repository
2. Navigate to each service directory
3. Run `mvn clean install` to build each service
4. Start services in the following order:
    - Discovery Service
    - Other services (order doesn't matter)


## Database

- H2 in-memory database used for development
- Replace with production database as needed

