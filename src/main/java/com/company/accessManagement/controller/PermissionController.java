package com.company.accessManagement.controller;

import com.company.accessManagement.dao.PermissionRepository;
import com.company.accessManagement.entity.Permission;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
    private final PermissionRepository permissionRepository;

    public PermissionController(PermissionRepository permissionRepository)
    {
        this.permissionRepository=permissionRepository;
    }

    @PostMapping
    public Permission createPermission(@RequestBody Permission permission)
    {
        return permissionRepository.save(permission);
    }

    @GetMapping
    public List<Permission> getAllPermission(){
        return permissionRepository.findAll();
    }

}
