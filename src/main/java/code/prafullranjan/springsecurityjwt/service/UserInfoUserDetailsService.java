package code.prafullranjan.springsecurityjwt.service;

import code.prafullranjan.springsecurityjwt.entity.UserEntity;
import code.prafullranjan.springsecurityjwt.entity.UserInfoUserDetails;
import code.prafullranjan.springsecurityjwt.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserInfoUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByName(username);
        return user.map(UserInfoUserDetails :: new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found" + username));
    }
}
