package br.com.azship.admshipping.domain;

public class Client {

    private String client_id;
    private String nome;
    private String cnpj;

    public Client(String client_id, String nome, String cnpj) {
        this.client_id = client_id;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }
}
