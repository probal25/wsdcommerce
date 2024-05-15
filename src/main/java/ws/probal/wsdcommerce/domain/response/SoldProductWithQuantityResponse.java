package ws.probal.wsdcommerce.domain.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SoldProductWithQuantityResponse {
    private Long productId;
    private String productName;
    private String productDescription;
    private BigDecimal totalQuantity;
}
