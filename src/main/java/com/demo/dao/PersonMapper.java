package com.demo.dao;

import org.apache.ibatis.annotations.Param;

import com.demo.model.Person;

public interface PersonMapper {
	Person select(@Param("username")String username);
}
