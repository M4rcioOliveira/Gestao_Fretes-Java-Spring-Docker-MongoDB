package br.com.azship.admshipping.domain;

import br.com.azship.admshipping.domain.dto.FreighResponseDomainDTO;

import java.util.Map;

public class Freight {
    private String id;
    private Client client;
    private Map<String, Object> propriedades;

    public Freight() {
    }

    public Freight(String id, Client client, Map<String, Object> propriedades) {
        this.id = id;
        this.client = client;
        this.propriedades = propriedades;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Object> getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(Map<String, Object> propriedades) {
        this.propriedades = propriedades;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public static FreighResponseDomainDTO toFreightDomainDTO(Freight freight){

        return new FreighResponseDomainDTO(freight.getId(), freight.client, freight.getPropriedades());

    }

}
