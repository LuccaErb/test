package com.adopt.test.services;

import com.adopt.test.domain.dto.AdopterDto;
import com.adopt.test.domain.model.Adopter;
import com.adopt.test.repositories.AdopterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AdopterServiceImpl implements AdopterService {
    private final AdopterRepository repository;

    //listando todos os adotantes
    @Override
    public List<AdopterDto> listAllAdoperts() {
        return repository.findAll().stream().map(AdopterDto::new).toList();
    }
    //buscando adotante especifico
    @Override
    public AdopterDto getAdopterById(Long id) {
        return repository.findById(id).map(AdopterDto::new).orElseThrow(() -> new RuntimeException("Adopter não encontrado"));
    }

    //criando adotante por meio do dto
    @Override
    public AdopterDto addAdopter(AdopterDto adopterDto) {
        Adopter adopter = new Adopter(adopterDto.name(), adopterDto.cpf(), adopterDto.birth(), adopterDto.address(), adopterDto.email(), adopterDto.phone());
        repository.save(adopter);
        return new AdopterDto(adopter);
    }
    //deletando adotante
    @Override
    public ResponseEntity<String> deleteAdopter(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().body("Adotante deletado com sucesso");
    }
    //update por id adotante
    @Override
    public AdopterDto updateAdopter(Long id, AdopterDto adopterDto) {
        Adopter adopter = new Adopter( adopterDto.name(), adopterDto.cpf(), adopterDto.birth(), adopterDto.address(), adopterDto.email(), adopterDto.phone());
        repository.save(adopter);
        return new AdopterDto(adopter);
    }
}
