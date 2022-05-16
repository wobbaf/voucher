package com.bring.voucher.repository;

import com.bring.voucher.entity.UserVoucherEntity;
import com.bring.voucher.entity.VoucherEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Repository
public interface UserVoucherRepository extends ReactiveMongoRepository<UserVoucherEntity, String> {

    Flux<UserVoucherEntity> findByWalletId(String walletId);

}
