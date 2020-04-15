package com.example.BankService.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankService.dao.AccountDao;
import com.example.BankService.dao.BankDao;
import com.example.BankService.dao.TransactionDao;
import com.example.BankService.entity.AccountDetails;
import com.example.BankService.entity.TransactionDetails;
import com.example.BankService.entity.User;

@Service
public class BankServiceImpl {

	@Autowired
	private BankDao bankRepository;
	
	@Autowired
	private AccountDao accountRepository;
	
	@Autowired
	private TransactionDao transactionRepository;
	
	public User getAccountByPhoneNum(long phoneNum) {
		// TODO Auto-generated method stub
		return bankRepository.findByPhoneNum(phoneNum);
		
	}
	public String fundTransfer(User fromUser, User toUser,long amount) throws Exception
	{
		AccountDetails srcAccount = fromUser.getAcc();
		AccountDetails destAccount = toUser.getAcc();
		if(srcAccount.getCurrentBalance()>=amount)
		{
			long remainingBal = srcAccount.getCurrentBalance()-amount;
			srcAccount.setCurrentBalance(remainingBal);
			accountRepository.save(srcAccount);
			
			long newBal = destAccount.getCurrentBalance()+amount;
			destAccount.setCurrentBalance(newBal);
			accountRepository.save(destAccount);
			
			
			TransactionDetails tx1 = new TransactionDetails();
			tx1.setAccountNumber(srcAccount.getAccountNumber());
			tx1.setPhoneNum(fromUser.getPhoneNum());
			tx1.setAmount(amount);
			tx1.setTransactionType("Debit");
			tx1.setDate(new Date().toString());
			
			TransactionDetails tx2 = new TransactionDetails();
			tx2.setAccountNumber(destAccount.getAccountNumber());
			tx2.setPhoneNum(toUser.getPhoneNum());
			tx2.setAmount(amount);
			tx2.setTransactionType("Credit");
			tx2.setDate(new Date().toString());
			
			transactionRepository.save(tx1);
			transactionRepository.save(tx2);
		}
		else
		{
			throw new Exception("There is no sufficient funds to tranfer from given source account. Please try with a lesser amount.");
		}
		return "Funds transferred successfully";
		
	}

}
