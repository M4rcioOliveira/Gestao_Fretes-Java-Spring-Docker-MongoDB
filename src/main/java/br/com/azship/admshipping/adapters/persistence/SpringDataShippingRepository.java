package br.com.azship.admshipping.adapters.persistence;

import br.com.azship.admshipping.application.domain.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataShippingRepository extends JpaRepository<Shipping, UUID> {
}
