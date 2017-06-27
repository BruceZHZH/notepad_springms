package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import MyDbHelper.ParseXML;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.AccountEntity;
import com.example.repository.AccountRepository;

@SpringBootApplication
@RestController
public class AccountApplication {
	
	@Autowired
	private AccountRepository accountRepository;
	
    @GetMapping("/account")
    public String account(){
        return "欢迎进入SpringDemo MicroService, 你在这里可以：</br>" +
                "1. 创建账户</br>" +
                "2. 登录账户</br>" +
                "3. 添加TODO</br>" +
                "4. 查看自己的TODO</br>";
    }
	@GetMapping("/account/create")
	public String create(@RequestParam("name")String name, @RequestParam("password")String password) {
        //int res = ParseXML.preLoad(name, password);
       /* if(res == -1){
            return "用户名和密码不能为空";
        }else if(res == 0){
            return "用户已经存在！";
        }*/
		AccountEntity account = new AccountEntity();
		account.setName(name);
		account.setPassword(password);
		accountRepository.save(account);
		return "用户创建成功！";
	}

	@GetMapping("/account/login")
	public String login(@RequestParam("name")String name, @RequestParam("password")String password) {
		List<AccountEntity> accountEntitys = accountRepository.findByName(name);
		if(accountEntitys==null)return "不存在该账号，登录失败";
		AccountEntity accountEntity = accountEntitys.get(0);
		if(!accountEntity.getPassword().equals(password))return "密码错误";
		return "登录成功";
	}
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
}
