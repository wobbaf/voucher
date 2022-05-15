package com.bring.voucher.rest;

import com.bring.voucher.model.Voucher;
import com.bring.voucher.rest.dto.VoucherDto;
import com.bring.voucher.service.VoucherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/v1/voucher")
@RequiredArgsConstructor
public class VoucherController {
    private final VoucherService voucherService;

    @RequestMapping("/all")
    public Flux<VoucherDto> getAllVouchers(){
        return voucherService.getAllVouchers().map(Voucher::toDto);
    }

    @RequestMapping("/all")
    public Flux<VoucherDto> getAllActiveVouchers(){
        return voucherService.getAllActiveVouchers().map(Voucher::toDto);
    }
}
