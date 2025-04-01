package com.adopt.test.domain.dto;

import com.adopt.test.domain.model.Adopter;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdopterDtoResponse {
    Long id;
    @NotNull
    String name;
    @NotNull
    String cpf;
    @NotNull
    String birth;
    String address;
    String email;
    @NotNull
    String phone;

    public AdopterDtoResponse(Adopter adopter) {
        this(adopter.getId(), adopter.getName(), adopter.getCpf(), adopter.getBirth(), adopter.getAddress(), adopter.getEmail(), adopter.getPhone());
    }


}
