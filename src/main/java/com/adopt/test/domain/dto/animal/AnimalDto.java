package com.adopt.test.domain.dto.animal;

import com.adopt.test.domain.model.animal.Animal;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDto {
    private String name;
    @NotNull
    private String species;
    @NotNull
    private String race;
    @NotNull
    private String age;
    @NotNull
    private Boolean status;

    public AnimalDto(Animal animal) {
        this(animal.getName(), animal.getSpecies(),animal.getRace(),animal.getAge(), animal.getStatus());
    }



}
