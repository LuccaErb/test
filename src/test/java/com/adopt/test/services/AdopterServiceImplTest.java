package com.adopt.test.services;

import com.adopt.test.domain.dto.adopter.AdopterDto;
import com.adopt.test.domain.dto.adopter.AdopterDtoResponse;
import com.adopt.test.domain.model.adopter.Adopter;
import com.adopt.test.repositories.adopter.AdopterRepository;
import com.adopt.test.services.adopter.AdopterServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AdopterServiceImplTest {
    @Mock
    private AdopterRepository repository;

    @InjectMocks
    private AdopterServiceImpl service;

    @Test
    void listAllAdoperts() {

        List<Adopter> adopters = new ArrayList<>();
        adopters.add(new Adopter("nome", "cpf", "birth", "address", "email", "phone"));
        when(repository.findAll()).thenReturn(adopters);

        List<AdopterDto> result = service.listAllAdoperts();

        assertEquals(1, result.size());
        assertEquals("nome", result.get(0).getName());
    }



    @Test
    void addAdopter() {

        AdopterDto adopterDto = new AdopterDto("nome", "cpf", "birth", "address", "email", "phone");
        when(repository.save(Mockito.any(Adopter.class))).thenReturn(new Adopter("nome", "cpf", "birth", "address", "email", "phone"));


        AdopterDtoResponse result = service.addAdopter(adopterDto);


        assertEquals("nome", result.getName());
    }


    @Test
    void deleteAdopter() {

        when(repository.existsById(1L)).thenReturn(false);

        assertThrows(EntityNotFoundException.class, () -> service.deleteAdopter(1L));

    }

    @Test
    void updateAdopter() {

        Adopter adopter = new Adopter("nome", "cpf", "birth", "address", "email", "phone");
        when(repository.findById(1L)).thenReturn(Optional.of(adopter));

        AdopterDtoResponse result = service.updateAdopter(1L, new AdopterDto("nome", "cpf", "birth", "address", "email", "phone"));


        assertEquals("nome", result.getName());
    }
}