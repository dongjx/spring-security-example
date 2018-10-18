package com.springsecurityexample.api;

import com.springsecurityexample.api.dto.AuthenticationTokenResponse;
import com.springsecurityexample.model.User;
import com.springsecurityexample.repo.UserRepository;
import com.springsecurityexample.service.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserAuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<AuthenticationTokenResponse> authUser(@Param(value = "username")String username,
                                                             @Param(value = "password")String password) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String authToken = jwtTokenService.generateToken(authentication);
        return new ResponseEntity(new AuthenticationTokenResponse(authToken), HttpStatus.OK);
    }



    @PostMapping("/user")
    public ResponseEntity createUser(@Param(value = "username")String username,
                                 @Param(value = "password")String password) {
        if(userRepository.findByUsername(username) != null)
            return new ResponseEntity("Username is already taken!", HttpStatus.BAD_REQUEST);
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        return new ResponseEntity("User created!", HttpStatus.OK);
    }
}
