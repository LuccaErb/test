package com.adopt.test.controllers;

import com.adopt.test.domain.dto.AdopterDto;
import com.adopt.test.domain.dto.AdopterDtoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AdopterControllerAPI {
     @Operation(summary = "List all adopters",description = "Method to return all adopters",tags = "Adopters")
     @ApiResponses(value = {
             @ApiResponse(responseCode = "200", description = "Return all adopters")
     })
     ResponseEntity<List<AdopterDto>> getAllAdopters();

     @Operation(summary = "Get adopter by id" ,description = "Method to return adopter by id",tags = "Adopters")
     @ApiResponses(value = {
             @ApiResponse(responseCode = "200", description = "Return adopter by id"),
             @ApiResponse(responseCode = "400", description = "O ID precisa ser informado na URL. Exemplo: /animals/{id}"),
             @ApiResponse(responseCode = "500", description = "Erro interno no servidor: Adotante nao encontrado")
     })
     ResponseEntity<AdopterDto> getAdopterById(@PathVariable Long id);

     @Operation(summary = "Add adopter",description = "Method to add adopter",tags = "Adopters")
     @ApiResponses(value = {
             @ApiResponse(responseCode = "201", description = "Return adopter added"),
             @ApiResponse(responseCode = "409",description = "CPF já existe no banco de dados")
     })
     ResponseEntity<AdopterDtoResponse> addAdopter(@RequestBody AdopterDto adopterDto);

     @Operation(summary ="Delete adopter by id",description = "Method to delete adopter by id",tags = "Adopters" )
     @ApiResponses(value = {
             @ApiResponse(responseCode = "200", description = "Return adopter deleted"),
             @ApiResponse(responseCode = "400", description = "Erro ao executar operacao"),
             @ApiResponse(responseCode = "500", description = "Erro interno no servidor: Adotante nao encontrado")
     })
     ResponseEntity<String> deleteAdopter(@PathVariable Long id);

     @Operation(summary = "Update adopter by id",description = "Method to update adopter by id",tags = "Adopters")
     @ApiResponses(value = {
             @ApiResponse(responseCode = "200", description = "Return adopter updated"),
             @ApiResponse(responseCode = "400", description = "Erro ao executar operacao"),
             @ApiResponse(responseCode = "500", description = "Erro interno no servidor: Adotante nao encontrado")
     })
     ResponseEntity<AdopterDtoResponse> updateAdopter(@PathVariable Long id, @RequestBody AdopterDto adopterDto);
}
