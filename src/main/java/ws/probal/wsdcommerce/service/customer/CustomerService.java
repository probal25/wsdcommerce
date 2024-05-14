package ws.probal.wsdcommerce.service.customer;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ws.probal.wsdcommerce.common.exception.RecordNotFoundException;
import ws.probal.wsdcommerce.domain.entity.Customer;
import ws.probal.wsdcommerce.repository.CustomerRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer findCustomerInfoByCustomerId(Long customerId) {

        Optional<Customer> customerOptional = customerRepository.findById(customerId);

        if (customerOptional.isEmpty()) {
            throw new RecordNotFoundException("Customer with " + customerId + " does not exist");
        }

        return customerOptional.get();
    }

}
