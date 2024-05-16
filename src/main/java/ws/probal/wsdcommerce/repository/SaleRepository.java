package ws.probal.wsdcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ws.probal.wsdcommerce.domain.entity.Sale;
import ws.probal.wsdcommerce.domain.response.SaleDayResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = "SELECT total_amount FROM sale WHERE sale_date = :saleDate", nativeQuery = true)
    BigDecimal totalAmountBySaleDate(LocalDate saleDate);

    @Query(value = "SELECT sale_date AS date,\n" +
            "       total_amount AS amount\n" +
            "FROM sale\n" +
            "WHERE total_amount = (\n" +
            "    SELECT MAX(total_amount)\n" +
            "    FROM sale\n" +
            "    WHERE sale_date BETWEEN :startDate AND :endDate" +
            ")", nativeQuery = true)
    List<Object[]> maxSaleDayInSaleDate(LocalDate startDate, LocalDate endDate);

}
