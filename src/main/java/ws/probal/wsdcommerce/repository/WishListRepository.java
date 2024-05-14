package ws.probal.wsdcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ws.probal.wsdcommerce.domain.entity.Wishlist;

import java.util.List;

public interface WishListRepository extends JpaRepository<Wishlist, Long> {
    List<Wishlist> findByCustomerId(Long customerId);

    @Query(value = "select product_id from wish_list where customer_id = ?1", nativeQuery = true)
    List<Long> findProductIdsByCustomerId(Long customerId);
}
