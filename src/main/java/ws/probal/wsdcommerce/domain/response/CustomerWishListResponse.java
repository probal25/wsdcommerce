package ws.probal.wsdcommerce.domain.response;


import lombok.*;
import ws.probal.wsdcommerce.domain.entity.Customer;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerWishListResponse {
    private Long customerId;
    private String customerName;
    private List<ProductResponse> productResponses;

    public static CustomerWishListResponse from(Customer customer, List<ProductResponse> productResponses) {
        return CustomerWishListResponse
                .builder()
                .customerId(customer.getId())
                .customerName(customer.getName())
                .productResponses(productResponses)
                .build();
    }
}
