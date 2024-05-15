package ws.probal.wsdcommerce.domain.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {
    private LocalDate startDate;
    private LocalDate endDate;
}
