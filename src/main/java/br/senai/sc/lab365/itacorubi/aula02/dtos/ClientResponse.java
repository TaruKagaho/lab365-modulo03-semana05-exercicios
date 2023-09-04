package br.senai.sc.lab365.itacorubi.aula02.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientResponse {
    @NotNull(message = "ID do cliente é obrigatório!")
    private Long id;

    @NotBlank(message = "O nome do cliente é obrigatório!")
    private String name;

    @NotNull(message = "O saldo é obrigatório!")
    private Double balance;
}
