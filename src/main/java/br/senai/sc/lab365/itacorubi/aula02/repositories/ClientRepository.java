package br.senai.sc.lab365.itacorubi.aula02.repositories;

import br.senai.sc.lab365.itacorubi.aula02.models.ClientModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {
}
