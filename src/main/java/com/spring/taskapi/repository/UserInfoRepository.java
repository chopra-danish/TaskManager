package com.spring.taskapi.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.taskapi.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

	Optional<UserInfo> findByUsername(String username);

}