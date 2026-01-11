🛒 E-Commerce Backend (Spring Boot)
A secure, scalable e-commerce backend built using Spring Boot, JWT authentication, and role-based authorization (USER / ADMIN).
This project provides REST APIs for user authentication, product management, and order processing.

🧾 Auth APIs
| API | Access |
|-----|--------|
| POST /auth/register | Public |
| POST /auth/login | Public |

👑 Admin APIs
| API | Access |
|-----|--------|
| POST /admin/register | ADMIN |

📦 Product APIs
| API | Access |
|-----|--------|
| GET /products | USER, ADMIN |
| POST /products | ADMIN |
| PUT /products/{id} | ADMIN |
| DELETE /products/{id} | ADMIN |

🛒 Order APIs
| API | Access |
|-----|--------|
| POST /orders/place | USER, ADMIN |
| GET /orders | USER, ADMIN |

👥 User Roles
| Role | Permissions |
|------|-------------|
| USER | View products, place orders |
| ADMIN | Manage products, create admins |

🛠 Tech Stack
| Layer | Technology |
|------|------------|
| Backend | Spring Boot |
| Security | Spring Security, JWT |
| Database | PostgreSQL |
| ORM | Spring Data JPA |
| Encryption | BCrypt |
```
📂 Project Structure
src/main/java
└── Noddy/E_Commerce
    ├── Controller
    │   ├── AuthController.java
    │   ├── ProductController.java
    │   ├── OrderController.java
    │   └── AdminController.java
    │
    ├── Service
    │   ├── UserService.java
    │   ├── ProductService.java
    │   └── OrderService.java
    │
    ├── Repository
    │   ├── UserRepo.java
    │   ├── ProductRepo.java
    │   ├── OrderRepo.java
    │   └── OrderItemRepo.java
    │
    ├── Entity
    │   ├── User.java
    │   ├── Product.java
    │   ├── Order.java
    │   └── OrderItems.java
    │
    ├── DTO
    │   ├── LoginDto.java
    │   ├── RegisterDto.java
    │   └── OrderResponseDto.java
    │
    ├── Jwt
    │   ├── JwtService.java
    │   └── JwtFilter.java
    │
    └── SecurityConfig
        └── SecurityConfig.java
```
🧪 Testing with Postman:-

1.Register a user

2.Login to get JWT

3.Add JWT to headers

4.Call protected APIs
```
Authorization: Bearer YOUR_JWT_TOKEN
```
```
👨‍💻 Author
Ayush Chaudhari:-
Java Backend Developer
Spring Boot • JWT • REST APIs
```
