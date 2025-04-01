package com.adopt.test.domain.dto;

import com.adopt.test.domain.model.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalDtoReponseTest {

    @Test
    void getName() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        AnimalDtoReponse animalDtoReponse = new AnimalDtoReponse(animal);
        assertEquals("nome", animalDtoReponse.getName());
    }

    @Test
    void getSpecies() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        AnimalDtoReponse animalDtoReponse = new AnimalDtoReponse(animal);
        assertEquals("espécie", animalDtoReponse.getSpecies());
    }

    @Test
    void getRace() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        AnimalDtoReponse animalDtoReponse = new AnimalDtoReponse(animal);
        assertEquals("raça", animalDtoReponse.getRace());
    }

    @Test
    void getAge() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        AnimalDtoReponse animalDtoReponse = new AnimalDtoReponse(animal);
        assertEquals("idade", animalDtoReponse.getAge());
    }

    @Test
    void getStatus() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        AnimalDtoReponse animalDtoReponse = new AnimalDtoReponse(animal);
        assertTrue(animalDtoReponse.getStatus());
    }
}