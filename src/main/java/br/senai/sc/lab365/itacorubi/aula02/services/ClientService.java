package br.senai.sc.lab365.itacorubi.aula02.services;

import br.senai.sc.lab365.itacorubi.aula02.dtos.ClientRequest;
import br.senai.sc.lab365.itacorubi.aula02.dtos.ClientResponse;
import br.senai.sc.lab365.itacorubi.aula02.models.ClientModel;
import br.senai.sc.lab365.itacorubi.aula02.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private ClientRepository clientRepository;

    public void add(ClientRequest newClient) {
        ClientModel newClientModel = new ClientModel();

        BeanUtils.copyProperties(newClient, newClientModel);

        clientRepository.save(newClientModel);
    }

    public List<ClientResponse> listAllClients() {
        List<ClientModel> listOfClients = this.clientRepository.findAll();

        return convertClientListToClientResponseList(listOfClients);
    }

    private List<ClientResponse> convertClientListToClientResponseList(
            List<ClientModel> clientsList
    ) {
        List<ClientResponse> listOfClientsResponse = new ArrayList<>();

        for ( ClientModel client : clientsList ) {
            ClientResponse clientResponse = new ClientResponse();

            BeanUtils.copyProperties(client, clientResponse);

            listOfClientsResponse.add(clientResponse);
        }

        return listOfClientsResponse;
    }
}
