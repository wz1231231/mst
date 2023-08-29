package com.wz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {
    private Integer id;
    private Integer userId;
    private BigDecimal balance;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
