package ws.probal.wsdcommerce.service.customer;

import ws.probal.wsdcommerce.domain.entity.Customer;

public interface ICustomerService {

    Customer findCustomerInfoByCustomerId(Long customerId);
}
