package br.senai.sc.lab365.itacorubi.aula02.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleRequest {
    @NotNull(message = "ID do cliente é obrigatório!")
    @Min(value = 1, message = "O valor do desconto deve ser maior ou igual a um!")
    private Long clientId;

    @NotNull(message = "ID do produto é obrigatório!")
    @Min(value = 1, message = "O valor do desconto deve ser maior ou igual a um!")
    private Long productId;

    @NotNull(message = "O valor do desconto é obrigatório!")
    @Min(value = 0, message = "O valor do desconto deve ser maior ou igual a zero!")
    private Double discount;
}
