package ws.probal.wsdcommerce.api;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.probal.wsdcommerce.common.utils.AppUtils;
import ws.probal.wsdcommerce.domain.response.CustomerWishListResponse;
import ws.probal.wsdcommerce.service.wishlist.IUserWishListService;

import java.util.List;

@RestController
@RequestMapping(AppUtils.BASE_URL + "/wish-list")
@RequiredArgsConstructor
public class UserWishListResource {

    private final IUserWishListService userWishListService;

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerWishListResponse> getCustomerWishList(@PathVariable("customerId") Long customerId) {
        CustomerWishListResponse customerWishListResponse = userWishListService.getCustomerWishList(customerId);
        return ResponseEntity.ok().body(customerWishListResponse);
    }

}
