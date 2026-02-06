package com.company.accessManagement.service;

import com.company.accessManagement.dao.RoleRepository;
import com.company.accessManagement.dao.UserRepo;
import com.company.accessManagement.dto.CreateUser;
import com.company.accessManagement.entity.Role;
import com.company.accessManagement.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepository roleRepo;

    public List<UserEntity> getAll()
    {
        return userRepo.findAll();
    }




// NOT USING BECAUSE --> CREATED BELOW METHOD TO SOLVE PROBLEM OF ASSIGNIN GROLE TO USER WHILE ADDING USER

    public UserEntity createUser(UserEntity user)
    {
        System.out.println("inside userservice ; trying to save user ");
        return userRepo.save(user);
    }

    public UserEntity createUser(CreateUser user) {
        Role role = roleRepo.findById(user.getRole_id()).orElseThrow(
                () -> new RuntimeException("Cannot find role_id to assign user "));
        System.out.println("service is okay" +
                "");
        UserEntity user1=new UserEntity();
        user1.setId(user.getId());
        user1.setName(user.getName());
        user1.setRole(role);

        return userRepo.save(user1);
    }


    public void deleteUser(Integer id)
    {

        if(!userRepo.existsById(id)) throw
                new RuntimeException("Id doesn't exist to delete  "+id);

        userRepo.deleteById(id);

    }
}
