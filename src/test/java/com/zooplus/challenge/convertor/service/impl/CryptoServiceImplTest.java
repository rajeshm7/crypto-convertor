package com.zooplus.challenge.convertor.service.impl;

import com.zooplus.challenge.convertor.dto.Price;
import com.zooplus.challenge.convertor.dto.Search;
import com.zooplus.challenge.convertor.entity.Currency;
import com.zooplus.challenge.convertor.entity.History;
import com.zooplus.challenge.convertor.repository.CurrencyRepository;
import com.zooplus.challenge.convertor.repository.HistoryRepository;
import com.zooplus.challenge.convertor.utility.Utility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
class CryptoServiceImplTest {

    @Mock
    private CurrencyRepository currencyRepository;

    @Mock
    private HistoryRepository historyRepository;

    @InjectMocks
    private CryptoServiceImpl cryptoService;

    @Mock
    private Utility utility;

    @Test
    void getHistory() {
        String username = "admin";
        List<History> histories = Arrays.asList(new History(1L, new Timestamp(System.currentTimeMillis()), "admin", "admin", "Bitcoin", "2340032113", "EUR", 23238.86),
                        new History(2L, new Timestamp(System.currentTimeMillis()), "admin", "admin", "BTC", "12345", "USD", 23238.86));

        Mockito.when(historyRepository.findByUsername(username)).thenReturn(histories);
        List<History> actual = cryptoService.getHistory(username);
        Assertions.assertEquals(histories, actual);
    }

    @Test
    void saveSearch() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        History history = new History(10L, timestamp, "admin", "admin", "BTC", "12343", "EUR", 23238.86);
        Search search = new Search("admin", "admin", timestamp, "BTC", "12343", "EUR", 23238.86);
        History history2 = new History(null, timestamp, "admin", "admin", "BTC", "12343", "EUR", 23238.86);
        Mockito.when(historyRepository.save(history2)).thenReturn(history);
        History actual = cryptoService.saveSearch(search);
        Assertions.assertEquals(history, actual);
    }

    @Test
    void getPrice() {
        Search search = new Search("admin", "admin", new Timestamp(System.currentTimeMillis()), "BTC", "12343", "EUR", 23238.86);
        Mockito.when(utility.getCountryCode("12343")).thenReturn("EUR");
        Mockito.when(currencyRepository.findByCurrencyCodeAndCryptoCode("EUR", "BTC")).thenReturn(Currency.builder().cryptoValue(23238.86).build());
        Mockito.when(utility.getCurrencySymbol("EUR")).thenReturn("€");
        Price actual = cryptoService.getPrice(search);
        Price expected = Price.builder().unitPrice(23238.86).countryCode("EUR").symbol("€").build();
        Assertions.assertEquals(expected, actual);
    }
}