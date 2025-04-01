package com.adopt.test.services;

import com.adopt.test.domain.dto.AdoptionDto;
import com.adopt.test.domain.dto.AdoptionDtoResponse;
import com.adopt.test.domain.model.Adopter;
import com.adopt.test.domain.model.Adoption;
import com.adopt.test.domain.model.Animal;
import com.adopt.test.exceptions.AdoptionLimitExceededException;
import com.adopt.test.exceptions.AnimalAlreadyAdoptedException;
import com.adopt.test.repositories.AdopterRepository;
import com.adopt.test.repositories.AdoptionRepository;
import com.adopt.test.repositories.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

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
        return adoptionRepository.findById(id).map(AdoptionDto::new).orElseThrow(() -> new EntityNotFoundException("Adoption não encontrado"));
    }
    public List<AdoptionDto> getAdoptionByAdopterId(Long id) {
        if (!adopterRepository.existsById(id)) {
            throw new EntityNotFoundException("Adopter nao encontrado");
        }
        return adoptionRepository.findByAdopterId(id).stream()
                .map(AdoptionDto::new)
                .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public AdoptionDtoResponse addAdoption(Long animalId, Long adopterId) {
        Animal animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new EntityNotFoundException("Animal não encontrado!"));

        Adopter adopter = adopterRepository.findById(adopterId)
                .orElseThrow(() -> new EntityNotFoundException("Adotante não encontrado!"));


        if (adoptionRepository.existsByAnimalId(animalId)) {
            throw new AnimalAlreadyAdoptedException("Este animal já está adotado!");
        }
        if (adoptionRepository.countByAdopterIdAndDateReturnIsNull(adopterId) >= 3) {
            throw new AdoptionLimitExceededException("O adotante já tem 3 adoções ativas e não pode adotar mais.");
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
    public AdoptionDtoResponse updateAdoption(Long id, AdoptionDto adoptionDto) {
        Adoption adoption = adoptionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Adoção não encontrada!"));

        adoption.setDateReturn(adoptionDto.getDateReturn());
        if (adoptionDto.getDateReturn() != null) {
            adoption.getAnimal().setStatus(true);
            animalRepository.save(adoption.getAnimal());
        }



        adoptionRepository.save(adoption);
        return new AdoptionDtoResponse(adoption);
    }

    @Override
    @Transactional
    public void deleteAdoption(Long id) {
        Adoption adoption = adoptionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Adoção não encontrada!"));

        adoption.getAnimal().setStatus(true);
        animalRepository.save(adoption.getAnimal());

        adoptionRepository.delete(adoption);
    }

}
