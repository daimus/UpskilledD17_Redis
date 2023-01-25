package id.daimus.redis.infrastructure.presenter.rest.authentication;

import id.daimus.redis.infrastructure.presenter.rest.Response;
import id.daimus.redis.infrastructure.presenter.rest.authentication.dto.SignInRequestDto;
import id.daimus.redis.infrastructure.presenter.rest.authentication.dto.SignInResponseDto;
import id.daimus.redis.infrastructure.presenter.rest.authentication.util.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@RestController
@RequestMapping("/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping(path = "/signin")
    public ResponseEntity<Object> signIn(@Valid @RequestBody SignInRequestDto signInRequest){
        log.info("GET /auth/signin called");
        Response response = new Response();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );
        String token = jwtUtil.generateToken(signInRequest.getUsername());
        SignInResponseDto signInResponse = new SignInResponseDto(token);
        response.setData(signInResponse);
        return response.getResponse();
    }
}
