package com.wz.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WalletTests {
    @Autowired
    private WalletMapper walletMapper;

    @Test
    public void findByUserId(){
        System.out.println(walletMapper.findByWalletId(1));
    }
}
