CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, 
    email varchar(255) NOT NULL, 
    first_name varchar(255) NULL, 
    is_active bool NULL, 
    last_name varchar(255) NULL, 
    password varchar(255) NULL, 
    departement_id int8 NULL, 
    role_id int8 NULL 
);


CREATE TABLE departements (
	id BIGINT AUTO_INCREMENT PRIMARY KEY, 
	departement_name varchar(255) NULL
);


CREATE TABLE roles (
	id BIGINT AUTO_INCREMENT PRIMARY KEY, 
	role_name varchar(255) NULL
);