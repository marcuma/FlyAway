package com.simplilearn.flyaway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created: 10/09/2021 - 3:10 PM
 * Project: FlyAway
 *
 * @author marcuma
 */

@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @Column(name="user_id")
    private int id ;

    @Column(name="login_name")
    private String userName;

    @Column(name="password")
    private String password;

    public User() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
