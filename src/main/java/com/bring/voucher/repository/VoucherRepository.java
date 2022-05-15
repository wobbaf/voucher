package com.bring.voucher.repository;

import com.bring.voucher.entity.VoucherEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Repository
public interface VoucherRepository extends ReactiveMongoRepository<VoucherEntity, String> {

    Flux<VoucherEntity> findByValidFromGreaterThanAndValidToLessThan(LocalDateTime validFrom, LocalDateTime validTo);

}
