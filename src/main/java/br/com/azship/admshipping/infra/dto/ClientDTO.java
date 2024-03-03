package br.com.azship.admshipping.infra.dto;

import br.com.azship.admshipping.domain.Client;

public record ClientDTO(

        String client_id,
        String nome,
        String cnpj

) {

    public ClientDTO (Client client){
        this(client.getClient_id(), client.getNome(), client.getCnpj());
    }

    public static Client toClient(ClientDTO clientDTO){
        return new Client(clientDTO.client_id, clientDTO.nome, clientDTO.cnpj);
    }


}
