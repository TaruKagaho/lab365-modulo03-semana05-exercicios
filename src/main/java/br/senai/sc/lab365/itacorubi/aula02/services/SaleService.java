package br.senai.sc.lab365.itacorubi.aula02.services;

import br.senai.sc.lab365.itacorubi.aula02.dtos.SaleRequest;
import br.senai.sc.lab365.itacorubi.aula02.dtos.SaleResponse;
import br.senai.sc.lab365.itacorubi.aula02.models.ClientModel;
import br.senai.sc.lab365.itacorubi.aula02.models.ProductModel;
import br.senai.sc.lab365.itacorubi.aula02.models.SaleModel;
import br.senai.sc.lab365.itacorubi.aula02.repositories.ClientRepository;
import br.senai.sc.lab365.itacorubi.aula02.repositories.ProductRepository;
import br.senai.sc.lab365.itacorubi.aula02.repositories.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SaleService {
    private ClientRepository clientRepository;
    private ProductRepository productRepository;
    private SaleRepository saleRepository;

    /*public void add(SaleRequest newSale) {
        SaleModel newSaleModel = new SaleModel();

        BeanUtils.copyProperties(newSale, newSaleModel);

        this.saleRepository.save(newSaleModel);
    }*/
    public SaleResponse addSale(Long clientId, Long productId, Double discount) {
        // Antes de usar Models em SaleModel:
        /*boolean existsClientId = this.clientRepository.existsById(clientId);

        if (!existsClientId) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "O id '" + clientId + "' do cliente é inválido!"
            );
        }

        boolean existsProductId = this.productRepository.existsById(productId);

        if (!existsProductId) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "O id '" + productId + "' do produto é inválido!"
            );
        }

        // SaleModel newSaleModel = new SaleModel(clientId, productId, discount);
        SaleModel newSaleModel = new SaleModel();
        newSaleModel.setClientId(clientId);
        newSaleModel.setProductId(productId);
        newSaleModel.setDiscount(discount);*/

        // Após implementar Models em SaleModel:
        ClientModel clientFound = this.clientRepository
                .findById(clientId)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                "O id '" + clientId + "' do cliente é inválido!"
                        )
                );

        ProductModel productFound = this.productRepository
                .findById(productId)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                "O id '" + productId + "' do produto é inválido!"
                        )
                );

        SaleModel newSaleModel = new SaleModel(clientFound, productFound, discount);
        SaleModel saleModelAdded = this.saleRepository.save(newSaleModel);
        SaleResponse saleAdded = new SaleResponse();

        BeanUtils.copyProperties(saleModelAdded, saleAdded);
        saleAdded.setClientId(clientId);
        saleAdded.setProductId(productId);

        return saleAdded;
    }

    public List<SaleResponse> getAllSales() {
        List<SaleModel> listOfSales = this.saleRepository.findAll();

        return convertSaleListToSaleResponseList(listOfSales);
    }

    private List<SaleResponse> convertSaleListToSaleResponseList(
            List<SaleModel> salesList
    ) {
        List<SaleResponse> listOfSalesResponse = new ArrayList<>();

        for (SaleModel sale : salesList) {
            SaleResponse saleResponse = new SaleResponse();

            BeanUtils.copyProperties(sale, saleResponse);
            saleResponse.setClientId(sale.getClient().getId());
            saleResponse.setProductId(sale.getProduct().getId());

            listOfSalesResponse.add(saleResponse);
        }

        return listOfSalesResponse;
    }
}
