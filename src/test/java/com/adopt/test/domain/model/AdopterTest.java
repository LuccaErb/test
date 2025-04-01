package com.adopt.test.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdopterTest {

    @Test
    void getName() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        assertEquals("name", adopter.getName());
    }

    @Test
    void getCpf() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        assertEquals("cpf", adopter.getCpf());
    }

    @Test
    void getBirth() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        assertEquals("birth", adopter.getBirth());
    }

    @Test
    void getAddress() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        assertEquals("address", adopter.getAddress());
    }

    @Test
    void getEmail() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        assertEquals("email", adopter.getEmail());
    }

    @Test
    void getPhone() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        assertEquals("phone", adopter.getPhone());
    }

    @Test
    void setName() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        adopter.setName("new name");
        assertEquals("new name", adopter.getName());
    }

    @Test
    void setCpf() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        adopter.setCpf("new cpf");
        assertEquals("new cpf", adopter.getCpf());
    }

    @Test
    void setBirth() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        adopter.setBirth("new birth");
        assertEquals("new birth", adopter.getBirth());
    }

    @Test
    void setAddress() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        adopter.setAddress("new address");
        assertEquals("new address", adopter.getAddress());
    }

    @Test
    void setEmail() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        adopter.setEmail("new email");
        assertEquals("new email", adopter.getEmail());
    }

    @Test
    void setPhone() {
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        adopter.setPhone("new phone");
        assertEquals("new phone", adopter.getPhone());
    }
}