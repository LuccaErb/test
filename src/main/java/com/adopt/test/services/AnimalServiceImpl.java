package com.adopt.test.services;

import com.adopt.test.domain.dto.AnimalDto;
import com.adopt.test.domain.model.Animal;
import com.adopt.test.repositories.AnimalRepository;
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

        Animal animal = new Animal( animalDto.name(), animalDto.species(), animalDto.race(), animalDto.age(), animalDto.status());
        repository.save(animal);
        return new AnimalDto(animal);
    }

    //get animal id
    @Override
    public AnimalDto getAnimalById(Long id) {

        return repository.findById(id).map(AnimalDto::new).orElseThrow(() -> new RuntimeException("Animal não encontrado"));
    }

    //delete
    @Override
    public ResponseEntity<String> deleteAnimal(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().body("Animal deletado com sucesso");
    }
    //update por id
    @Override
    public AnimalDto updateAnimal(Long id, AnimalDto animalDto) {
        Animal animal = new Animal( animalDto.name(), animalDto.species(), animalDto.race(), animalDto.age(), animalDto.status());
        repository.save(animal);
        return new AnimalDto(animal);
    }





}
