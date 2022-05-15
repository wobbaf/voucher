package com.bring.voucher.service;

import com.bring.voucher.entity.VoucherEntity;
import com.bring.voucher.model.Voucher;
import com.bring.voucher.repository.VoucherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoucherService {

    private final VoucherRepository voucherRepository;

    public Flux<Voucher> getAllVouchers(){
        return voucherRepository.findAll().map(VoucherEntity::toModel);
    }

    public Flux<Voucher> getAllActiveVouchers() {
        return voucherRepository.findByValidFromGreaterThanAndValidToLesserThan(LocalDateTime.now(), LocalDateTime.now()).map(VoucherEntity::toModel);
    }
}
