package Noddy.E_Commerce.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class OrderResponseDto {
    public Long orderId;
    public String status;
    public double totalAmount;
    public List<String> itemSummary;
}
