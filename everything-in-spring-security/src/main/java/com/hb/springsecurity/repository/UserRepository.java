package com.hb.springsecurity.repository;

import com.hb.springsecurity.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<Users, String> {

}
