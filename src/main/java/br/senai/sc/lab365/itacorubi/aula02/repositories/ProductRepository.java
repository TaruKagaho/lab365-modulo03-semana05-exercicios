package br.senai.sc.lab365.itacorubi.aula02.repositories;

import br.senai.sc.lab365.itacorubi.aula02.models.ProductModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
