package Noddy.E_Commerce.Service;

import Noddy.E_Commerce.DTO.OderItemsDto;
import Noddy.E_Commerce.DTO.OrderResponseDto;
import Noddy.E_Commerce.Entity.Order;
import Noddy.E_Commerce.Entity.OrderItems;
import Noddy.E_Commerce.Entity.Product;
import Noddy.E_Commerce.Entity.User;
import Noddy.E_Commerce.Repository.OrderItemsRepo;
import Noddy.E_Commerce.Repository.OrderRepo;
import Noddy.E_Commerce.Repository.ProductRepo;
import Noddy.E_Commerce.Repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    private final OrderRepo orderRepo;
    private final UserRepo userRepo;
    private final ProductRepo productRepo;
    private final OrderItemsRepo orderItemRepo;

    public OrderService(OrderRepo orderRepo,
                        UserRepo userRepo,
                        ProductRepo productRepo,
                        OrderItemsRepo orderItemRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.productRepo = productRepo;
        this.orderItemRepo = orderItemRepo;
    }
    @Transactional
    public OrderResponseDto placeOrder(String username, Map<Long, Integer> productMap) {
        User user = userRepo.findByUsername(username).orElseThrow();


        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        Order savedOrder = orderRepo.save(order);

        double total = 0;
        List<String> summary = new ArrayList<>();

        for (Long pId : productMap.keySet()) {
            Product product = productRepo.findById(pId).orElseThrow();
            int qty = productMap.get(pId);

            product.setStock(product.getStock() - qty);
            productRepo.save(product);

            OrderItems item = new OrderItems();
            item.setOrder(savedOrder);
            item.setProduct(product);
            item.setQuantity(qty);
            orderItemRepo.save(item);

            total += (product.getPrice() * qty);
            summary.add(qty + "x " + product.getName());
        }

        // 3. Build Response
        OrderResponseDto res = new OrderResponseDto();
        res.orderId = savedOrder.getId();
        res.status = "SUCCESS";
        res.totalAmount = total;
        res.itemSummary = summary;
        return res;
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}
