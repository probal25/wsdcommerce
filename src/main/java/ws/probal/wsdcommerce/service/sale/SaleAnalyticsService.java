package ws.probal.wsdcommerce.service.sale;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ws.probal.wsdcommerce.domain.request.SearchRequest;
import ws.probal.wsdcommerce.domain.response.SaleDayResponse;
import ws.probal.wsdcommerce.domain.response.SoldProductWithAmountResponse;
import ws.probal.wsdcommerce.domain.response.SoldProductWithQuantityResponse;
import ws.probal.wsdcommerce.repository.SaleItemRepository;
import ws.probal.wsdcommerce.repository.SaleRepository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleAnalyticsService implements ISaleAnalyticsService {

    private final SaleRepository saleRepository;

    private final SaleItemRepository saleItemRepository;

    @Override
    public SaleDayResponse getTotalSaleAmountToday() {

        // assume current date is 2024-05-15
        String currentDateString = "2024-05-15";
        LocalDate currentDate = LocalDate.parse(currentDateString);
        BigDecimal currentDayTotalAmount = saleRepository.totalAmountBySaleDate(currentDate);

        return SaleDayResponse
                .builder()
                .date(currentDate)
                .amount(currentDayTotalAmount)
                .build();
    }

    @Override
    public SaleDayResponse getMaxSaleDay(SearchRequest searchRequest) {

        return saleRepository.maxSaleDayInSaleDate(
                searchRequest.getStartDate(),
                searchRequest.getEndDate()
        );
    }

    @Override
    public List<SoldProductWithAmountResponse> topFiveSellingItemsOfAllTime() {
        List<Object[]> topFiveSellingItemsOfAllTime = saleItemRepository.getTopFiveSellingItemsOfAllTime();

        List<SoldProductWithAmountResponse> responseList = new ArrayList<>();

        for (Object[] result : topFiveSellingItemsOfAllTime) {
            Long productId = Long.parseLong(String.valueOf(result[0]));
            String productName = (String) result[1];
            String productDescription = (String) result[2];
            BigDecimal totalSaleAmount = (BigDecimal) result[3];

            SoldProductWithAmountResponse response = new SoldProductWithAmountResponse(
                    productId, productName, productDescription, totalSaleAmount);
            responseList.add(response);
        }

        return responseList;
    }

    @Override
    public List<SoldProductWithQuantityResponse> topFiveSellingItemsOfLastMonth() {

        // assume current date is 2024-05-20
        String currentDateString = "2024-05-20";
        LocalDate currentDate = LocalDate.parse(currentDateString);

        LocalDate lastMonthStartDate = currentDate
                .minusMonths(1)
                .withDayOfMonth(1);

        LocalDate lastMonthEndDate = currentDate
                .minusMonths(1)
                .withDayOfMonth
                        (currentDate.minusMonths(1)
                                .lengthOfMonth()
                        );

        List<Object[]> topFiveSellingItemsOfLastMonth = saleItemRepository.getTopFiveSellingItemsOfLastMonth(lastMonthStartDate, lastMonthEndDate);

        List<SoldProductWithQuantityResponse> responseList = new ArrayList<>();

        for (Object[] result : topFiveSellingItemsOfLastMonth) {
            Long productId = Long.parseLong(String.valueOf(result[0]));
            String productName = (String) result[1];
            String productDescription = (String) result[2];
            BigDecimal totalQuantitySold = (BigDecimal) result[3];

            SoldProductWithQuantityResponse response = new SoldProductWithQuantityResponse(productId, productName, productDescription, totalQuantitySold);
            responseList.add(response);
        }

        return responseList;
    }
}
