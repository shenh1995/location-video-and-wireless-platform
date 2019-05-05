package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ResultMapper;
import com.demo.model.Result;
import com.demo.service.ResultService;

@Service
public class ResultServiceImpl implements ResultService{
	
	@Autowired
	private ResultMapper resultMapper;

	public List<Result> query() {
		System.out.println(resultMapper.select());
		List<Result> results = (List<Result>) resultMapper.select();
		return results;
	}
}
	