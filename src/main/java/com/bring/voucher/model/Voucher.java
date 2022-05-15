package com.bring.voucher.model;

import com.bring.voucher.entity.VoucherEntity;
import com.bring.voucher.rest.dto.VoucherDto;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Voucher {
    private String id;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;
    private String product;
    private String brand;
    private String discountType;
    private BigDecimal discountValue;
    private Long views;
    private Long usersRedeemed;
    private String voucherCode;

    public VoucherEntity toEntity(){
        VoucherEntity voucherEntity = new VoucherEntity();
        BeanUtils.copyProperties(this, voucherEntity);
        return voucherEntity;
    }

    public VoucherDto toDto(){
        VoucherDto voucherDto = new VoucherDto();
        BeanUtils.copyProperties(this, voucherDto);
        return voucherDto;
    }
}
