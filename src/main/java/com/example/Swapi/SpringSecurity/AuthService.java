package com.example.Swapi.SpringSecurity;

import com.example.Swapi.SpringSecurity.entities.Action;
import com.example.Swapi.SpringSecurity.entities.Object;
import com.example.Swapi.SpringSecurity.entities.User;
import com.example.Swapi.SpringSecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toList())
        );
    }

    public boolean hasPermission(Authentication authentication, Object object, Action action){
        User user = (User) authentication.getPrincipal();
        return user.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .filter(permission -> permission.getAction().equals(action) && permission.getObject().equals(object))
                .findFirst()
                .isPresent();
    }


//    public boolean hasPermission(Authentication authentication,  int actionId,int objectId){
//        User user = (User) authentication.getPrincipal();
//        return user.getRoles().stream()
//                .flatMap(role -> role.getPermissions().stream())
//                .filter(permission -> permission.getActionId().equals(actionId) && permission.getObjectId().equals(objectId))
//                .findFirst()
//                .isPresent();
//    }
}
