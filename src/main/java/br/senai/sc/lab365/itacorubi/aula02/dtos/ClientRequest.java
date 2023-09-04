package br.senai.sc.lab365.itacorubi.aula02.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequest {
    @NotBlank(message = "O nome do cliente é obrigatório!")
    private String name;

    @NotNull(message = "O preço do produto é obrigatório!")
    @Min(value = 0, message = "O saldo deve ser maior ou igual a zero!")
    private Double balance;
}
