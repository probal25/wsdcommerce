package ws.probal.wsdcommerce.service.wishlist;


import ws.probal.wsdcommerce.domain.response.CustomerWishListResponse;

import java.util.List;

public interface IUserWishListService {

    CustomerWishListResponse getCustomerWishList(Long customerId);

}
