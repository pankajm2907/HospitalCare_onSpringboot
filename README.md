# 🏥 Spring Boot Microservices Hospital Management System

A distributed hospital management system built with Spring Boot microservices architecture. This project modularizes the system into separate services for patients, doctors, departments, and appointments, and integrates key tools for service discovery, routing, caching, monitoring, and startup automation.

---

## 🚀 Features

- ✅ **Spring Boot Microservices**  
  Modular services for patients, doctors, departments, and appointments.

- 🔍 **Eureka Service Discovery**  
  Centralized registry for all microservices.

- 🌐 **API Gateway**  
  Unified entry point to route client requests to appropriate services.

- ⚡ **Redis Integration**  
  Used for:
  - Caching frequently accessed data
  - API rate limiting

- 📊 **Prometheus + Grafana**  
  Real-time application performance monitoring and visualization.

- 🛠️ **Custom Startup Bash Script**  
  A `start.sh` file is provided to launch all services in order.

---

## 🧱 Microservices Overview

| Service Name     | Description                         | Port   |
|------------------|-------------------------------------|--------|
| `eureka-server`  | Service registry                    | `8761` |
| `api-gateway`    | API Gateway for routing             | `8080` |
| `patient-service`| Manage patient records              | `8081` |
| `doctor-service` | Manage doctor profiles              | `8082` |
| `dept-service`   | Handle hospital departments         | `8083` |
| `appointment-service` | Schedule and manage appointments | `8084` |

---

## 🖥️ Monitoring Stack

- **Prometheus**: Scrapes metrics from microservices.
- **Grafana**: Dashboards for live system insights.

---

## 🧰 Tech Stack

- Java 17+
- Spring Boot
- Spring Cloud (Eureka, Gateway, Config)
- Redis
- Prometheus
- Grafana
- Docker
- Kubernetes

---

## 🏁 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/spring-ms-hospital-system.git
cd spring-ms-hospital-system
