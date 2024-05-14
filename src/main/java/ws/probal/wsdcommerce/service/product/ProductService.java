package ws.probal.wsdcommerce.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ws.probal.wsdcommerce.domain.entity.Product;
import ws.probal.wsdcommerce.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAllProductByIdList(List<Long> productIdList) {
        return productRepository.findAllByIdIn(productIdList);
    }
}
