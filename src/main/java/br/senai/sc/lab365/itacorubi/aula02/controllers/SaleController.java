package br.senai.sc.lab365.itacorubi.aula02.controllers;

import br.senai.sc.lab365.itacorubi.aula02.dtos.SaleRequest;
import br.senai.sc.lab365.itacorubi.aula02.dtos.SaleResponse;
import br.senai.sc.lab365.itacorubi.aula02.services.SaleService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
@AllArgsConstructor
public class SaleController {
    private SaleService saleService;

    @PostMapping
    /*public void addNewSale(@RequestBody SaleRequest newSale) {
        this.saleService.add(newSale);
    }*/
    public ResponseEntity<SaleResponse> addNewSale(
            @RequestParam Long clientId,
            @RequestParam Long productId,
            @RequestParam Double discount
    ) {
        /*SaleResponse salesAdded = this.saleService.addSale(clientId, productId, discount);

        return salesAdded;*/
        // return this.saleService.addSale(clientId, productId, discount);
        /*return new ResponseEntity<>(
                "Venda cadastrada com sucesso ",
                HttpStatus.CREATED
        );*/
        SaleResponse salesAdded = this.saleService.addSale(clientId, productId, discount);

        return new ResponseEntity<SaleResponse>(
                salesAdded,
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public List<SaleResponse> listSales() {
        return this.saleService.getAllSales();
    }
}
