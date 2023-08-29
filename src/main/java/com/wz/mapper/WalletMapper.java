package com.wz.mapper;

import com.wz.entity.Wallet;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
@Mapper
public interface WalletMapper {
    /**
     * 根据用户id查询余额
     * @return wallet
     */
    Wallet findByWalletId(Integer Uid);

    /**
     *用户消费100元
     * @param userId 用户id
     * @return  修改数量
     */
    int consume(Integer userId);

    /**
     *用户退款20元
     * @param userId 用户id
     * @return 修改数量
     */
    int refund(Integer userId);
}
