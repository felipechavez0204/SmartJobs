Scrip BD: 

CREATE DATABASE smartJobs;
USE smartJobs;

CREATE TABLE users (
    id CHAR(36) NOT NULL, -- Para UUID en MySQL, puedes usar CHAR(36)
    created TIMESTAMP(6),
    email VARCHAR(255),
    is_active BOOLEAN NOT NULL,
    last_login TIMESTAMP(6),
    modified TIMESTAMP(6),
    name VARCHAR(255),
    password VARCHAR(255),
    token VARCHAR(255),
    PRIMARY KEY (id)
);

diagrama:
+--------------------+
|                    |
|    Cliente         |
|    (Front)         |
|                    |
+--------------------+
           |
           | HTTP Requests
           |
           v
+--------------------+
|                    |
|   API RESTful      |
|    (Spring Boot)   |
|                    |
+--------------------+
|                    |
| +----------------+ |
| |                | |
| | UserController | |
| |                | |
| +----------------+ |
|                    |
| +----------------+ |
| |                | |
| | UserService    | |
| |                | |
| +----------------+ |
|                    |
| +----------------+ |
| |                | |
| | UserRepository | |
| |                | |
| +----------------+ |
|                    |
+--------------------+
           |
           | JDBC
           |
           v
+--------------------+
|                    |
|   Base de Datos    |
|      MySQL         |
|                    |
+--------------------+
