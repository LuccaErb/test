package com.adopt.test.domain.dto;

import com.adopt.test.domain.model.Adopter;
import com.adopt.test.domain.model.Adoption;
import com.adopt.test.domain.model.Animal;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AdoptionDtoResponseTest {

    @Test
    void getDateAdoption() {
        Animal animal = new Animal( "name", "species", "breed", "age", true);
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        Adoption adoption = new Adoption(animal, adopter);
        AdoptionDtoResponse adoptionDtoResponse = new AdoptionDtoResponse(adoption);
        assertEquals(LocalDate.now(), adoptionDtoResponse.getDateAdoption());
    }

    @Test
    void getDateReturn() {
        Animal animal = new Animal( "name", "species", "breed", "age", true);
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        Adoption adoption = new Adoption(animal, adopter);
        AdoptionDtoResponse adoptionDtoResponse = new AdoptionDtoResponse(adoption);
        assertNull(adoptionDtoResponse.getDateReturn());

    }

    @Test
    void getAnimalId() {
        Animal animal = new Animal( "name", "species", "breed", "age", true);
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        Adoption adoption = new Adoption(animal, adopter);
        AdoptionDtoResponse adoptionDtoResponse = new AdoptionDtoResponse(adoption);
        assertEquals(animal.getId(), adoptionDtoResponse.getAnimalId());
    }

    @Test
    void getAdopterId() {
        Animal animal = new Animal( "name", "species", "breed", "age", true);
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        Adoption adoption = new Adoption(animal, adopter);
        AdoptionDtoResponse adoptionDtoResponse = new AdoptionDtoResponse(adoption);
        assertEquals(adopter.getId(), adoptionDtoResponse.getAdopterId());
    }
}