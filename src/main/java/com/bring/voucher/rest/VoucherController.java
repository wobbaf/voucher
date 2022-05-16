package com.bring.voucher.rest;

import com.bring.voucher.model.UserVoucher;
import com.bring.voucher.model.Voucher;
import com.bring.voucher.rest.dto.UserVoucherDto;
import com.bring.voucher.rest.dto.VoucherDto;
import com.bring.voucher.service.VoucherService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/v1/voucher")
@RequiredArgsConstructor
public class VoucherController {
    private final VoucherService voucherService;

    @GetMapping("/all")
    public Flux<VoucherDto> getAllVouchers(){
        return voucherService.getAllVouchers().map(Voucher::toDto);
    }

    @GetMapping("/all-active")
    public Flux<VoucherDto> getAllActiveVouchers(){
        return voucherService.getAllActiveVouchers().map(Voucher::toDto);
    }

    @GetMapping("/all-wallet")
    public Flux<VoucherDto> getAllWalletVouchers(@RequestParam String walletId){
        return voucherService.getVouchersByWalletId(walletId).map(Voucher::toDto);
    }

    @PutMapping("/add")
    public Mono<VoucherDto> addVoucher(@RequestBody VoucherDto voucherDto){
        return voucherService.addVoucher(voucherDto.toModel()).map(Voucher::toDto);
    }

    @PutMapping("/assign-to-wallet")
    public Mono<UserVoucherDto> assignToWallet(@RequestBody UserVoucherDto voucherDto){
        if(StringUtils.hasText(voucherDto.getId())){
            voucherDto.setId(UUID.randomUUID().toString());
        }
        return voucherService.assignVoucher(voucherDto.toModel()).map(UserVoucher::toDto);
    }

    @PostMapping("/viewed")
    public Mono<Void> increaseViewsCount(@RequestParam String voucherId){
        return voucherService.increaseViewsCount(voucherId);
    }

    @PostMapping("/used")
    public Mono<Void> increaseRedeemedCount(@RequestParam String voucherId){
        return voucherService.increaseRedeemedCount(voucherId);
    }

    @DeleteMapping("/delete-all")
    public Mono<Void> removeAllVouchers(){
        return voucherService.removeAllVouchers();
    }
}
