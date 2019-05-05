package com.demo.model;

public class Result {

	private int id;
	private String mac_name;
	private String human_picture_path;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMac_name() {
		return mac_name;
	}

	public void setMac_name(String mac_name) {
		this.mac_name = mac_name;
	}

	public String getHuman_picture_path() {
		return human_picture_path;
	}

	public void setHuman_picture_path(String human_picture_path) {
		this.human_picture_path = human_picture_path;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", mac_name=" + mac_name + ", human_picture_path=" + human_picture_path + "]";
	}

	
}
