package com.bring.voucher.entity;

import com.bring.voucher.model.Voucher;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document
@Data
@NoArgsConstructor
public class VoucherEntity {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;
    private List<String> store;
    private String product;
    private String brand;
    private String discountType;
    private BigDecimal discountValue;
    private Long views;
    private Long usersRedeemed;

    public Voucher toModel(){
        Voucher voucher = new Voucher();
        BeanUtils.copyProperties(this, voucher);
        return voucher;
    }
}
