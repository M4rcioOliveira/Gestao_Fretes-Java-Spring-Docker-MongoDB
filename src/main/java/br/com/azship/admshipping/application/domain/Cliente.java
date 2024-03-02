package br.com.azship.admshipping.application.domain;

import br.com.azship.admshipping.application.domain.Shipping;

import java.util.List;
import java.util.UUID;

public class Cliente {
    private UUID id;
    private String nome;
    private String cnpj;
    private List<Shipping> shippings;

    public Cliente(UUID id, String nome, String cnpj, List<Shipping> shippings) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.shippings = shippings;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Shipping> getShipping() {
        return shippings;
    }
}
