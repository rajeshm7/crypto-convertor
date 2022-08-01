package com.zooplus.challenge.convertor.repository;

import com.zooplus.challenge.convertor.entity.History;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;


@DataJpaTest
class HistoryRepositoryTest {

    @Autowired
    HistoryRepository historyRepository;

    @AfterEach
    void tearDown(){
        historyRepository.deleteAll();
    }

    @Test
    void findByUsername() {
        List<History> histories = Arrays.asList(new History(1L, new Timestamp(System.currentTimeMillis()), "admin", "admin", "Bitcoin", "2340032113", "EUR", 23238.86),
                new History(2L, new Timestamp(System.currentTimeMillis()), "admin", "admin", "BTC", "12345", "USD", 23238.86));

        historyRepository.saveAll(histories);

        List<History> actual = historyRepository.findByUsername("admin");
        Assertions.assertEquals(histories, actual);
    }
}