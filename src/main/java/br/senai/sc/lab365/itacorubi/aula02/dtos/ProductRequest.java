package br.senai.sc.lab365.itacorubi.aula02.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductRequest {
    @NotBlank(message = "O nome do produto é obrigatório!")
    private String name;

    @NotNull(message = "O preço do produto é obrigatório!")
    @Min(value = 0, message = "O preço deve ser maior ou igual a zero!")
    private Double price;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "dd/MM/yyyy",
            locale = "pt-BR",
            timezone = "Brazil/East"
    )
    @NotNull(message = "A data de validade é obrigatória!")
    private LocalDate validity;
}
