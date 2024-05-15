package ws.probal.wsdcommerce.service.sale;

import ws.probal.wsdcommerce.domain.request.SearchRequest;
import ws.probal.wsdcommerce.domain.response.ProductResponse;
import ws.probal.wsdcommerce.domain.response.SaleDayResponse;
import ws.probal.wsdcommerce.domain.response.SoldProductWithAmountResponse;
import ws.probal.wsdcommerce.domain.response.SoldProductWithQuantityResponse;

import java.time.LocalDate;
import java.util.List;

public interface ISaleAnalyticsService {

    SaleDayResponse getTotalSaleAmountToday();

    SaleDayResponse getMaxSaleDay(SearchRequest searchRequest);

    List<SoldProductWithAmountResponse> topFiveSellingItemsOfAllTime();

    List<SoldProductWithQuantityResponse> topFiveSellingItemsOfLastMonth();

}
