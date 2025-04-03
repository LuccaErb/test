package com.adopt.test.services.animal;

import com.adopt.test.domain.dto.animal.AnimalDto;
import com.adopt.test.domain.dto.animal.AnimalDtoReponse;
import com.adopt.test.domain.model.animal.Animal;
import com.adopt.test.repositories.animal.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnimalServiceImplTest {

    @Mock
    private AnimalRepository repository;

    @InjectMocks
    private AnimalServiceImpl animalService;

    private AnimalDto animalDto;
    private AnimalDtoReponse animalDtoReponse;
    private Animal animal;

    @BeforeEach
    void setUp() {
        animal = new Animal("Rex", "Cachorro", "Labrador", "3", true);
        animalDto = new AnimalDto("Rex", "Cachorro", "Labrador", "3", false);
        animalDtoReponse = new AnimalDtoReponse( 1L,"Rex", "Cachorro", "Labrador", "3", false);
    }
    @Test
    void listAllAnimals() {
        when(repository.findAll()).thenReturn(List.of(animal));
        List<AnimalDto> result = animalService.listAllAnimals();
        assertEquals(1, result.size());
        assertEquals("Rex", result.get(0).getName());
        repository.findAll();
    }

    @Test
    void addAnimal() {
        when(repository.save(any(Animal.class))).thenReturn(animal);
        animalDtoReponse = animalService.addAnimal(animalDto);
        assertEquals(animalDto.getName(), animalDtoReponse.getName());

    }

    @Test
    void getAnimalById() {
        Optional<Animal> optionalAnimal = repository.findById(1L);

        if (optionalAnimal.isPresent()) {
            Animal animal = optionalAnimal.get();
            when(repository.findById(1L)).thenReturn(java.util.Optional.of(animal));

            AnimalDto result = animalService.getAnimalById(1L);

            verify(repository, times(1)).findById(1L);
        }
    }


    @Test
    void deleteAnimal() {
        Optional<Animal> optionalAnimal = repository.findById(1L);
        if (optionalAnimal.isPresent()) {
            Animal animal = optionalAnimal.get();
            when(repository.findById(1L)).thenReturn(java.util.Optional.of(animal));
            animalService.deleteAnimal(1L);
            verify(repository, times(1)).deleteById(1L);
        }
    }

    @Test
    void updateAnimal() {
        when(repository.findById(1L)).thenReturn(Optional.of(animal));
        animalService.updateAnimal(1L, animalDto);
        verify(repository, times(1)).save(animal);
    }
}