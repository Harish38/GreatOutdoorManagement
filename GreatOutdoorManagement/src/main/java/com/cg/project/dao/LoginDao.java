package com.cg.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.project.entity.Login;

public interface LoginDao extends JpaRepository<Login, String> {
	@Query(" FROM Login where username=:username1 and password=:pass1")
	public Login findUser(@Param("username1") String username,@Param("pass1") String password);
	

}
