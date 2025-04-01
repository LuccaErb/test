package com.adopt.test.services;

import com.adopt.test.domain.dto.AnimalDto;
import com.adopt.test.domain.model.Animal;
import com.adopt.test.exceptions.InvalidDataException;
import com.adopt.test.repositories.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
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
    public AnimalDto addAnimal(AnimalDto animalDto) {
        if (animalDto.name() == null || animalDto.name().trim().isEmpty()) {
            throw new InvalidDataException("O nome do animal não pode ser vazio!");
        }
        if (animalDto.age() == null || animalDto.age().trim().isEmpty()) {
            throw new InvalidDataException("A idade do animal deve ser maior que zero!");
        }

        Animal animal = new Animal( animalDto.name(), animalDto.species(), animalDto.race(), animalDto.age(), animalDto.status());
        repository.save(animal);
        return new AnimalDto(animal);
    }

    //get animal id
    @Override
    public AnimalDto getAnimalById(Long id) {

        return repository.findById(id).map(AnimalDto::new).orElseThrow(() -> new EntityNotFoundException("Animal não encontrado"));
    }

    //delete
    @Override
    public ResponseEntity<String> deleteAnimal(Long id) {
        if ( !repository.existsById(id)) {
            throw new EntityNotFoundException("Animal nao encontrado");
        }
        repository.deleteById(id);
        return ResponseEntity.ok().body("Animal deletado com sucesso");
    }
    //update por id
    @Override
    public AnimalDto updateAnimal(Long id, AnimalDto animalDto) {
        Animal animal = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Animal nao encontrado"));

        if (animalDto.name() != null && !animalDto.name().trim().isEmpty()) {
            animal.setName(animalDto.name());
        }
        if (animalDto.species() != null) {
            animal.setSpecies(animalDto.species());
        }
        if (animalDto.race() != null) {
            animal.setRace(animalDto.race());
        }
        if (animalDto.status() != null) {
            animal.setStatus(animalDto.status());
        }

        animal.setName(animalDto.name());
        animal.setSpecies(animalDto.species());
        animal.setRace(animalDto.race());
        animal.setAge(animalDto.age());
        animal.setStatus(animalDto.status());

        repository.save(animal);
        return new AnimalDto(animal);
    }





}
