package com.wz.service;

import com.wz.entity.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface IWalletService {
    BigDecimal findBalance(Integer userId);

    void consume(Integer userId);

    void refund(Integer userId);

    List<Transaction> getTransactions(Integer userId);
}
