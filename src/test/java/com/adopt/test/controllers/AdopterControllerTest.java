package com.adopt.test.controllers;

import com.adopt.test.controllers.adopter.AdopterController;
import com.adopt.test.domain.dto.adopter.AdopterDto;
import com.adopt.test.domain.dto.adopter.AdopterDtoResponse;
import com.adopt.test.domain.model.adopter.Adopter;
import com.adopt.test.services.adopter.AdopterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AdopterControllerTest {
    @Mock
    private AdopterService adopterService;

    @InjectMocks
    private AdopterController adopterController;

    @Test
    void getAllAdopters() {
        List<AdopterDto> adopters = new ArrayList<>();
        adopters.add(new AdopterDto(new Adopter("nome", "cpf", "birth", "address", "email", "phone")));
        when(adopterService.listAllAdoperts()).thenReturn(adopters);
        ResponseEntity<List<AdopterDto>> response = adopterController.getAllAdopters();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());

    }

    @Test
    void getAdopterById() {
        AdopterDto adopter = new AdopterDto(new Adopter("nome", "cpf", "birth", "address", "email", "phone"));
        when(adopterService.getAdopterById(1L)).thenReturn(adopter);
        ResponseEntity<AdopterDto> response = adopterController.getAdopterById(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("nome", response.getBody().getName());
    }

    @Test
    void addAdopter() {
        AdopterDto adopterDto = new AdopterDto(new Adopter("nome", "cpf", "birth", "address", "email", "phone"));
        AdopterDtoResponse adopterDtoResponse = new AdopterDtoResponse(new Adopter("nome", "cpf", "birth", "address", "email", "phone"));
        when(adopterService.addAdopter(adopterDto)).thenReturn(adopterDtoResponse);
        ResponseEntity<AdopterDtoResponse> response = adopterController.addAdopter(adopterDto);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("nome", response.getBody().getName());

    }

    @Test
    void deleteAdopter() {
        when(adopterService.deleteAdopter(1L)).thenReturn(ResponseEntity.ok().body("Adotante deletado com sucesso"));
        ResponseEntity<String> response = adopterController.deleteAdopter(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Adotante deletado com sucesso", response.getBody());

    }

    @Test
    void updateAdopter() {
        AdopterDto adopterDto = new AdopterDto(new Adopter("nome", "cpf", "birth", "address", "email", "phone"));
        AdopterDtoResponse adopterDtoResponse = new AdopterDtoResponse(new Adopter("nome", "cpf", "birth", "address", "email", "phone"));
        when(adopterService.updateAdopter(1L, adopterDto)).thenReturn(adopterDtoResponse);
        ResponseEntity<AdopterDtoResponse> response = adopterController.updateAdopter(1L, adopterDto);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("nome", response.getBody().getName());
    }
}