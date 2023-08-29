package com.wz.controller;

import com.wz.controller.ex.BaseController;
import com.wz.entity.Transaction;
import com.wz.service.IWalletService;
import com.wz.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController extends BaseController {//BaseController负责处理异常
    private final Object lock = new Object();
    @Autowired
    private IWalletService walletService;

    //查询用户钱包余额
    @GetMapping("/{userId}/balance")
    public JsonResult<BigDecimal> getBalance(@PathVariable("userId") Integer userId) {
        synchronized (lock) {
            return new JsonResult<>(200, walletService.findBalance(userId));
        }
    }

    //用户消费的接口
    @PostMapping("/{userId}/consume")
    public JsonResult<Void> consume(@PathVariable("userId") Integer userId) {
        synchronized (lock){
            walletService.consume(userId);
            //高并发的情况下，使用rabbitmq，具体用什么模式，我也不知道
//            RequestMessage requestMessage = new RequestMessage(userId, amount);
//            rabbitTemplate.convertAndSend("consumeQueue", requestMessage);
            return new JsonResult<>(200);
        }
    }

    @PostMapping("/{userId}/refund")
    public JsonResult<Void> refund(@PathVariable("userId") Integer userId) {
        synchronized (lock){
            //高并发,使用rabbitmq
            walletService.refund(userId);
            return new JsonResult<>(200);
        }

    }

    //查询用户钱包金额变动明细的接口
    @GetMapping("/{userId}/transactions")
    public JsonResult<List<Transaction>> getTransactions(@PathVariable("userId") int userId) {
        synchronized (lock) {
            return new JsonResult<>(200, walletService.getTransactions(userId));
        }
    }


}
