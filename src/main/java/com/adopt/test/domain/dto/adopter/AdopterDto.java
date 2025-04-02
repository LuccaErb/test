package com.adopt.test.domain.dto.adopter;

import com.adopt.test.domain.model.adopter.Adopter;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdopterDto {


    @NotNull
    private String name;
    @NotNull
    private String cpf;
    @NotNull
    private String birth;
    private String address;
    private String email;
    @NotNull
    private String phone;

    public AdopterDto(Adopter adopter) {
        this( adopter.getName(), adopter.getCpf(), adopter.getBirth(), adopter.getAddress(), adopter.getEmail(), adopter.getPhone());
    }
}
