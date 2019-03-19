package com.goat.shardingdb.repository;

import com.goat.shardingdb.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {

}
