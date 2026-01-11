package Noddy.E_Commerce.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {
    @NotBlank(message = "Name is required")
   private String username;
    @NotBlank(message = "Email is required")
    @Email(message = "Fill email")
   private String email;
    @NotBlank(message = "Write password")
   private String password;
}
