CREATE TABLE adopters (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          cpf VARCHAR(255) NOT NULL UNIQUE,
                          birth VARCHAR(255) NOT NULL,
                          address VARCHAR(255),
                          email VARCHAR(255),
                          phone VARCHAR(255) NOT NULL
);