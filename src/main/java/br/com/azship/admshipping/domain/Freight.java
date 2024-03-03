package br.com.azship.admshipping.domain;

import java.util.Map;

public class Freight {

    private String id;
    private Map<String, Object> propriedades;

    public Freight() {
    }

    public Freight(String id, Map<String, Object> propriedades) {
        this.id = id;
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
}
