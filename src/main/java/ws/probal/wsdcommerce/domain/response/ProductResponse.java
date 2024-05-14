package ws.probal.wsdcommerce.domain.response;

import lombok.*;
import ws.probal.wsdcommerce.domain.entity.Product;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long productId;
    private String productName;
    private String productDescription;

    public static ProductResponse from(Product product) {
        return ProductResponse
                .builder()
                .productId(product.getId())
                .productName(product.getName())
                .productDescription(product.getDescription())
                .build();
    }
}
