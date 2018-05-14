package com.ss.edu.entity;

public class PatientEntity extends AEntity{
	
	public static final String PATIENT_ENTITY_LOGIN = "login";
	
	private Long id;
	private String name;
	private String login;
	private String password;
	private Integer age;	
	
	public PatientEntity(String name, String login, String password, Integer age) {
		this.name = name;
		this.login = login;
		this.password = password;
		this.age = age;
	}
	public PatientEntity(Long id, String name, String login, String password, Integer age) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.age = age;
	}
	public PatientEntity() {
		// TODO Auto-generated constructor stub
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
	@Override
	public String toString() {
		return "PatientEntity [id=" + id +  ", name=" + name + ", login=" + login + ", password=" + password + ", age="
				+ age + "]";
	}	
}
