package ws.probal.wsdcommerce.service.wishlist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ws.probal.wsdcommerce.domain.entity.Customer;
import ws.probal.wsdcommerce.domain.entity.Product;
import ws.probal.wsdcommerce.domain.response.CustomerWishListResponse;
import ws.probal.wsdcommerce.domain.response.ProductResponse;
import ws.probal.wsdcommerce.repository.WishListRepository;
import ws.probal.wsdcommerce.service.customer.ICustomerService;
import ws.probal.wsdcommerce.service.product.IProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserWishListService implements IUserWishListService {

    private final ICustomerService customerService;
    private final IProductService productService;
    private final WishListRepository wishListRepository;

    @Override
    public CustomerWishListResponse getCustomerWishList(Long customerId) {

        Customer customer = customerService.findCustomerInfoByCustomerId(customerId);

        List<ProductResponse> wishProductInfoOfCustomer = getWishProductInfoOfCustomer(customerId);

        return CustomerWishListResponse.from(customer, wishProductInfoOfCustomer);
    }

    private List<ProductResponse> getWishProductInfoOfCustomer(Long customerId) {
        List<Long> productIdsByCustomerId = wishListRepository.findProductIdsByCustomerId(customerId);
        List<Product> productList = productService.findAllProductByIdList(productIdsByCustomerId);
        return productList.stream().map(ProductResponse::from).toList();
    }
}
