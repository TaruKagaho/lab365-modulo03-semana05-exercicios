package br.senai.sc.lab365.itacorubi.aula02.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(nullable=false)
    /*@ManyToOne(optional = false)
    private Long clientId;*/
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ClientModel client;

    /*@Column(nullable=false)
    private Long productId;*/
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ProductModel product;

    @Column(nullable=false)
    private Double discount;

    /*public SaleModel(Long clientId, Long productId, Double discount) {
        this.clientId = clientId;
        this.productId = productId;
        this.discount = discount;
    }*/

    public SaleModel(ClientModel client, ProductModel product, Double discount) {
        this.client = client;
        this.product = product;
        this.discount = discount;
    }
}
