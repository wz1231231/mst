package com.wz.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WalletTest {
    @Autowired
    private IWalletService walletService;
    @Test
    public void findBalance(){
        System.out.println(walletService.findBalance(1));
    }
}
