//package com.example.Swapi.SpringSecurity.configs;
//
//import com.example.Swapi.SpringSecurity.entities.Role;
//import com.example.Swapi.SpringSecurity.entities.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//public class CustomUserDetails implements UserDetails {
//
//    private final User user;
//
//    public CustomUserDetails(User user) {
//        this.user = user;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Set<Role> roles = user.getRoles();
//        return roles.stream()
//                .flatMap(role -> role.getPermissions().stream())
//                .map(permission -> new SimpleGrantedAuthority(permission.getName()))
//                .collect(Collectors.toSet());
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    public Long getId(){
//        return user.getId();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
