package com.example.Swapi.SpringSecurity.repositories;

import com.example.Swapi.SpringSecurity.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

//    List<Permission> findByRole(Long roleId);
//
//@Query("SELECT p FROM Permission p WHERE p.object_id = :objectId AND p.action_id = :actionName AND p.name = :actionType")
//Optional<Permission> findByObjectIdAndActionName(Long objectId, Long actionName, String actionType);
//
//    boolean existsByRoleIdAndActionIdAndObjectId(Long roleId, Long actionId, Long objectId);
}
