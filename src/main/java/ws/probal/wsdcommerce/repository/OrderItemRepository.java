package ws.probal.wsdcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.probal.wsdcommerce.domain.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
