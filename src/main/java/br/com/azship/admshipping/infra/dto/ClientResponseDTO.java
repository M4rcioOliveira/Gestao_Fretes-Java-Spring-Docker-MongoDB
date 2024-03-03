package br.com.azship.admshipping.infra.dto;

import br.com.azship.admshipping.domain.Client;

public record ClientResponseDTO(

        String cnpj,
        String nome,
        String client_id

) {

    public static Client toClient(ClientResponseDTO clientResponseDTO){
        return new Client(clientResponseDTO.client_id, clientResponseDTO.nome, clientResponseDTO.cnpj);
    }


}
