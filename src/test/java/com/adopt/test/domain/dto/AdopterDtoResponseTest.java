package com.adopt.test.domain.dto;

import com.adopt.test.domain.model.Adopter;
import com.adopt.test.domain.model.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdopterDtoResponseTest {



    @Test
    void getName() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        AdopterDtoResponse adopterDto = new AdopterDtoResponse(adopter);
        assertEquals("name", adopterDto.getName());
    }

    @Test
    void getCpf() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        AdopterDtoResponse adopterDto = new AdopterDtoResponse(adopter);
        assertEquals("cpf", adopterDto.getCpf());
    }

    @Test
    void getBirth() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        AdopterDtoResponse adopterDto = new AdopterDtoResponse(adopter);
        assertEquals("birth", adopterDto.getBirth());
    }

    @Test
    void getAddress() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        AdopterDtoResponse adopterDto = new AdopterDtoResponse(adopter);
        assertEquals("address", adopterDto.getAddress());
    }

    @Test
    void getEmail() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        AdopterDtoResponse adopterDto = new AdopterDtoResponse(adopter);
        assertEquals("email", adopterDto.getEmail());
    }

    @Test
    void getPhone() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        AdopterDtoResponse adopterDto = new AdopterDtoResponse(adopter);
        assertEquals("phone", adopterDto.getPhone());
    }
}