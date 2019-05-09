package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.HumanPictureMapper;
import com.demo.model.HumanPicture;
import com.demo.service.HumanPictureService;

@Service
public class HumanPictureServiceImpl implements HumanPictureService{

	
	@Autowired
	private HumanPictureMapper humanPictureMapper;	
	
	public List<HumanPicture> query() {
		List<HumanPicture> results = (List<HumanPicture>) humanPictureMapper.select();
		return results;
	}

}
