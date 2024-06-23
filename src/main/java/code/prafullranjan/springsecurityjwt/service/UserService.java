package code.prafullranjan.springsecurityjwt.service;

import code.prafullranjan.springsecurityjwt.repository.UserRepository;
import code.prafullranjan.springsecurityjwt.entity.UserEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity addUser(UserEntity entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return userRepository.save(entity);
    }

    public UserEntity getUserByName(String username) {
        return userRepository.findByName(username).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }
}
