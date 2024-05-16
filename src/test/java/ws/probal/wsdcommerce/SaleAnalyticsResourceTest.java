package ws.probal.wsdcommerce;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ws.probal.wsdcommerce.domain.request.SearchRequest;
import ws.probal.wsdcommerce.domain.response.SaleDayResponse;
import ws.probal.wsdcommerce.domain.response.SoldProductWithAmountResponse;
import ws.probal.wsdcommerce.domain.response.SoldProductWithQuantityResponse;
import ws.probal.wsdcommerce.service.sale.SaleAnalyticsService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SaleAnalyticsResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SaleAnalyticsService saleAnalyticsService;

    @Autowired
    private ObjectMapper objectMapper;

    private SaleDayResponse saleDayResponse;
    private SoldProductWithAmountResponse soldProductWithAmountResponse;
    private SoldProductWithQuantityResponse soldProductWithQuantityResponse;
    private SearchRequest searchRequest;
    private final String BASE_SALE_ANALYTICS_URL = "/api/v1/wsd/sale-analytics";

    @BeforeEach
    public void setUp() {
        // Initialize test data
        saleDayResponse = new SaleDayResponse(LocalDate.now(), new BigDecimal("100.00"));

        soldProductWithAmountResponse = new SoldProductWithAmountResponse(1L, "Product 1", "Description 1", new BigDecimal("500.00"));

        soldProductWithQuantityResponse = new SoldProductWithQuantityResponse(1L, "Product 1", "Description 1", BigDecimal.valueOf(50));

        searchRequest = new SearchRequest(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 31));
    }

    @Test
    public void testGetTotalSaleAmountToday() throws Exception {
        when(saleAnalyticsService.getTotalSaleAmountToday()).thenReturn(saleDayResponse);

        mockMvc.perform(get(BASE_SALE_ANALYTICS_URL + "/total-sale-amount-today")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.date").value(saleDayResponse.getDate().toString()))
                .andExpect(jsonPath("$.amount").value(saleDayResponse.getAmount().intValue()));
    }

    @Test
    public void testGetMaxSaleDay() throws Exception {
        when(saleAnalyticsService.getMaxSaleDay(any(SearchRequest.class))).thenReturn(saleDayResponse);

        mockMvc.perform(post(BASE_SALE_ANALYTICS_URL + "/max-sale-day")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(searchRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.date").value(saleDayResponse.getDate().toString()))
                .andExpect(jsonPath("$.amount").value(saleDayResponse.getAmount().intValue()));
    }

    @Test
    public void testTopFiveSellingItemsOfAllTime() throws Exception {
        List<SoldProductWithAmountResponse> responseList = Arrays.asList(soldProductWithAmountResponse);
        when(saleAnalyticsService.topFiveSellingItemsOfAllTime()).thenReturn(responseList);

        mockMvc.perform(get(BASE_SALE_ANALYTICS_URL + "/top-selling-items/all-time")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].productId").value(soldProductWithAmountResponse.getProductId()))
                .andExpect(jsonPath("$[0].productName").value(soldProductWithAmountResponse.getProductName()))
                .andExpect(jsonPath("$[0].productDescription").value(soldProductWithAmountResponse.getProductDescription()))
                .andExpect(jsonPath("$[0].totalSaleAmount").value(soldProductWithAmountResponse.getTotalSaleAmount().intValue()));
    }

    @Test
    public void testTopFiveSellingItemsOfLastMonth() throws Exception {
        List<SoldProductWithQuantityResponse> responseList = Arrays.asList(soldProductWithQuantityResponse);
        when(saleAnalyticsService.topFiveSellingItemsOfLastMonth()).thenReturn(responseList);

        mockMvc.perform(get(BASE_SALE_ANALYTICS_URL + "/top-selling-items/last-month")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].productId").value(soldProductWithQuantityResponse.getProductId()))
                .andExpect(jsonPath("$[0].productName").value(soldProductWithQuantityResponse.getProductName()))
                .andExpect(jsonPath("$[0].productDescription").value(soldProductWithQuantityResponse.getProductDescription()))
                .andExpect(jsonPath("$[0].totalQuantity").value(soldProductWithQuantityResponse.getTotalQuantity().intValue()));
    }
}
