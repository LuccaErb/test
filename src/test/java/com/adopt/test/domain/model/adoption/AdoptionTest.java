package com.adopt.test.domain.model.adoption;

import com.adopt.test.domain.dto.adopter.AdopterDto;
import com.adopt.test.domain.dto.adopter.AdopterDtoResponse;
import com.adopt.test.domain.dto.adoption.AdoptionDto;
import com.adopt.test.domain.dto.adoption.AdoptionDtoResponse;
import com.adopt.test.domain.dto.animal.AnimalDto;
import com.adopt.test.domain.dto.animal.AnimalDtoReponse;
import com.adopt.test.domain.model.adopter.Adopter;
import com.adopt.test.domain.model.animal.Animal;
import com.adopt.test.repositories.adopter.AdopterRepository;
import com.adopt.test.repositories.adoption.AdoptionRepository;
import com.adopt.test.repositories.animal.AnimalRepository;
import com.adopt.test.services.adoption.AdoptionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AdoptionTest {
    @Mock
    private AdoptionRepository adoptionRepository;

    @Mock
    private AnimalRepository animalRepository;

    @Mock
    private AdopterRepository adopterRepository;

    private Animal animal;
    private Adopter adopter;
    private Adoption adoption;

    private AnimalDto animalDto;
    private AnimalDtoReponse animalDtoReponse;

    private AdopterDto adopterDto;
    private AdopterDtoResponse adopterDtoResponse;

    private AdoptionDto adoptionDto;
    private AdoptionDtoResponse adoptionDtoResponse;

    private AdoptionServiceImpl adoptionService;
    @BeforeEach
    void setUp() {
        animal = new Animal("Rex", "Cachorro", "Labrador", "3", false);
        animalDto = new AnimalDto("Rex", "Cachorro", "Labrador", "3", false);
        animalDtoReponse = new AnimalDtoReponse( 1L,"Rex", "Cachorro", "Labrador", "3", true);

        adopter = new Adopter("Adopter", "111.111.111-11", "1999-01-01", "Rua 1", "email", "1111111111");
        adopterDto = new AdopterDto("Adopter", "111.111.111-11", "1999-01-01", "Rua 1", "email", "1111111111");
        adopterDtoResponse = new AdopterDtoResponse( 1L,"Adopter", "111.111.111-11", "1999-01-01", "Rua 1", "email", "1111111111");


        adoption = new Adoption(animal, adopter);
        adoptionDto = new AdoptionDto(adoption);
        adoptionDtoResponse = new AdoptionDtoResponse(1L, adoptionDto.getDateAdoption(), adoptionDto.getDateReturn(), adoptionDto.getAnimalId(), adoptionDto.getAdopterId());
        adoptionService = new AdoptionServiceImpl(adoptionRepository, animalRepository, adopterRepository);
    }

    @Test
    void getId() {
        Long id = adoptionDtoResponse.getId();
        assertEquals(1L, id);
    }

    @Test
    void getDateAdoption() {
        LocalDate dateAdoption = adoptionDtoResponse.getDateAdoption();
        assertEquals(adoptionDto.getDateAdoption(), dateAdoption);
    }

    @Test
    void getDateReturn() {
        LocalDate dateReturn = adoptionDtoResponse.getDateReturn();
        assertEquals(adoptionDto.getDateReturn(), dateReturn);
    }

    @Test
    void getAnimal() {
        String animal = animalDtoReponse.getName();
        assertEquals("Rex", animal);

    }

    @Test
    void getAdopter() {
        String adopter = adopterDtoResponse.getName();
        assertEquals("Adopter", adopter);
    }

    @Test
    void setId() {
        Long id = adoptionDtoResponse.getId();
        assertEquals(1L, id);
    }



    @Test
    void setDateReturn() {
        LocalDate dateReturn = adoptionDtoResponse.getDateReturn();
        assertEquals(adoptionDto.getDateReturn(), dateReturn);
    }

    @Test
    void setAnimal() {
        String animal = animalDtoReponse.getName();
        assertEquals("Rex", animal);
    }

    @Test
    void setAdopter() {
        String adopter = adopterDtoResponse.getName();
        assertEquals("Adopter", adopter);
    }
}