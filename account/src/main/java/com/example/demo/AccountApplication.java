package com.example.demo;

import MyDbHelper.ParseXML;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AccountApplication {
    @GetMapping("/account")
    public String account(){
        return "欢迎进入SpringDemo MicroService, 你在这里可以：</br>" +
                "1. 创建账户</br>" +
                "2. 登录账户</br>" +
                "3. 添加TODO</br>" +
                "4. 查看自己的TODO</br>";
    }
	@GetMapping("/account/create")
	public String create(String name, String password) {
        int res = ParseXML.preLoad(name, password);
        if(res == -1){
            return "用户名和密码不能为空";
        }else if(res == 0){
            return "用户已经存在！";
        }
		return "用户创建成功！";
	}

	@GetMapping("/account/login")
	public String login(String name, String password) {
		return "login";
	}
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
}
