package com.adopt.test.services.animal;

import com.adopt.test.domain.dto.animal.AnimalDto;

import com.adopt.test.domain.dto.animal.AnimalDtoReponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AnimalService {
    List<AnimalDto> listAllAnimals();
    AnimalDtoReponse addAnimal(AnimalDto animal);
    AnimalDto getAnimalById(Long id);
    ResponseEntity<String> deleteAnimal(Long id);
    AnimalDtoReponse updateAnimal(Long id, AnimalDto animal);
}
