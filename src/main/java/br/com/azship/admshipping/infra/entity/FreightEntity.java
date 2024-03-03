package br.com.azship.admshipping.infra.entity;

import br.com.azship.admshipping.domain.Freight;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;
import java.util.UUID;


@Document(collection = "fretes")
@Getter
@Setter
@NoArgsConstructor
public class FreightEntity {

    @Id
    private String id;
    private Map<String, Object> propriedades;

    public static Freight toFreight(FreightEntity freightEntity) {

        return new Freight(freightEntity.id, freightEntity.propriedades);

    }

    public FreightEntity(Freight freight) {

        this.id = freight.getId();
        this.propriedades = freight.getPropriedades();

    }

}
