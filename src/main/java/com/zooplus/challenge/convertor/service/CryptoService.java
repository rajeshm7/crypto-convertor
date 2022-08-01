package com.zooplus.challenge.convertor.service;

import com.zooplus.challenge.convertor.dto.Price;
import com.zooplus.challenge.convertor.dto.Search;
import com.zooplus.challenge.convertor.entity.History;

import java.util.List;

public interface CryptoService {

    List<History> getHistory(String username);

    History saveSearch(Search search);

    Price getPrice(Search search);

}
