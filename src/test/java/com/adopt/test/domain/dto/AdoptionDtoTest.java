package com.adopt.test.domain.dto;

import com.adopt.test.domain.model.Adopter;
import com.adopt.test.domain.model.Adoption;
import com.adopt.test.domain.model.Animal;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AdoptionDtoTest {

    @Test
    void getDateAdoption() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        Adoption adoption = new Adoption(animal, adopter);
        AdoptionDto adoptionDto = new AdoptionDto(adoption);
        assertEquals(adoption.getDateAdoption(), adoptionDto.getDateAdoption());
    }

    @Test
    void getDateReturn() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        Adoption adoption = new Adoption(animal, adopter);
        adoption.setDateReturn(LocalDate.now());
        AdoptionDto adoptionDto = new AdoptionDto(adoption);
        assertEquals(adoption.getDateReturn(), adoptionDto.getDateReturn());
    }
}