package Noddy.E_Commerce.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OderItemsDto {
        private Long productId;
        private String productName;
        private Integer quantity;
        private Double priceAtPurchase;

}
