package com.adopt.test.domain.dto;

import com.adopt.test.domain.model.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalDtoTest {

    @Test
    void getName() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        assertEquals("nome", animal.getName());
    }

    @Test
    void getSpecies() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        assertEquals("espécie", animal.getSpecies());
    }

    @Test
    void getRace() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        assertEquals("raça", animal.getRace());
    }

    @Test
    void getAge() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        assertEquals("idade", animal.getAge());
    }

    @Test
    void getStatus() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        assertTrue(animal.getStatus());
    }

    @Test
    void setName() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        animal.setName("novo nome");
        assertEquals("novo nome", animal.getName());
    }

    @Test
    void setSpecies() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        animal.setSpecies("nova espécie");
        assertEquals("nova espécie", animal.getSpecies());
    }

    @Test
    void setRace() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        animal.setRace("nova raça");
        assertEquals("nova raça", animal.getRace());
    }

    @Test
    void setAge() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        animal.setAge("nova idade");
        assertEquals("nova idade", animal.getAge());
    }

    @Test
    void setStatus() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        animal.setStatus(false);
        assertFalse(animal.getStatus());
    }
}