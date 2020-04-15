package com.example.BankService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankService.entity.AccountDetails;

@Repository
public interface AccountDao extends JpaRepository<AccountDetails, Integer> {

}
