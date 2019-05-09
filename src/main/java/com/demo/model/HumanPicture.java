package com.demo.model;

public class HumanPicture {

	int id;
	String picture_path;
	long time;
	String device_id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPicture_path() {
		return picture_path;
	}

	public void setPicture_path(String picture_path) {
		this.picture_path = picture_path;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	@Override
	public String toString() {
		return "HumanPicture [id=" + id + ", picture_path=" + picture_path + ", time=" + time + ", device_id="
				+ device_id + "]";
	}

}
