package com.ss.edu.dto;

public class PatientDto {
	
	private Long id;
	private String name;
	private String login;
	private String password;
	private Integer age;
	
	public PatientDto(Long id, String name, String login, String password, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.age = age;
	}	

	public PatientDto(String name, String login, String password, Integer age) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
		this.age = age;
	}

	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public Integer getAge() {
		return age;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAge(Integer age) {
		this.age = age;
	}	
}
