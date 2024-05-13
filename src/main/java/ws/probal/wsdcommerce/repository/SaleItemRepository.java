package ws.probal.wsdcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.probal.wsdcommerce.domain.entity.SaleItem;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {
}
