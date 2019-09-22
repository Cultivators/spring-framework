package cn.pp.service;


public class LoginService {

	public String login(String name){
		System.out.println(name + " login success");
		return "success";
	}
}
