package com.bring.voucher.entity;

import com.bring.voucher.model.UserVoucher;
import com.bring.voucher.model.Voucher;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document
@Data
@NoArgsConstructor
public class UserVoucherEntity {
    @Id
    private String id;
    private String voucherId;
    private String walletId;

    public UserVoucher toModel(){
        UserVoucher voucher = new UserVoucher();
        BeanUtils.copyProperties(this, voucher);
        return voucher;
    }
}
