package com.STOCK_DJ.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.STOCK_DJ.model.User;


public interface UserRepository extends JpaRepository<User,Long>  {

}
