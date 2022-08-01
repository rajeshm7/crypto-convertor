package com.zooplus.challenge.convertor.service.impl;

import com.zooplus.challenge.convertor.dto.Price;
import com.zooplus.challenge.convertor.dto.Search;
import com.zooplus.challenge.convertor.entity.Currency;
import com.zooplus.challenge.convertor.entity.History;
import com.zooplus.challenge.convertor.repository.CurrencyRepository;
import com.zooplus.challenge.convertor.repository.HistoryRepository;
import com.zooplus.challenge.convertor.service.CryptoService;
import com.zooplus.challenge.convertor.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptoServiceImpl implements CryptoService {

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    Utility utility;

    public List<History> getHistory(String username){
        List<History> histories = historyRepository.findByUsername(username);
        return histories;
    }

    @Override
    public History saveSearch(Search search) {
        History history = History.builder().name(search.getName()).username(search.getUsername())
                      .cryptocurrency(search.getCryptocurrency()).date(search.getDate()).ipaddress(search.getIpaddress()).price(search.getPrice()).currency(search.getCurrency()).build();
        return historyRepository.save(history);
    }

    @Override
    public Price getPrice(Search search) {
        String countryCode = utility.getCountryCode(search.getIpaddress());
        Currency currency = currencyRepository.findByCurrencyCodeAndCryptoCode(countryCode, search.getCryptocurrency());
        String symbol = utility.getCurrencySymbol(countryCode);
        Price price = new Price(currency.getCryptoValue(), symbol, countryCode);
        System.out.println("price: "+price);
        return price;
    }

}
