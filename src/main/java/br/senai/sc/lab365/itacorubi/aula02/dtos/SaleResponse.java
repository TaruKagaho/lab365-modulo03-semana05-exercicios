package br.senai.sc.lab365.itacorubi.aula02.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleResponse {
    @NotNull(message = "ID do produto é obrigatório!")
    private Long id;

    @NotNull(message = "ID do cliente é obrigatório!")
    private Long clientId;

    @NotNull(message = "ID do produto é obrigatório!")
    private Long productId;

    @NotNull(message = "O valor do desconto é obrigatório!")
    private Double discount;
}
