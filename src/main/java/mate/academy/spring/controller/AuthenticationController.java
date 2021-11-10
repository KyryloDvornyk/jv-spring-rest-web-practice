package mate.academy.spring.controller;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.impl.response.UserResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserResponseMapper userResponseMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                        UserResponseMapper userResponseMapper) {
        this.authenticationService = authenticationService;
        this.userResponseMapper = userResponseMapper;
    }

    @PostMapping
    public UserResponseDto registerUser(@RequestBody UserRequestDto userRequestDto) {
        User user = authenticationService.register(
                userRequestDto.getEmail(), userRequestDto.getPassword());
        return userResponseMapper.toDto(user);
    }
}