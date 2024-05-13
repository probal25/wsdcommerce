package ws.probal.wsdcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.probal.wsdcommerce.domain.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
