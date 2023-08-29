package com.wz.mapper;

import com.wz.entity.Transaction;
import com.wz.util.TransactionType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionTests {
    @Autowired
    private TransactionMapper transactionMapper;
    @Test
    public void addTransaction(){
        Transaction transaction = new Transaction();
        transaction.setWalletId(2);
        transaction.setAmount(new BigDecimal(1231241));
        transaction.setType(TransactionType.PURCHASE);
        transaction.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        transactionMapper.addTransaction(transaction);
    }

    @Test
    public void getTransactions(){
        System.out.println(transactionMapper.getTransactions(1));
    }
}
