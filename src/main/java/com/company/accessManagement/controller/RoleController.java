package com.company.accessManagement.controller;

import com.company.accessManagement.entity.Permission;
import com.company.accessManagement.entity.Role;
import com.company.accessManagement.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping
    public Role createRole(@RequestBody Role role)
    {
        return roleService.createRole(role);
    }

    @PostMapping("/{roleId}/permissions")
    public Role assignPermissionToRole(
            @PathVariable Integer roleId,
            @RequestBody Set<Permission.PermissionName> permissionNames
    ){
        return roleService.assignPermissionsToRole(roleId,permissionNames);
    }

    @GetMapping
    public List<Role> getAllRole(){
        return roleService.getAllRoles();
    }
}
