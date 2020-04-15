package com.example.BankService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankService.entity.AccountDetails;
import com.example.BankService.entity.User;
import com.example.BankService.service.BankServiceImpl;

@RestController
@RequestMapping(value = "/banks")
public class BankServiceController {
	
	@Autowired
	private BankServiceImpl bankService;
	

	@GetMapping(value = "/{phNum}")
	public ResponseEntity<AccountDetails> getUserByPhone(@PathVariable long phoneNum) throws Exception
	{
		User user =  bankService.getAccountByPhoneNum(phoneNum);
		System.out.println("user"+user);
		if(user==null)
		{
			throw new Exception("User Not Found for the given Phone number");
		}
		return new ResponseEntity<AccountDetails>(user.getAcc(),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping(value = "/{fromPhoneNum}/{toPhoneNum}/{amount}")
	public String fundTransfer(@PathVariable long fromPhoneNum,@PathVariable long toPhoneNum,@PathVariable long amount)throws Exception
	{
		User sourceUser = bankService.getAccountByPhoneNum(fromPhoneNum);
		User destinationUser = bankService.getAccountByPhoneNum(toPhoneNum);
		return bankService.fundTransfer(sourceUser,destinationUser,amount);
		
		
	}

}
