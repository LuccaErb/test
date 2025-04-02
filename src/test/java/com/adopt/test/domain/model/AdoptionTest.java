package com.adopt.test.domain.model;

import com.adopt.test.domain.model.adopter.Adopter;
import com.adopt.test.domain.model.adoption.Adoption;
import com.adopt.test.domain.model.animal.Animal;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AdoptionTest {

    @Test
    void getDateAdoption() {
        Adoption adoption = new Adoption(null, null);
        assertEquals(LocalDate.now(), adoption.getDateAdoption());
    }

    @Test
    void getDateReturn() {
        Adoption adoption = new Adoption(null, null);
        assertNull(adoption.getDateReturn());
    }

    @Test
    void getAnimal() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        Adoption adoption = new Adoption(animal, null);
        assertEquals(animal, adoption.getAnimal());
    }

    @Test
    void getAdopter() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        Adoption adoption = new Adoption(null, adopter);
        assertEquals(adopter, adoption.getAdopter());
    }

    @Test
    void setDateAdoption() {
        Adoption adoption = new Adoption(null, null);
        adoption.setDateAdoption(LocalDate.now());
    }

    @Test
    void setDateReturn() {
        Adoption adoption = new Adoption(null, null);
        adoption.setDateReturn(LocalDate.now());
    }

    @Test
    void setAnimal() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        Adoption adoption = new Adoption(null, null);
        adoption.setAnimal(animal);
    }

    @Test
    void setAdopter() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        Adoption adoption = new Adoption(null, null);
        adoption.setAdopter(adopter);
    }
}