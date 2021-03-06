package com.demo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.demo.model.HumanPicture;
import com.demo.model.MapVideoDeviceAndWifiDevice;
import com.demo.model.Person;
import com.demo.model.Result;
import com.demo.service.HumanPictureService;
import com.demo.service.PersonService;
import com.demo.service.impl.MapVideoDeviceAndWifiDeviceServiceImpl;
import com.demo.service.impl.ResultServiceImpl;

@Controller
public class LoginController {
	
	Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private PersonService personService;
	@Autowired
	private ResultServiceImpl resultService;
	@Autowired
	private MapVideoDeviceAndWifiDeviceServiceImpl mapVideoDeviceAndWifiDeviceService;
	@Autowired
	private HumanPictureService humanPictureService;
	
	@RequestMapping(value = "/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/user", method = {RequestMethod.POST})
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") int password) {
		logger.info("username=" + username + "  password=" + password);
		Person person = personService.login(username);
		if (person == null) {
			logger.info("not found");
		}
		System.out.println("password = " + person.getPassword());
		if (password == Integer.parseInt(person.getPassword())) {
			List<Result> results = resultService.query();
			JSONArray jsonArray = new JSONArray();
			for (Result result : results) {
				jsonArray.add(result);
			}
			
			ModelAndView modelAndView = new ModelAndView("loginSuccess");
			modelAndView.addObject("boundInfos", jsonArray);
			
			return modelAndView;
		} else {
			logger.info("this user is not exist");
			return new ModelAndView("logFail");
		}
	}
	
	
	@RequestMapping(value = "/getBoundInfos", method = {RequestMethod.GET})
	@ResponseBody
	public JSONArray getBoundInfos(@RequestParam("username") String username, @RequestParam("password") int password) {
		JSONArray jsonArray = new JSONArray();
		logger.info("username=" + username + "  password=" + password);
		Person person = personService.login(username);
		if (person == null) {
			logger.info("not found");
		}
		System.out.println("password = " + person.getPassword());
		if (password == Integer.parseInt(person.getPassword())) {
			List<Result> results = resultService.query();
			for (Result result : results) {
				jsonArray.add(result);
			}
		} else {
			logger.info("this user is not exist");
		}
		return jsonArray;
	}

	@RequestMapping(value = "/getMapInfos", method = {RequestMethod.GET})
	@ResponseBody
	public JSONArray getMapInfos(@RequestParam("username") String username, @RequestParam("password") int password) {
		JSONArray jsonArray = new JSONArray();
		logger.info("username=" + username + "  password=" + password);
		Person person = personService.login(username);
		if (person == null) {
			logger.info("not found");
		}
		System.out.println("    password = " + person.getPassword());
		if (password == Integer.parseInt(person.getPassword())) {
			List<MapVideoDeviceAndWifiDevice> results = mapVideoDeviceAndWifiDeviceService.query();
			for (MapVideoDeviceAndWifiDevice result : results) {
				System.out.println(mapVideoDeviceAndWifiDeviceService.toString());
				jsonArray.add(result);
			}
		} else {
			logger.info("this user is not exist");
		}
		return jsonArray;
	}
	
	@RequestMapping(value = "/getLastTenPicture", method = {RequestMethod.GET})
	@ResponseBody
	public JSONArray getLastTenPicture(@RequestParam("username") String username, @RequestParam("password") int password) {
		JSONArray jsonArray = new JSONArray();
		logger.info("username=" + username + "  password=" + password);
		Person person = personService.login(username);
		if (person == null) {
			logger.info("not found");
		}
		System.out.println("    password = " + person.getPassword());
		if (password == Integer.parseInt(person.getPassword())) {
			List<HumanPicture> results = humanPictureService.query();
			for (HumanPicture result : results) {
				System.out.println(result.toString());
				jsonArray.add(result);
			}
		} else {
			logger.info("this user is not exist");
		}
		return jsonArray;
	}
	
}
