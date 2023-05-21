package com.mercadona.promoweb.administrator;

import org.springframework.stereotype.Indexed;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;

    public Administrator() {
    }

    public Administrator(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Administrator(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Administrator(String login) {
        this.login = login;
    }
    
    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
