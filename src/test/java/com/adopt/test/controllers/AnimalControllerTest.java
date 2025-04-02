package com.adopt.test.controllers;

import com.adopt.test.controllers.animal.AnimalController;
import com.adopt.test.domain.dto.animal.AnimalDto;
import com.adopt.test.domain.dto.animal.AnimalDtoReponse;
import com.adopt.test.domain.model.animal.Animal;
import com.adopt.test.services.animal.AnimalService;
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
class AnimalControllerTest {
    @Mock
    private AnimalService animalService;

    @InjectMocks
    private AnimalController animalController;
    @Test
    void getAllAnimals() {

        List<AnimalDto> animals = new ArrayList<>();
        animals.add(new AnimalDto("nome", "espécie", "raça", "idade", true));
        when(animalService.listAllAnimals()).thenReturn(animals);


        ResponseEntity<List<AnimalDto>> response = animalController.getAllAnimals();


        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());

    }

    @Test
    void addAnimal() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        AnimalDto animalDto = new AnimalDto(animal);
        AnimalDtoReponse animalDtoReponse = new AnimalDtoReponse(animal);
        when(animalService.addAnimal(animalDto)).thenReturn(animalDtoReponse);

        ResponseEntity<AnimalDtoReponse> response = animalController.addAnimal(animalDto);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(animalDtoReponse, response.getBody());
    }

    @Test
    void getAnimalById() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        AnimalDto animalDto = new AnimalDto(animal);
        when(animalService.getAnimalById(1L)).thenReturn(animalDto);

        ResponseEntity<AnimalDto> response = animalController.getAnimalById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(animalDto, response.getBody());
    }

    @Test
    void deleteAnimal() {
        when(animalService.deleteAnimal(1L)).thenReturn(ResponseEntity.ok().build());

        ResponseEntity<String> response = animalController.deleteAnimal(1L);

        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void updateAnimal() {
        Animal animal = new Animal("nome", "espécie", "raça", "idade", true);
        AnimalDto animalDto = new AnimalDto(animal);
        AnimalDtoReponse animalDtoReponse = new AnimalDtoReponse(animal);
        when(animalService.updateAnimal(1L, animalDto)).thenReturn(animalDtoReponse);

        ResponseEntity<AnimalDtoReponse> response = animalController.updateAnimal(1L, animalDto);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(animalDtoReponse, response.getBody());
    }
}