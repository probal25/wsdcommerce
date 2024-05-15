package ws.probal.wsdcommerce.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.probal.wsdcommerce.common.utils.AppUtils;
import ws.probal.wsdcommerce.domain.request.SearchRequest;
import ws.probal.wsdcommerce.domain.response.SaleDayResponse;
import ws.probal.wsdcommerce.domain.response.SoldProductWithAmountResponse;
import ws.probal.wsdcommerce.domain.response.SoldProductWithQuantityResponse;
import ws.probal.wsdcommerce.service.sale.ISaleAnalyticsService;

import java.util.List;

@RestController
@RequestMapping(AppUtils.BASE_URL + "/sale-analytics")
@RequiredArgsConstructor
public class SaleAnalyticsResource {

    private final ISaleAnalyticsService saleAnalyticsService;

    @GetMapping("/total-sale-amount-today")
    public ResponseEntity<SaleDayResponse> getTotalSaleAmountToday() {
        SaleDayResponse saleDayResponse = saleAnalyticsService.getTotalSaleAmountToday();
        return ResponseEntity.ok().body(saleDayResponse);
    }

    @PostMapping("/max-sale-day")
    public ResponseEntity<SaleDayResponse> getMaxSaleDay(@RequestBody SearchRequest searchRequest) {
        SaleDayResponse saleDayResponse = saleAnalyticsService.getMaxSaleDay(searchRequest);
        return ResponseEntity.ok().body(saleDayResponse);
    }

    @GetMapping("/top-selling-items/all-time")
    public ResponseEntity<List<SoldProductWithAmountResponse>> topFiveSellingItemsOfAllTime() {
        List<SoldProductWithAmountResponse> soldProducts = saleAnalyticsService.topFiveSellingItemsOfAllTime();
        return ResponseEntity.ok().body(soldProducts);
    }

    @GetMapping("/top-selling-items/last-month")
    public ResponseEntity<List<SoldProductWithQuantityResponse>> topFiveSellingItemsOfLastMonth() {
        List<SoldProductWithQuantityResponse> soldProducts = saleAnalyticsService.topFiveSellingItemsOfLastMonth();
        return ResponseEntity.ok().body(soldProducts);
    }
}
