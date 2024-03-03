package br.com.azship.admshipping.infra.entity;

import br.com.azship.admshipping.domain.Freight;
import br.com.azship.admshipping.infra.dto.ClientDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;


@Document(collection = "fretes")
@Getter
@Setter
@NoArgsConstructor
public class FreightEntity {

    @Id
    private String id;
    private ClientDTO cliente;
    @Indexed
    private String propriedadesJson;
    private Map<String, Object> propriedades;

    public static Freight toFreight(FreightEntity freightEntity) {

        return new Freight(freightEntity.id, ClientDTO.toClient(freightEntity.cliente), freightEntity.propriedades);

    }

    public FreightEntity(Freight freight) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            this.propriedadesJson = objectMapper.writeValueAsString(freight.getPropriedades());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        this.id = freight.getId();
        this.cliente = new ClientDTO(freight.getClient());
        this.propriedades = freight.getPropriedades();

    }


}
