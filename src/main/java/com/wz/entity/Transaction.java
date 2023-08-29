package com.wz.entity;

import com.wz.util.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private int id;
    private int walletId;
    private BigDecimal amount;
    private TransactionType type;
    private Timestamp createdAt;
}
