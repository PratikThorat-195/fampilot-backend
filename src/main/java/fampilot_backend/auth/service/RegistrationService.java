package fampilot_backend.auth.service;

import fampilot_backend.auth.dto.RegistrationRequest;
import fampilot_backend.auth.entity.User;
import fampilot_backend.auth.exception.EmailAlreadyExistsException;
import fampilot_backend.auth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(RegistrationRequest request)
    {
        if(userRepository.existsByEmail(request.getEmail()))
        {
            throw new EmailAlreadyExistsException("Email is already registered");
        }

//      password hash
        String passwordHash = passwordEncoder.encode(request.getPassword());

//      create User
        User user = new User();

//      set values
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordHash);

//      save User
        User savedUser = userRepository.save(user);
        return savedUser;
    }


}
