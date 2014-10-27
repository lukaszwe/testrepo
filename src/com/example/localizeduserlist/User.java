package com.example.localizeduserlist;

public class User {
	private int id;
	private String name;
	private String address;
	private String phone;

	public User(){}
	
	public User(int id, String name, String address, String phone){
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		
	}
	
	public User(String name, String address, String phone){
		this.name = name;
		this.address = address;
		this.phone = phone;
		
	}
	
	public User(int id, String address, String phone){
		this.id = id;
		this.address = address;
		this.phone = phone;
	}
	
	public User(String address, String phone){
		this.address = address;
		this.phone = phone;		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getPhone(){
		return this.phone;
	}
	
}



