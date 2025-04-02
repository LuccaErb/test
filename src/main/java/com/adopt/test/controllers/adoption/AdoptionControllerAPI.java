package com.adopt.test.controllers.adoption;

import com.adopt.test.domain.dto.adoption.AdoptionDto;
import com.adopt.test.domain.dto.adoption.AdoptionDtoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AdoptionControllerAPI {
    @Operation(summary = "List all adoptions",description = "Method to return all adoptions",tags = "Adoptions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return all adoptions"),

    })
    ResponseEntity<List<AdoptionDto>> getAllAdoptions();

    @Operation(summary = "Get adoption by id" ,description = "Method to return adoption by id",tags = "Adoptions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return adoption by id"),
            @ApiResponse(responseCode = "400", description = "O ID precisa ser informado na URL. Exemplo: /animals/{id}"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor: Adoption não encontrado")
    })
    ResponseEntity<AdoptionDto> getAdoptionById(@PathVariable Long id);

    @Operation(summary = "Get adoption by adopter id" ,description = "Method to return adoption by adopter id",tags = "Adoptions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return adoption by adopter id"),
            @ApiResponse(responseCode = "400", description = "O ID precisa ser informado na URL. Exemplo: /animals/{id}"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor: Adopter nao encontrado")
    })
    ResponseEntity<List<AdoptionDto>> getAdoptionByAdopterId(@PathVariable Long id);

    @Operation(summary = "Add adoption",description = "Method to add adoption",tags = "Adoptions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Return adoption added"),
            @ApiResponse(responseCode = "400",description = "Verifique se os parametros da URL estao preenchidos corretamente"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor: Adotante nao encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor: Animal nao encontrado"),
            @ApiResponse(responseCode = "409", description = "Este animal já está adotado!")
    })
    ResponseEntity<AdoptionDtoResponse> addAdoption(@RequestParam Long animalId, @RequestParam Long adopterId)throws Exception;

    @Operation(summary = "Cancel adoption",description = "Method to cancel adoption",tags = "Adoptions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return adoption canceled"),
            @ApiResponse(responseCode = "400", description = "O ID precisa ser informado na URL. Exemplo: /animals/{id}"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor: Adoption nao encontrada")
    })
    ResponseEntity<String> cancelAdoption(@PathVariable Long id);

}
