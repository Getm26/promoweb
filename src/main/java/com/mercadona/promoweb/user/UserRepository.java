package com.mercadona.promoweb.user;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

    User findByEmail(String email);

}
