package com.IronhackLastProject.BankingApp.entities.users;

import com.IronhackLastProject.BankingApp.security.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ThirdParty extends User {
    private String hashKey;
    private String name;

    public ThirdParty(String username, String password, String hashKey, String name) {
        super(username, password);
        this.hashKey = hashKey;
        this.name = name;
    }


    public ThirdParty() {
    }

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
