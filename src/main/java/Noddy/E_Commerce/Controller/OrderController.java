package Noddy.E_Commerce.Controller;

import Noddy.E_Commerce.DTO.OrderResponseDto;
import Noddy.E_Commerce.Entity.Order;
import Noddy.E_Commerce.Service.OrderService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/place")
    public ResponseEntity<OrderResponseDto> place(
            @RequestBody Map<Long, Integer> productMap,
            Principal principal) {

        return ResponseEntity.ok(orderService.placeOrder(principal.getName(), productMap));
    }
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}
