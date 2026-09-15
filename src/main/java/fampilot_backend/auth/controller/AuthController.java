package fampilot_backend.auth.controller;

import fampilot_backend.auth.dto.RegistrationRequest;
import fampilot_backend.auth.dto.RegistrationResponse;
import fampilot_backend.auth.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController
{
    private final RegistrationService registrationService;


    public AuthController(RegistrationService registrationService)
    {
        this.registrationService = registrationService;
    }

    @PostMapping("/api/auth/register")
    public RegistrationResponse register(@Valid @RequestBody RegistrationRequest request)
    {

        registrationService.register(request);

        RegistrationResponse response = new RegistrationResponse();

        response.setMessage("Registration successful");
        response.setEmail(request.getEmail());
        return response;
    }
}




