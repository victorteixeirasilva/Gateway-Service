package tech.inovasoft.inevolving.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.inovasoft.inevolving.api.repository.interfaces.UserRepositoryJPA;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    UserRepositoryJPA repositoryJPA;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositoryJPA.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
