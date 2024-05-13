package ws.probal.wsdcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.probal.wsdcommerce.domain.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
