package com.adopt.test.domain.model.adopter;

import com.adopt.test.repositories.adopter.AdopterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AdopterTest {
    @Mock
    private AdopterRepository adopterRepository;

    private Adopter adopter;

    @BeforeEach
    void setUp() {
         adopter = new Adopter("Adopter", "111.111.111-11", "1999-01-01", "Rua 1", "email", "1111111111");
    }

    @Test
    void getName() {

        String name = adopter.getName();
        assertEquals("Adopter", name);
    }

    @Test
    void getCpf() {
        String cpf = adopter.getCpf();
        assertEquals("111.111.111-11", cpf);
    }

    @Test
    void getBirth() {
        String birth = adopter.getBirth();
        assertEquals("1999-01-01", birth);
    }

    @Test
    void getAddress() {
        String address = adopter.getAddress();
        assertEquals("Rua 1", address);
    }

    @Test
    void getEmail() {
        String email = adopter.getEmail();
        assertEquals("email", email);
    }

    @Test
    void getPhone() {
        String phone = adopter.getPhone();
        assertEquals("1111111111", phone);
    }

    @Test
    void setName() {
        String name = "Adopter";
        adopter.setName(name);
        assertEquals("Adopter", adopter.getName());
    }

    @Test
    void setCpf() {
        String cpf = "111.111.111-11";
        adopter.setCpf(cpf);
        assertEquals("111.111.111-11", adopter.getCpf());
    }

    @Test
    void setBirth() {
        String birth = "1999-01-01";
        adopter.setBirth(birth);
        assertEquals("1999-01-01", adopter.getBirth());
    }

    @Test
    void setAddress() {
        String address = "Rua 1";
        adopter.setAddress(address);
        assertEquals("Rua 1", adopter.getAddress());
    }

    @Test
    void setEmail() {
        String email = "email";
        adopter.setEmail(email);
        assertEquals("email", adopter.getEmail());
    }

    @Test
    void setPhone() {
        String phone = "1111111111";
        adopter.setPhone(phone);
        assertEquals("1111111111", adopter.getPhone());
    }
}