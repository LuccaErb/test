package com.adopt.test.controllers;

import com.adopt.test.domain.dto.AnimalDto;
import com.adopt.test.domain.dto.AnimalDtoReponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AnimalControllerAPI {
    @Operation(summary = "List all animals",description = "Method to return all animals",tags = "Animals")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return all animals")
    })
    ResponseEntity<List<AnimalDto>> getAllAnimals();

    @Operation(summary = "Add animal",description = "Method to add animal",tags = "Animals")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Return animal added"),
    })
    ResponseEntity<AnimalDtoReponse> addAnimal(@RequestBody AnimalDto animal);

    @Operation(summary = "Get animal by id" ,description = "Method to return animal by id",tags = "Animals")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return animal by id"),
            @ApiResponse(responseCode = "400", description = "O ID precisa ser informado na URL. Exemplo: /animals/{id}"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor: Animal nao encontrado")
    })
    ResponseEntity<AnimalDto> getAnimalById(@PathVariable Long id);

    @Operation(summary = "Delete animal by id",description = "Method to delete animal by id",tags = "Animals" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return animal deleted"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor: Animal nao encontrado")
    })
    ResponseEntity<String> deleteAnimal(@PathVariable Long id);

    @Operation(summary = "Update animal by id",description = "Method to update animal by id",tags = "Animals")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return animal updated"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor: Animal nao encontrado")
    })
    ResponseEntity<AnimalDtoReponse> updateAnimal(@PathVariable Long id, @RequestBody AnimalDto animal);
}
