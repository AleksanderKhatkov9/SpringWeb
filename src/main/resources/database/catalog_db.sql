
use spring_web;
CREATE TABLE catalog (
   id INT PRIMARY KEY AUTO_INCREMENT,
   description varchar(500) NOT NULL,
   title varchar(255) NOT NULL,
   price varchar(255) NOT NULL,
   date  varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;