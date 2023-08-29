package com.wz.mapper;

import com.wz.entity.Transaction;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TransactionMapper {

    /**
     * 插入记录数据
     * @return 记录数
     */
    Integer addTransaction(Transaction transaction);

    /**
     * 根据钱包id查询记录
     * @param walletId 钱包id
     * @return 记录
     */
    List<Transaction> getTransactions(Integer walletId);

}
