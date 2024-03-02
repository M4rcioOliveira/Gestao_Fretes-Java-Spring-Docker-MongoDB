package br.com.azship.admshipping.application.domain;

import java.util.Map;
import java.util.UUID;

public class Shipping {
    private UUID id;
    private Cliente cliente;
    private Map<String, Object> propriedades;

    public Shipping() {
    }

    public Shipping(UUID id, Cliente cliente, Map<String, Object> propriedades) {
        this.id = id;
        this.cliente = cliente;
        this.propriedades = propriedades;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Map<String, Object> getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(Map<String, Object> propriedades) {
        this.propriedades = propriedades;
    }
}
