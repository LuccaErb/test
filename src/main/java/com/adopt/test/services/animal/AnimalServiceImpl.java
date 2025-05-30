package com.adopt.test.services.animal;

import com.adopt.test.common.exceptions.Exception;
import com.adopt.test.common.messageError.MessageError;
import com.adopt.test.domain.dto.animal.AnimalDto;
import com.adopt.test.domain.dto.animal.AnimalDtoReponse;
import com.adopt.test.domain.model.animal.Animal;
import com.adopt.test.repositories.animal.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository repository;

    //listando animais
    @Override
    public List<AnimalDto> listAllAnimals() {
        return repository.findAll().stream().map(AnimalDto::new).toList();
    }


    //criando animal por meio do dto
    @Override
    public AnimalDtoReponse addAnimal(AnimalDto animalDto) {

        if (animalDto.getName() == null || animalDto.getName().trim().isEmpty()) {
            throw new Exception(MessageError.ANIMAL_NOT_CREATED);
        }
        if (!animalDto.getName().matches("[a-zA-Z ]+") ){
            throw new Exception(MessageError.ANIMAL_NOT_CREATED);
        }
        if (animalDto.getAge() == null || animalDto.getAge().trim().isEmpty()) {
            throw new Exception( MessageError.ANIMAL_NOT_CREATED);
        }
        Animal animal = new Animal(animalDto.getName(), animalDto.getSpecies(), animalDto.getRace(), animalDto.getAge(), animalDto.getStatus());
        repository.save(animal);
        return new AnimalDtoReponse(animal);
    }

    //get animal id
    @Override
    public AnimalDto getAnimalById(Long id) {


        if (id == null || !id.toString().matches("\\d+")) {
            throw new IllegalArgumentException(MessageError.ANIMAL_NOT_FOUND.getMessage());
        }
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(MessageError.ANIMAL_NOT_FOUND.getMessage());
        }

        return repository.findById(id).map(AnimalDto::new).orElseThrow(() -> new EntityNotFoundException(MessageError.ANIMAL_NOT_FOUND.getMessage()));
    }

    //delete
    @Override
    public ResponseEntity<String> deleteAnimal(Long id) {
        if ( !repository.existsById(id)) {
            throw new EntityNotFoundException(MessageError.ANIMAL_NOT_FOUND.getMessage());
        }
        repository.deleteById(id);
        return ResponseEntity.ok().body("Animal deletado com sucesso");
    }
    //update por id
    @Override
    public AnimalDtoReponse updateAnimal(Long id, AnimalDto animalDto) {
        Animal animal = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(MessageError.ANIMAL_NOT_FOUND.getMessage()));

        if (animalDto.getName() != null && !animalDto.getName().trim().isEmpty()) {
            animal.setName(animalDto.getName());
        }

        if (animalDto.getSpecies() != null) {
            animal.setSpecies(animalDto.getSpecies());
        }
        if (animalDto.getRace() != null) {
            animal.setRace(animalDto.getRace());
        }
        if (animalDto.getStatus() != null) {
            animal.setStatus(animalDto.getStatus());
        }

        animal.setName(animalDto.getName());
        animal.setSpecies(animalDto.getSpecies());
        animal.setRace(animalDto.getRace());
        animal.setAge(animalDto.getAge());
        animal.setStatus(animalDto.getStatus());

        repository.save(animal);
        return new AnimalDtoReponse(animal);
    }





}
