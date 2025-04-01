package com.adopt.test.domain.dto;

import com.adopt.test.domain.model.Adopter;
import com.adopt.test.domain.model.Adoption;
import com.adopt.test.domain.model.Animal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdoptionDto{

        private LocalDate dateAdoption;
        private LocalDate dateReturn;

        private Long animalId;
        private Long adopterId;



    public AdoptionDto(Adoption adoption) {

        this.dateAdoption = adoption.getDateAdoption();
        this.dateReturn = adoption.getDateReturn();
        this.animalId = adoption.getAnimal().getId();
        this.adopterId = adoption.getAdopter().getId();
    }
}
