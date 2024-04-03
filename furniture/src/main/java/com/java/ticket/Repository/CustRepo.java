package com.java.ticket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.ticket.Model.User;

public interface CustRepo  extends JpaRepository<User,Integer>{
    
}
