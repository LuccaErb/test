CREATE TABLE adoptions (
                           id SERIAL PRIMARY KEY,
                           date_adoption DATE NOT NULL,
                           date_return DATE,
                           animal_id INT NOT NULL UNIQUE,
                           adopter_id INT NOT NULL,
                           FOREIGN KEY (animal_id) REFERENCES animals(id),
                           FOREIGN KEY (adopter_id) REFERENCES adopters(id)
);