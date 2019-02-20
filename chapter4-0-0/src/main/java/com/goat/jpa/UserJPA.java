package com.goat.jpa;

import com.goat.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;


public interface UserJPA extends JpaRepository<UserEntity, Long>,JpaSpecificationExecutor<UserEntity>,Serializable{



}
