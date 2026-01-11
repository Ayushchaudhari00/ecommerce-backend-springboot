package Noddy.E_Commerce.Repository;

import Noddy.E_Commerce.Entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepo extends JpaRepository<OrderItems,Long> {
}
