package com.adopt.test.domain.model.animal;

import com.adopt.test.repositories.animal.AnimalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AnimalTest {
    @Mock
    private AnimalRepository animalRepository;

    private Animal animal;


@BeforeEach
void setUp() {
    animal = new Animal("Rex", "Cachorro", "Labrador", "3", false);
}
    @Test
    void getName() {
        String name = animal.getName();
        assertEquals("Rex", name);
    }

    @Test
    void getSpecies() {
        String species = animal.getSpecies();
        assertEquals("Cachorro", species);
    }

    @Test
    void getRace() {
        String race = animal.getRace();
        assertEquals("Labrador", race);
    }

    @Test
    void getAge() {
        String age = animal.getAge();
        assertEquals("3", age);
    }

    @Test
    void getStatus() {
        boolean status = animal.getStatus();
        assertEquals(false, status);
    }

    @Test
    void setName() {
        String name = "Rex";
        animal.setName(name);
        assertEquals("Rex", animal.getName());
    }

    @Test
    void setSpecies() {
        String species = "Cachorro";
        animal.setSpecies(species);
        assertEquals("Cachorro", animal.getSpecies());
    }

    @Test
    void setRace() {
        String race = "Labrador";
        animal.setRace(race);
        assertEquals("Labrador", animal.getRace());
    }

    @Test
    void setAge() {
        String age = "3";
        animal.setAge(age);
        assertEquals("3", animal.getAge());
    }

    @Test
    void setStatus() {
        boolean status = false;
        animal.setStatus(status);
        assertEquals(false, animal.getStatus());
    }
}