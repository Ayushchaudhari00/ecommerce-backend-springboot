package Noddy.E_Commerce.Controller;

import Noddy.E_Commerce.DTO.LoginDto;
import Noddy.E_Commerce.DTO.RegisterDto;
import Noddy.E_Commerce.Jwt.JwtService;
import Noddy.E_Commerce.Service.UserService;
import Noddy.E_Commerce.customClasses.MyUserDetailsService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final MyUserDetailsService userDetailsService;

    public AuthController(UserService userService,
                          AuthenticationManager authenticationManager,
                          JwtService jwtService,
                          MyUserDetailsService userDetailsService) {

        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto dto) {
        userService.register(dto);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto dto) {
        try {
            Authentication authInput = new UsernamePasswordAuthenticationToken(
                    dto.getUsername(),
                    dto.getPassword()
            );

            Authentication authenticatedResult = authenticationManager.authenticate(authInput);

            UserDetails userDetails = (UserDetails) authenticatedResult.getPrincipal();

            String token = jwtService.generateToken(userDetails);
            return ResponseEntity.ok(token);

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        } catch (Exception e) {
            return ResponseEntity.status(403).body("Authentication failed: " + e.getMessage());
        }
    }
}

