# springboot-notification-system

> Event-driven notification dispatch pipeline built with Java, Spring Boot, and Docker.

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Framework: Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)]()
[![Java: 17+](https://img.shields.io/badge/Java-17+-orange.svg)]()
[![Container: Docker](https://img.shields.io/badge/Docker-Ready-2496ED.svg)]()

---

## Overview

A resilient microservice architecture for asynchronous notification processing. Designed to handle bulk alert queuing, template rendering, and multi-channel delivery (Email, WhatsApp, Push) with exponential retry policies and dead-letter queue isolation.

### Key Architectural Features
* **Asynchronous Queue Ingestion:** Decouples notification production from downstream delivery latency.
* **Resilient Retry & Backoff:** Configurable retry thresholds and exponential backoff to handle external carrier outages without dropping messages.
* **Template Engine Integration:** Dynamic alert generation supporting variable interpolation and localized messaging.
* **Dockerized Setup:** Ready for containerized deployment with pre-configured health check endpoints.

---

## Quickstart

### Prerequisites
* JDK 17 or higher
* Maven
* Docker

### Build and Run
```bash
git clone https://github.com/Divyanshkumar62/springboot-notification-system.git
cd springboot-notification-system

# Build jar package
./mvnw clean package

# Run with local profile
./mvnw spring-boot:run
```

---

## License
Distributed under the [MIT License](LICENSE).
