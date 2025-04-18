package com.adopt.test.services.adoption;

import com.adopt.test.common.exceptions.Exception;
import com.adopt.test.common.exceptions.LimiteExceededException;
import com.adopt.test.common.messageError.MessageError;
import com.adopt.test.domain.dto.adoption.AdoptionDto;
import com.adopt.test.domain.dto.adoption.AdoptionDtoResponse;
import com.adopt.test.domain.model.adopter.Adopter;
import com.adopt.test.domain.model.adoption.Adoption;
import com.adopt.test.domain.model.animal.Animal;
import com.adopt.test.repositories.adopter.AdopterRepository;
import com.adopt.test.repositories.adoption.AdoptionRepository;
import com.adopt.test.repositories.animal.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdoptionServiceImpl implements AdoptionService {
    private final AdoptionRepository adoptionRepository;
    private final AnimalRepository animalRepository;
    private final AdopterRepository adopterRepository;


    @Override
    public List<AdoptionDto> listAllAdoptions() {
        return adoptionRepository.findAll().stream().map(AdoptionDto::new).toList();
    }

    @Override
    public AdoptionDto getAdoptionById(Long id) {
        return adoptionRepository.findById(id).map(AdoptionDto::new).orElseThrow(() -> new EntityNotFoundException(MessageError.ADOPTION_NOT_FOUND.getMessage()));
    }

    public List<AdoptionDto> getAdoptionByAdopterId(Long id) {
        if (id == null) {
            throw new EntityNotFoundException(MessageError.ADOPTION_NOT_FOUND.getMessage());
        }
        if (!id.toString().matches("\\d+")) {
            throw new EntityNotFoundException(MessageError.ADOPTION_NOT_FOUND.getMessage());

        }
        if (!adopterRepository.existsById(id)) {
            throw new EntityNotFoundException(MessageError.ADOPTION_NOT_FOUND.getMessage());
        }
        return adoptionRepository.findByAdopterId(id).stream()
                .map(AdoptionDto::new)
                .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public AdoptionDtoResponse addAdoption(Long animalId, Long adopterId) {

        if (animalId == null || adopterId == null) {
            throw new Exception(MessageError.ADOPTER_NOT_FOUND);
        }

        Animal animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new EntityNotFoundException(MessageError.ANIMAL_NOT_FOUND.getMessage()));

        Adopter adopter = adopterRepository.findById(adopterId)
                .orElseThrow(() -> new EntityNotFoundException(MessageError.ADOPTER_NOT_FOUND.getMessage()));


        if (adoptionRepository.existsByAnimalId(animalId)) {
            throw new Exception(MessageError.ANIMAL_ALREADY_ADOPTED);
        }
        if (adoptionRepository.countByAdopterIdAndDateReturnIsNull(adopterId) >= 3) {
            throw new LimiteExceededException(MessageError.ADOPTION_LIMIT_EXCEEDED);
        }
        Adoption adoption = new Adoption(animal, adopter);
        adoption.setDateAdoption(LocalDate.now());

        animal.setStatus(false);
        animalRepository.save(animal);
        adoptionRepository.save(adoption);

        return new AdoptionDtoResponse(adoption);

    }

@Override
@Transactional
public ResponseEntity<String> cancelAdoption(Long id) {

    Adoption adoption = adoptionRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Adoção não encontrada!"));


    Animal animal = adoption.getAnimal();
    Adopter adopter = adoption.getAdopter();


    adoptionRepository.delete(adoption);


    animal.setStatus(true);
    animal.setAdoption(null);
    animalRepository.save(animal);

    return ResponseEntity.ok("Adoção cancelada com sucesso!");
}

}
