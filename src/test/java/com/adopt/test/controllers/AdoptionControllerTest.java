package com.adopt.test.controllers;

import com.adopt.test.controllers.adoption.AdoptionController;
import com.adopt.test.domain.dto.adoption.AdoptionDto;
import com.adopt.test.domain.dto.adoption.AdoptionDtoResponse;
import com.adopt.test.domain.model.adopter.Adopter;
import com.adopt.test.domain.model.adoption.Adoption;
import com.adopt.test.domain.model.animal.Animal;
import com.adopt.test.services.adoption.AdoptionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AdoptionControllerTest {
    @Mock
    private AdoptionService adoptionService;

    @InjectMocks
    private AdoptionController adoptionController;



    @Test
    void getAllAdoptions() {

        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);


        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");


        Adoption adoption = new Adoption(animal, adopter);


        AdoptionDto adoptionDto = new AdoptionDto(adoption);


        List<AdoptionDto> adoptions = new ArrayList<>();
        adoptions.add(adoptionDto);


        when(adoptionService.listAllAdoptions()).thenReturn(adoptions);


        ResponseEntity<List<AdoptionDto>> response = adoptionController.getAllAdoptions();


        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals(adoptionDto, response.getBody().get(0));
    }

    @Test
    void getAdoptionById() {

        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);


        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");


        Adoption adoption = new Adoption(animal, adopter);


        AdoptionDto adoptionDto = new AdoptionDto(adoption);


        when(adoptionService.getAdoptionById(anyLong())).thenReturn(adoptionDto);


        ResponseEntity<AdoptionDto> response = adoptionController.getAdoptionById(1L);


        assertEquals(200, response.getStatusCodeValue());
        assertEquals(adoptionDto, response.getBody());
    }

    @Test
    void getAdoptionByAdopterId() {
        Long adopterId = 1L;
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        Adoption adoption = new Adoption(animal, new Adopter("name", "cpf", "birth", "address", "email", "phone"));
        List<AdoptionDto> adoptions = new ArrayList<>();
        adoptions.add(new AdoptionDto(adoption));
        when(adoptionService.getAdoptionByAdopterId(adopterId)).thenReturn(adoptions);
        ResponseEntity<List<AdoptionDto>> response = adoptionController.getAdoptionByAdopterId(adopterId);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());

    }

    @Test
    void addAdoption() throws Exception {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        Adopter adopter = new Adopter("name", "cpf", "birth", "address", "email", "phone");
        Adoption adoption = new Adoption(animal, adopter);
        AdoptionDto adoptionDto = new AdoptionDto(adoption);
        AdoptionDtoResponse adoptionDtoResponse = new AdoptionDtoResponse(adoption);
        when(adoptionService.addAdoption(anyLong(), anyLong())).thenReturn(adoptionDtoResponse);
        ResponseEntity<AdoptionDtoResponse> response = adoptionController.addAdoption(1L, 1L);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(adoptionDtoResponse, response.getBody());
    }





}