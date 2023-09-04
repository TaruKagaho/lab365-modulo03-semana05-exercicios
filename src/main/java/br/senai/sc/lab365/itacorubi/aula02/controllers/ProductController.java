package br.senai.sc.lab365.itacorubi.aula02.controllers;

import br.senai.sc.lab365.itacorubi.aula02.dtos.ProductRequest;
import br.senai.sc.lab365.itacorubi.aula02.dtos.ProductResponse;
import br.senai.sc.lab365.itacorubi.aula02.services.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<String> addNewProduct(@RequestBody @Valid ProductRequest newProduct) {
        this.productService.add(newProduct);

        return new ResponseEntity<>(
                "Produto cadastrado com sucesso!",
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public List<ProductResponse> listProducts() {
        return this.productService.getAllProducts();
    }
}
