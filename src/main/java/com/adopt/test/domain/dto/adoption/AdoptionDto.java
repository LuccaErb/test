package com.adopt.test.domain.dto.adoption;

import com.adopt.test.domain.model.adoption.Adoption;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

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
