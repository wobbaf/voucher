package com.bring.voucher.model;

import com.bring.voucher.entity.VoucherCodeEntity;
import com.bring.voucher.rest.dto.VoucherCodeDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class VoucherCode {

    private String id;
    private String voucherCode;
    private String voucherId;

    public VoucherCodeDto toDto(){
        VoucherCodeDto voucher = new VoucherCodeDto();
        BeanUtils.copyProperties(this, voucher);
        return voucher;
    }

    public VoucherCodeEntity toEntity(){
        VoucherCodeEntity voucher = new VoucherCodeEntity();
        BeanUtils.copyProperties(this, voucher);
        return voucher;
    }
}
