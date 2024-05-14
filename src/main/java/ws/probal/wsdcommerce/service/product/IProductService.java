package ws.probal.wsdcommerce.service.product;

import ws.probal.wsdcommerce.domain.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllProductByIdList(List<Long> productIdList);
}
