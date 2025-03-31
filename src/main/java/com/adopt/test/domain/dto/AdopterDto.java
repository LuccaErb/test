package com.adopt.test.domain.dto;

import com.adopt.test.domain.model.Adopter;
import jakarta.validation.constraints.NotNull;

public record AdopterDto(

        @NotNull
        String name,
        @NotNull
        String cpf,
        @NotNull
        String birth,
        String address,
        String email,
        @NotNull
        String phone) {

    public AdopterDto(Adopter adopter) {
        this( adopter.getName(), adopter.getCpf(), adopter.getBirth(), adopter.getAddress(), adopter.getEmail(), adopter.getPhone());
    }
}
