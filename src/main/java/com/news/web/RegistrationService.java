package com.news.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

	@Autowired
	UserEntityRepository repository;


	public String registrationLogic(String newName, String newPass){

		if(!(newName.matches("^[a-zA-Z0-9]{4,}$")) || !(newPass.matches("^[a-zA-Z0-9]{4,}$"))){
			return "badInput";
		}else{
			UserEntity entity = new UserEntity(newName, newPass);
			try{
				repository.save(entity);
				return "registrationSuccess";
			}catch(RuntimeException e){
				return "duplicationName";
			}
		}
	}
}
