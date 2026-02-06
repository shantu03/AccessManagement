package com.company.accessManagement.service;

import com.company.accessManagement.dao.PermissionRepository;
import com.company.accessManagement.dao.RoleRepository;
import com.company.accessManagement.entity.Permission;
import com.company.accessManagement.entity.Role;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleService {

        private final RoleRepository roleRepository;
        private final PermissionRepository permissionRepository;

        public RoleService(RoleRepository roleRepository,
                           PermissionRepository permissionRepository){
            this.roleRepository=roleRepository;
            this.permissionRepository=permissionRepository;
        }
        public Role createRole(Role role)
        {
            return roleRepository.save(role);
        }

        @Transactional
        public Role assignPermissionsToRole(Integer roleId, Set<Permission.PermissionName> permissionNames)
        {
            Role role=roleRepository.findById(roleId).orElseThrow(()->new RuntimeException("Role Not Found"));
            Set<Permission> permissions=new HashSet<>();

            for(Permission.PermissionName permissionName: permissionNames)
            {
                Permission permission=permissionRepository.findByName(permissionName).orElseThrow(()->new RuntimeException("Permission Not FOund"));

                permissions.add(permission);
            }
            role.getPermissions().addAll(permissions);

            return role;
        }

        public List<Role> getAllRoles(){
            return roleRepository.findAll();
        }
}
