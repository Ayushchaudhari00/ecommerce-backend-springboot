package Noddy.E_Commerce.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    @NotBlank(message = "email is required")
   private String username;
    @NotBlank(message = "password is required")
   private String password;

}
