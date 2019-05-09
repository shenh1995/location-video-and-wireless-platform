package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.MapVideoDeviceAndWifiDeviceMapper;
import com.demo.model.MapVideoDeviceAndWifiDevice;
import com.demo.service.MapVideoDeviceAndWifiDeviceService;

@Service
public class MapVideoDeviceAndWifiDeviceServiceImpl implements MapVideoDeviceAndWifiDeviceService{

	@Autowired
	private MapVideoDeviceAndWifiDeviceMapper mapVideoDeviceAndWifiDeviceMapper;	
	
	public List<MapVideoDeviceAndWifiDevice> query() {
		List<MapVideoDeviceAndWifiDevice> results = (List<MapVideoDeviceAndWifiDevice>) mapVideoDeviceAndWifiDeviceMapper.select();
		return results;
	}

}
