package com.adopt.test.services.adoption;

import com.adopt.test.domain.dto.adopter.AdopterDto;
import com.adopt.test.domain.dto.adopter.AdopterDtoResponse;
import com.adopt.test.domain.dto.adoption.AdoptionDto;
import com.adopt.test.domain.dto.adoption.AdoptionDtoResponse;
import com.adopt.test.domain.dto.animal.AnimalDto;
import com.adopt.test.domain.dto.animal.AnimalDtoReponse;
import com.adopt.test.domain.model.adopter.Adopter;
import com.adopt.test.domain.model.adoption.Adoption;
import com.adopt.test.domain.model.animal.Animal;
import com.adopt.test.repositories.adopter.AdopterRepository;
import com.adopt.test.repositories.adoption.AdoptionRepository;
import com.adopt.test.repositories.animal.AnimalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdoptionServiceImplTest {

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
    void listAllAdoptions() {

        Optional<Adopter> optionalAdopter = adopterRepository.findById(1L);
        Optional<Animal> optionalAnimal = animalRepository.findById(1L);

        if (optionalAdopter.isPresent() && optionalAnimal.isPresent()) {
            Adopter adopter = optionalAdopter.get();
            Animal animal = optionalAnimal.get();
            when(adopterRepository.findById(1L)).thenReturn(java.util.Optional.of(adopter));
            when(animalRepository.findById(1L)).thenReturn(java.util.Optional.of(animal));
            when(adoptionRepository.findAll()).thenReturn(List.of(adoption));
            List<AdoptionDto> result = adoptionService.listAllAdoptions();
            assertEquals(1, result.size());

            adoptionRepository.findAll();
        }



    }

    @Test
    void getAdoptionById() {
        Optional<Adopter> optionalAdopter = adopterRepository.findById(1L);
        Optional<Animal> optionalAnimal = animalRepository.findById(1L);

        if (optionalAdopter.isPresent() && optionalAnimal.isPresent()) {
            Adopter adopter = optionalAdopter.get();
            Animal animal = optionalAnimal.get();
            when(adopterRepository.findById(1L)).thenReturn(java.util.Optional.of(adopter));
            when(animalRepository.findById(1L)).thenReturn(java.util.Optional.of(animal));
            when(adoptionRepository.findById(1L)).thenReturn(java.util.Optional.of(adoption));
            AdoptionDto result = adoptionService.getAdoptionById(1L);
            verify(adoptionRepository, times(1)).findById(1L);
        }
    }

    @Test
    void getAdoptionByAdopterId() {
        Optional<Adopter> optionalAdopter = adopterRepository.findById(1L);
        if (optionalAdopter.isPresent()) {
            Adopter adopter = optionalAdopter.get();
            when(adopterRepository.findById(1L)).thenReturn(java.util.Optional.of(adopter));
            when(adoptionRepository.findByAdopterId(1L)).thenReturn(List.of(adoption));
            List<AdoptionDto> result = adoptionService.getAdoptionByAdopterId(1L);
            verify(adoptionRepository, times(1)).findByAdopterId(1L);
        }

    }

    @Test
    void addAdoption() {
        Optional<Adopter> optionalAdopter = adopterRepository.findById(1L);
        Optional<Animal> optionalAnimal = animalRepository.findById(1L);

        if (optionalAdopter.isPresent() && optionalAnimal.isPresent()) {
            Adopter adopter = optionalAdopter.get();
            Animal animal = optionalAnimal.get();
            when(adopterRepository.findById(1L)).thenReturn(java.util.Optional.of(adopter));
            when(animalRepository.findById(1L)).thenReturn(java.util.Optional.of(animal));
            adoptionService.addAdoption(1L, 1L);
            verify(adoptionRepository, times(1)).save(adoption);
        }
    }

    @Test
    void cancelAdoption() {
        Optional<Adopter> optionalAdopter = adopterRepository.findById(1L);
        Optional<Animal> optionalAnimal = animalRepository.findById(1L);

        if (optionalAdopter.isPresent() && optionalAnimal.isPresent()) {
            Adopter adopter = optionalAdopter.get();
            Animal animal = optionalAnimal.get();
            when(adopterRepository.findById(1L)).thenReturn(java.util.Optional.of(adopter));
            when(animalRepository.findById(1L)).thenReturn(java.util.Optional.of(animal));
            adoptionService.cancelAdoption(1L);
            verify(adoptionRepository, times(1)).deleteById(1L);
        }
    }
}