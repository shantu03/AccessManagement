package com.company.accessManagement.entity;

import com.company.accessManagement.audit.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity extends BaseAuditEntity {

    @Id
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    private String name;





    @Override
    public String toString(){
        return "id = "+id+"  name = "+name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
}
