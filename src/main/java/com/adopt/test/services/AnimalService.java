package com.adopt.test.services;

import com.adopt.test.domain.dto.AnimalDto;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AnimalService {
    List<AnimalDto> listAllAnimals();
    AnimalDto addAnimal(AnimalDto animal);
    AnimalDto getAnimalById(Long id);
    ResponseEntity<String> deleteAnimal(Long id);
    AnimalDto updateAnimal(Long id, AnimalDto animal);
}
