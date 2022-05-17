package com.bring.voucher.rest.dto;

import com.bring.voucher.model.UserVoucher;
import com.bring.voucher.model.VoucherCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class VoucherCodeDto {

    private String id;
    private String voucherCode;
    private String voucherId;

    public VoucherCode toModel(){
        VoucherCode voucher = new VoucherCode();
        BeanUtils.copyProperties(this, voucher);
        return voucher;
    }
}
