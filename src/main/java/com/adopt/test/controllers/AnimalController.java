package com.adopt.test.controllers;

import com.adopt.test.domain.dto.AnimalDto;

import com.adopt.test.domain.dto.AnimalDtoReponse;
import com.adopt.test.services.AnimalService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AnimalDto>> getAllAnimals() {

        return ResponseEntity.status(HttpStatus.OK).body(service.listAllAnimals());

    }

    @PostMapping
    public ResponseEntity<AnimalDtoReponse> addAnimal(@RequestBody AnimalDto animal) {


        return ResponseEntity.status(HttpStatus.CREATED).body(service.addAnimal(animal)) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalDto> getAnimalById(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(service.getAnimalById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnimal(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteAnimal(id).getBody());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalDtoReponse> updateAnimal(@PathVariable Long id, @RequestBody AnimalDto animal) {

        return ResponseEntity.status(HttpStatus.OK).body(service.updateAnimal(id, animal));
    }

}

