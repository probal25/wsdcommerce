package ws.probal.wsdcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ws.probal.wsdcommerce.domain.entity.SaleItem;
import ws.probal.wsdcommerce.domain.response.SoldProductWithAmountResponse;
import ws.probal.wsdcommerce.domain.response.SoldProductWithQuantityResponse;

import java.time.LocalDate;
import java.util.List;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {

    @Query(value = "SELECT p.id AS productId,\n" +
            "       p.name AS productName,\n" +
            "       p.description AS productDescription,\n" +
            "       SUM(si.quantity * si.price) AS totalSaleAmount\n" +
            "FROM sale_item si\n" +
            "         JOIN product p ON si.product_id = p.id\n" +
            "GROUP BY p.id, p.name, p.description\n" +
            "ORDER BY totalSaleAmount DESC\n" +
            "LIMIT 5",
            nativeQuery = true)
    List<Object[]> getTopFiveSellingItemsOfAllTime();

    @Query(value = "SELECT p.id AS productId, " +
            "       p.name AS productName, " +
            "       p.description AS productDescription, " +
            "       SUM(si.quantity) AS totalQuantitySold " +
            "FROM sale_item si " +
            "JOIN sale s ON si.sale_id = s.id " +
            "JOIN product p ON si.product_id = p.id " +
            "WHERE s.sale_date BETWEEN :startDate AND :endDate " +
            "GROUP BY p.id, p.name, p.description " +
            "ORDER BY totalQuantitySold DESC " +
            "LIMIT 5",
            nativeQuery = true)
    List<Object[]> getTopFiveSellingItemsOfLastMonth(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
