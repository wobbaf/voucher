package com.bring.voucher.rest.dto;

import com.bring.voucher.model.UserVoucher;
import com.bring.voucher.model.Voucher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserVoucherDto {
    @Id
    private String id;
    private String voucherId;
    private String walletId;

    @JsonIgnore
    public UserVoucher toModel(){
        UserVoucher voucher = new UserVoucher();
        BeanUtils.copyProperties(this, voucher);
        return voucher;
    }
}
