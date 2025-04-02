package com.adopt.test.services;

import com.adopt.test.domain.dto.animal.AnimalDto;
import com.adopt.test.domain.dto.animal.AnimalDtoReponse;
import com.adopt.test.domain.model.animal.Animal;
import com.adopt.test.repositories.animal.AnimalRepository;
import com.adopt.test.services.animal.AnimalServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class AnimalServiceImplTest {
    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private AnimalServiceImpl animalService;

    private Animal animal;
    private AnimalDto animalDto;
    @BeforeEach
    void setup() {
        animal = new Animal("nome", "espécie", "raça", "idade", true);
        animalDto = new AnimalDto(animal);
    }
    @Test
    void listAllAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        when(animalRepository.findAll()).thenReturn(animals);

        List<AnimalDto> result = animalService.listAllAnimals();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void addAnimal() {

        when(animalRepository.save(Mockito.any(Animal.class))).thenReturn(animal);

        AnimalDtoReponse result = animalService.addAnimal(animalDto);

        assertNotNull(result);
        assertEquals(animalDto.getName(), result.getName());
    }

    @Test
    void getAnimalById() {
        when(animalRepository.existsById(1L)).thenReturn(true);
        when(animalRepository.findById(Mockito.any(Long.class))).thenReturn(java.util.Optional.ofNullable(animal));

        AnimalDto result = animalService.getAnimalById(1L);
        assertNotNull(result);
        assertEquals(animalDto.getName(), result.getName());
    }

    @Test
    void deleteAnimal() {
        when(animalRepository.existsById(Mockito.any(Long.class))).thenReturn(true);
        animalService.deleteAnimal(1L);
    }

    @Test
    void updateAnimal() {

        when(animalRepository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.ofNullable(animal));
        when(animalRepository.save(Mockito.any(Animal.class))).thenReturn(animal);


        AnimalDtoReponse result = animalService.updateAnimal(1L, animalDto);


        assertNotNull(result);
        assertEquals(animalDto.getName(), result.getName());
        assertEquals(animalDto.getSpecies(), result.getSpecies());
        assertEquals(animalDto.getRace(), result.getRace());
        assertEquals(animalDto.getAge(), result.getAge());
        assertEquals(animalDto.getStatus(), result.getStatus());
    }
}