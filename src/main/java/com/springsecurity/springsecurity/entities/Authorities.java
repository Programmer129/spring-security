package com.springsecurity.springsecurity.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities", schema = "test")
public class Authorities {

    @Id
    private Integer id;

    @Column(name = "username")
    private String userName;

    @Column(name = "authority")
    private String authority;

    public Authorities() { }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
