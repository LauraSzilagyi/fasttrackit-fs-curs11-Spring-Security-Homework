package ro.fasttrackit.curs11homework.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs11homework.model.security.MyUserDetails;
import ro.fasttrackit.curs11homework.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .map(user -> new MyUserDetails(user.username(), user.password(), user.roles()))
                .orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));
    }
}


