package com.bring.voucher.service;

import com.bring.voucher.entity.UserVoucherEntity;
import com.bring.voucher.entity.VoucherEntity;
import com.bring.voucher.model.UserVoucher;
import com.bring.voucher.model.Voucher;
import com.bring.voucher.repository.UserVoucherRepository;
import com.bring.voucher.repository.VoucherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoucherService {

    private final VoucherRepository voucherRepository;
    private final UserVoucherRepository userVoucherRepository;

    public Flux<Voucher> getAllVouchers(){
        return voucherRepository.findAll().map(VoucherEntity::toModel);
    }

    public Flux<Voucher> getAllActiveVouchers() {
        return voucherRepository.findByValidFromLessThanAndValidToGreaterThan(LocalDateTime.now(), LocalDateTime.now()).map(VoucherEntity::toModel);
    }

    public Mono<Voucher> addVoucher(Voucher voucher) {
        return voucherRepository.save(voucher.toEntity()).map(VoucherEntity::toModel);
    }

    public Mono<Void> removeAllVouchers() {
        return voucherRepository.deleteAll();
    }

    public Mono<UserVoucher> assignVoucher(UserVoucher userVoucher) {
        return userVoucherRepository.save(userVoucher.toEntity()).map(UserVoucherEntity::toModel);
    }

    public Flux<Voucher> getVouchersByWalletId(String walletId) {
        return voucherRepository.findAllById(userVoucherRepository.findByWalletIdAndIsActive(walletId).map(UserVoucherEntity::getVoucherId))
                .map(VoucherEntity::toModel);
    }

    public Flux<Voucher> getVoucherByIdAndWalletId(UserVoucher userVoucher) {
        return voucherRepository.findAllById(userVoucherRepository.findByIdAndVoucherIdAndIsActive(userVoucher.getId(), userVoucher.getWalletId()).map(UserVoucherEntity::getVoucherId))
                .map(VoucherEntity::toModel);
    }

    public Mono<Void> deleteVoucherFromWallet(UserVoucher userVoucher) {
        return userVoucherRepository.saveAll(userVoucherRepository.findById(userVoucher.getId()).doOnNext(item -> item.setActive(false))).then();
    }

    public Mono<Void> increaseViewsCount(String voucherId) {
        return voucherRepository.saveAll(voucherRepository.findById(voucherId)
                .doOnNext(voucherEntity -> voucherEntity.setViews(voucherEntity.getViews() + 1))).then();
    }

    public Mono<Void> increaseRedeemedCount(String voucherId) {
        return voucherRepository.saveAll(voucherRepository.findById(voucherId)
                .doOnNext(voucherEntity -> voucherEntity.setViews(voucherEntity.getUsersRedeemed() + 1))).then();
    }

    public Flux<Voucher> getAllInRange(LocalDateTime start, LocalDateTime end) {
        return voucherRepository.findByValidFromLessThanAndValidToGreaterThan(start, end).map(VoucherEntity::toModel);
    }

    public Mono<Void> removeAllVouchersFromWallet(String walletId) {
        return userVoucherRepository.deleteAllByWalletIdAndIsActive(walletId);
    }
}
