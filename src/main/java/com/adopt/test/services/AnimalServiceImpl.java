package com.adopt.test.services;

import com.adopt.test.domain.dto.AnimalDto;
import com.adopt.test.domain.dto.AnimalDtoReponse;
import com.adopt.test.domain.model.Animal;
import com.adopt.test.exceptions.InvalidDataException;
import com.adopt.test.repositories.AnimalRepository;
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
            throw new InvalidDataException("O nome do animal não pode ser vazio!");
        }
        if (!animalDto.getName().matches("[a-zA-Z]+") ){
            throw new InvalidDataException("O nome do animal deve conter apenas letras!");
        }
        if (animalDto.getAge() == null || animalDto.getAge().trim().isEmpty()) {
            throw new InvalidDataException("A idade do animal deve ser maior que zero!");
        }
        Animal animal = new Animal(animalDto.getName(), animalDto.getSpecies(), animalDto.getRace(), animalDto.getAge(), animalDto.getStatus());
        repository.save(animal);
        return new AnimalDtoReponse(animal);
    }

    //get animal id
    @Override
    public AnimalDto getAnimalById(Long id) {
        if (id == null) {
            throw new EntityNotFoundException("O ID deve ser um número!");
        }
        if (!id.toString().matches("\\d+")) {
            throw new EntityNotFoundException("O ID deve ser um número!");
        }
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Animal nao encontrado");
        }

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
    public AnimalDtoReponse updateAnimal(Long id, AnimalDto animalDto) {
        Animal animal = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Animal nao encontrado"));

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
