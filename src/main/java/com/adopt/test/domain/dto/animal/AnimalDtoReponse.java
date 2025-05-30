package com.adopt.test.domain.dto.animal;

import com.adopt.test.domain.model.animal.Animal;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter

@AllArgsConstructor
@NoArgsConstructor
public class AnimalDtoReponse {
    private Long id;
    private String name;
    @NotNull
    private String species;
    @NotNull
    private String race;
    @NotNull
    private String age;
    @NotNull
    private Boolean status;

    public AnimalDtoReponse(Animal animal) {
        this(animal.getId(), animal.getName(), animal.getSpecies(), animal.getRace(), animal.getAge(), animal.getStatus());
    }
}