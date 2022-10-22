package com.IronhackLastProject.BankingApp.entities.users;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Admin extends User {
    @NotNull
    private String name;
    public Admin() {
    }

    public Admin(String username, String password, String name) {
        super(username, password);
        this.name = name;
    }

    public Admin(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
