package com.example.BankService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankService.entity.TransactionDetails;

@Repository
public interface TransactionDao extends JpaRepository<TransactionDetails, Integer> {

}
