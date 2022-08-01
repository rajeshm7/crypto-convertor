package com.zooplus.challenge.convertor.repository;

import com.zooplus.challenge.convertor.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CurrencyRepository extends JpaRepository<Currency, String> {

    Currency findByCurrencyCodeAndCryptoCode(String currencyCode, String cryptoCode);
}
