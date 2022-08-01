package com.zooplus.challenge.convertor.repository;

import com.zooplus.challenge.convertor.entity.Currency;
import com.zooplus.challenge.convertor.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class CurrencyRepositoryTest {

    @Autowired
    CurrencyRepository currencyRepository;

    @AfterEach
    void tearDown(){
        currencyRepository.deleteAll();
    }

    @Test
    void findByCurrencyCodeAndCryptoCode() {

        Currency expected = new Currency(1L, "Euro", "EUR", "Bitcoin", 23238.86, "BTC");

        currencyRepository.save(expected);

        Currency actual = currencyRepository.findByCurrencyCodeAndCryptoCode("EUR", "BTC");
        Assertions.assertEquals(expected, actual);
    }
}