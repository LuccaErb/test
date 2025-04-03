package com.adopt.test.services.adopter;

import com.adopt.test.common.exceptions.Exception;
import com.adopt.test.common.messageError.MessageError;
import com.adopt.test.domain.dto.adopter.AdopterDto;
import com.adopt.test.domain.dto.adopter.AdopterDtoResponse;
import com.adopt.test.domain.model.adopter.Adopter;
import com.adopt.test.repositories.adopter.AdopterRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AdopterServiceImpl implements AdopterService {
    private final AdopterRepository repository;


    @Override
    public List<AdopterDto> listAllAdoperts() {
        return repository.findAll().stream().map(AdopterDto::new).toList();
    }

    @Override
    public AdopterDto getAdopterById(Long id) {
        if (!id.toString().matches("\\d+")) {
            throw new EntityNotFoundException(MessageError.ADOPTER_NOT_FOUND.getMessage());

        }
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(MessageError.ADOPTER_NOT_FOUND.getMessage());
        }
        return repository.findById(id).map(AdopterDto::new).orElseThrow(() -> new EntityNotFoundException(MessageError.ADOPTER_NOT_FOUND.getMessage()));
    }


    @Override
    public AdopterDtoResponse addAdopter(AdopterDto adopterDto) {
        if (!adopterDto.getName().matches("[a-zA-Z ]+") ){
            throw new Exception(MessageError.ADOPTER_NOT_FOUND);
        }

        Adopter adopter = new Adopter(adopterDto.getName(), adopterDto.getCpf(), adopterDto.getBirth(), adopterDto.getAddress(), adopterDto.getEmail(), adopterDto.getPhone());
        repository.save(adopter);
        return new AdopterDtoResponse(adopter);
    }

    @Override
    public ResponseEntity<String> deleteAdopter(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(MessageError.ADOPTER_NOT_FOUND.getMessage());
        }
        repository.deleteById(id);
        return ResponseEntity.ok().body("Adotante deletado com sucesso");


    }
    //update por id adotante
    @Override
    public AdopterDtoResponse updateAdopter(Long id, AdopterDto adopterDto) {


        Adopter adopter = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageError.ADOPTER_NOT_FOUND.getMessage()));

        if (adopterDto.getName() != null) {
            adopter.setName(adopterDto.getName());
        }
        if (adopterDto.getBirth() != null) {
            adopter.setBirth(adopterDto.getBirth());
        }
        if (adopterDto.getAddress() != null) {
            adopter.setAddress(adopterDto.getAddress());
        }
        if (adopterDto.getEmail() != null) {
            adopter.setEmail(adopterDto.getEmail());
        }
        if (adopterDto.getPhone() != null) {
            adopter.setPhone(adopterDto.getPhone());
        }

        repository.save(adopter);
        return new AdopterDtoResponse(adopter);
    }
}
