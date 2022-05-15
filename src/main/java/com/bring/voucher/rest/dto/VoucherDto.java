package com.bring.voucher.rest.dto;

import com.bring.voucher.entity.VoucherEntity;
import com.bring.voucher.model.Voucher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class VoucherDto {
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

    @JsonIgnore
    public Voucher toModel(){
        Voucher voucher = new Voucher();
        BeanUtils.copyProperties(this, voucher);
        return voucher;
    }
}
