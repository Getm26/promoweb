package com.mercadona.promoweb.administrator;


import org.springframework.stereotype.Repository;

import com.mercadona.promoweb.user.User;

@Repository
public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
    
    User findByLogin(String login);
}
