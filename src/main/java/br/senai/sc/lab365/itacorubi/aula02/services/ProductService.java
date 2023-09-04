package br.senai.sc.lab365.itacorubi.aula02.services;

import br.senai.sc.lab365.itacorubi.aula02.dtos.ProductRequest;
import br.senai.sc.lab365.itacorubi.aula02.dtos.ProductResponse;
import br.senai.sc.lab365.itacorubi.aula02.models.ProductModel;
import br.senai.sc.lab365.itacorubi.aula02.repositories.ProductRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
// @AllArgsConstructor
// Pega apenas os atributo que possuem "final".
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void add(ProductRequest newProduct) {
        ProductModel newProductModel = new ProductModel();

        BeanUtils.copyProperties(newProduct, newProductModel);

        productRepository.save(newProductModel);
    }

    public List<ProductResponse> getAllProducts() {
        List<ProductModel> listOfProducts = this.productRepository.findAll();

        return convertProductListToProductResponseList(listOfProducts);
    }

    private List<ProductResponse> convertProductListToProductResponseList(
            List<ProductModel> productsList
    ) {
        List<ProductResponse> listOfProductsResponse = new ArrayList<>();

        for ( ProductModel product : productsList ) {
            ProductResponse productResponse = new ProductResponse();

            BeanUtils.copyProperties(product, productResponse);

            listOfProductsResponse.add(productResponse);
        }

        return listOfProductsResponse;
    }
}
