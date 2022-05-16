package com.bring.voucher.model;

import com.bring.voucher.entity.UserVoucherEntity;
import com.bring.voucher.entity.VoucherEntity;
import com.bring.voucher.rest.dto.UserVoucherDto;
import com.bring.voucher.rest.dto.VoucherDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserVoucher {
    @Id
    private String id;
    private String voucherId;
    private String walletId;

    public UserVoucherEntity toEntity(){
        UserVoucherEntity voucherEntity = new UserVoucherEntity();
        BeanUtils.copyProperties(this, voucherEntity);
        return voucherEntity;
    }

    public UserVoucherDto toDto(){
        UserVoucherDto voucherDto = new UserVoucherDto();
        BeanUtils.copyProperties(this, voucherDto);
        return voucherDto;
    }
}
