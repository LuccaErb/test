package com.adopt.test.domain.dto;

import com.adopt.test.domain.model.Adoption;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter

@AllArgsConstructor
@NoArgsConstructor
public class AdoptionDtoResponse {
    private Long id;
    private LocalDate dateAdoption;
    private LocalDate dateReturn;

    private Long animalId;
    private Long adopterId;



    public AdoptionDtoResponse(Adoption adoption) {
        this.id = adoption.getId();
        this.dateAdoption = adoption.getDateAdoption();
        this.dateReturn = adoption.getDateReturn();
        this.animalId = adoption.getAnimal().getId();
        this.adopterId = adoption.getAdopter().getId();
    }
}
