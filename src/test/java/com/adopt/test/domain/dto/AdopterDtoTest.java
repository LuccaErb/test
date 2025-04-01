package com.adopt.test.domain.dto;

import com.adopt.test.domain.model.Adopter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdopterDtoTest {

    @Test
    void getName() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        AdopterDto adopterDto = new AdopterDto(adopter);
        assertEquals("name", adopterDto.getName());
    }

    @Test
    void getCpf() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        AdopterDto adopterDto = new AdopterDto(adopter);
        assertEquals("cpf", adopterDto.getCpf());
    }

    @Test
    void getBirth() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        AdopterDto adopterDto = new AdopterDto(adopter);
        assertEquals("birth", adopterDto.getBirth());
    }

    @Test
    void getAddress() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        AdopterDto adopterDto = new AdopterDto(adopter);
        assertEquals("address", adopterDto.getAddress());
    }

    @Test
    void getEmail() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        AdopterDto adopterDto = new AdopterDto(adopter);
        assertEquals("email", adopterDto.getEmail());
    }

    @Test
    void getPhone() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        AdopterDto adopterDto = new AdopterDto(adopter);
        assertEquals("phone", adopterDto.getPhone());
    }
}