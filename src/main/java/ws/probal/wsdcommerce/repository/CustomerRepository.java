package ws.probal.wsdcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.probal.wsdcommerce.domain.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
