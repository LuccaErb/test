package com.adopt.test.domain.dto;

import com.adopt.test.domain.model.Animal;

import jakarta.validation.constraints.NotNull;
public record AnimalDto(



        String name,
        @NotNull
        String species,
        @NotNull
        String race,
        @NotNull
        String age,
        @NotNull
        Boolean status) {

    public AnimalDto(Animal animal) {
        this(animal.getName(), animal.getSpecies(), animal.getRace(), animal.getAge(), animal.getStatus());
    }
}
