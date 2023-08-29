package com.wz.service.impl;

import com.wz.entity.Transaction;
import com.wz.entity.Wallet;
import com.wz.mapper.TransactionMapper;
import com.wz.mapper.WalletMapper;
import com.wz.service.IWalletService;
import com.wz.util.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class WalletServiceImpl implements IWalletService {

    @Autowired
    private WalletMapper walletMapper;

    @Autowired
    private TransactionMapper transactionMapper;
    @Override
    public BigDecimal findBalance(Integer userId) {

        Wallet wallet = walletMapper.findByWalletId(userId);
        if (wallet == null){
            //throw new WalletNotFoundException("......")用户不存在
        }

        return wallet.getBalance();
    }

    @Transactional
    @Override
    public void consume(Integer userId) {
        //查询用户是否存在,不存在抛异常
        Wallet wallet = walletMapper.findByWalletId(userId);
        if (wallet == null){
            //throw new WalletNotFoundException("......")用户不存在
        }
        //检测数据是否安全,用户验证什么,手机号码，图片，验证码等等
        /**
         *  .............
         */
        int rows = walletMapper.consume(wallet.getId());
        if (rows != 1){
            //throw new 用户修改异常
        }

        BigDecimal balance = wallet.getBalance();
        if (balance.compareTo(new BigDecimal(100)) < 0) {
            //throw new InsufficientBalanceException();   钱不够
        }
        //记录金额变动
        Transaction transaction = new Transaction();
        transaction.setWalletId(wallet.getId());//记录钱包id
        transaction.setAmount(new BigDecimal(100));//记录金额
        transaction.setType(TransactionType.PURCHASE);//记录类型 购买
        transaction.setCreatedAt(new Timestamp(System.currentTimeMillis()));//记录当前时间戳
        transactionMapper.addTransaction(transaction);



    }

    @Transactional
    @Override
    public void refund(Integer userId) {
        //查询用户是否存在,不存在抛异常
        Wallet wallet = walletMapper.findByWalletId(userId);
        if (wallet == null){
            //throw new WalletNotFoundException("......")用户不存在
        }

        //检测数据是否安全,用户验证什么等等
        /**
         * ..............
         */

        int rows = walletMapper.refund(wallet.getId());
        if (rows != 1){
            //throw new 用户修改异常
        }

        //记录金额变动
        Transaction transaction = new Transaction();
        transaction.setWalletId(wallet.getId());//记录钱包id
        transaction.setAmount(new BigDecimal(20));//记录金额
        transaction.setType(TransactionType.REFUND);//记录类型 退款
        transaction.setCreatedAt(new Timestamp(System.currentTimeMillis()));//记录当前时间戳
        transactionMapper.addTransaction(transaction);

    }

    @Override
    public List<Transaction> getTransactions(Integer userId) {
        //查询用户是否存在,不存在抛异常
        Wallet wallet = walletMapper.findByWalletId(userId);
        if (wallet == null){
            //throw new WalletNotFoundException("......")用户不存在
        }
        List<Transaction> transactions = transactionMapper.getTransactions(wallet.getId());
        return transactions;
    }

}
