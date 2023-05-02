//package com.example.Swapi.SpringSecurity;
//
//import com.example.Swapi.SpringSecurity.entities.Permission;
//import com.example.Swapi.SpringSecurity.entities.Role;
//import com.example.Swapi.SpringSecurity.entities.User;
//import com.example.Swapi.SpringSecurity.repositories.PermissionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.PermissionEvaluator;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
//
//import java.io.Serializable;
//import java.util.Optional;
//import java.util.Set;
//
//@Component
//public class CustomPermissionEvaluator implements PermissionEvaluator {
//    private final PermissionRepository permissionRepository;
//
//    public CustomPermissionEvaluator(PermissionRepository permissionRepository) {
//        this.permissionRepository = permissionRepository;
//    }
//
//    @Override
//    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
//        if((authentication == null) || (targetDomainObject == null) || !(permission instanceof String)){
//            return false;
//        }
//
//        String targetType = targetDomainObject.getClass().getSimpleName().toUpperCase();
//        PermissionType permissionType = PermissionType.valueOf(permission.toString().toUpperCase());
//
//        User user = (User) authentication.getPrincipal();
//        Set<Role> roles = user.getRoles();
//
//        for (Role role : roles){
//            Set<Permission> permissions = role.getPermissions();
//            for (Permission p : permissions){
//                if(p.getObject().getName().equals(targetType) && p.getAction().getName().equals(permissionType.toString())){
//                    return true;
//                }
//            }
//        }
//            return false;
//    }
//
//    @Override
//    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
//        if ((authentication == null) || !(permission instanceof String)){
//            return false;
//        }
//
//        PermissionType permissionType = PermissionType.valueOf(permission.toString().toUpperCase());
//
//        Optional<Permission> optionalPermission = permissionRepository.findByObjectIdAndActionName(targetId,targetType,permissionType.toString());
//        if (optionalPermission.isPresent()){
//            return hasPermission(authentication, optionalPermission.get().getObject(), permission);
//        }else{
//            return false;
//        }
//    }
//}
