🛒 E-Commerce Backend (Spring Boot)
A secure, scalable e-commerce backend built using Spring Boot, JWT authentication, and role-based authorization (USER / ADMIN).
This project provides REST APIs for user authentication, product management, and order processing.
| Feature | Description |
|--------|-------------|
| JWT Authentication | Secure login using tokens |
| User Role | Can view products and place orders |
| Admin Role | Can manage products and users |
| Database | PostgreSQL |

| API | Access |
|-----|--------|
| GET /products | USER, ADMIN |
| POST /products | ADMIN |
| PUT /products/{id} | ADMIN |
| DELETE /products/{id} | ADMIN |
