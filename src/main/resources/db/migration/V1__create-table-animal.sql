CREATE TABLE animals (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         species VARCHAR(255) NOT NULL,
                         race VARCHAR(255) NOT NULL,
                         age VARCHAR(255) NOT NULL,
                         status BOOLEAN NOT NULL
);