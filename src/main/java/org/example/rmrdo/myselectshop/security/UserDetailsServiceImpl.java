package org.example.rmrdo.myselectshop.security;

import lombok.RequiredArgsConstructor;
import org.example.rmrdo.myselectshop.entity.User;
import org.example.rmrdo.myselectshop.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("NOT FOUND : " + username));

        return new UserDetailsImpl(user);
    }
}
