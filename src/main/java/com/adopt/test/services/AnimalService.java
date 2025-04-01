package com.adopt.test.services;

import com.adopt.test.domain.dto.AnimalDto;

import com.adopt.test.domain.dto.AnimalDtoReponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AnimalService {
    List<AnimalDto> listAllAnimals();
    AnimalDtoReponse addAnimal(AnimalDto animal);
    AnimalDto getAnimalById(Long id);
    ResponseEntity<String> deleteAnimal(Long id);
    AnimalDtoReponse updateAnimal(Long id, AnimalDto animal);
}
