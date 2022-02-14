package spring.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class JwtUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //load from dynamoDB check that user is enabled, non expired and password matches
        //not sure that I need this, not sure if I understand this...
        //find use case when it can be used...
        if (username.contains("fsociety"))
            return new User("fsociety_me", "toto", new ArrayList<>());
        else throw new UsernameNotFoundException("username : " + username + " not found");
    }
}
