package com.zooplus.challenge.convertor.controller;


import com.zooplus.challenge.convertor.dto.Price;
import com.zooplus.challenge.convertor.dto.Search;
import com.zooplus.challenge.convertor.dto.Cryptocurrency;
import com.zooplus.challenge.convertor.entity.History;
import com.zooplus.challenge.convertor.service.impl.CryptoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.*;

@Controller
public class CryptoController {

    @Autowired
    private CryptoServiceImpl cryptoService;


    @GetMapping("/history")
    public String getHistory(Model model, @RequestParam String username){
        List<History> histories = cryptoService.getHistory(username);
        model.addAttribute("histories", histories);
        model.addAttribute("cryptocurrencies", getCryptocurrencies());
        model.addAttribute("username", username);
        return "history";
    }


    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }

    @PostMapping("/index")
    public String home(Model model, Search search){
        model.addAttribute("cryptocurrencies", getCryptocurrencies());
        Price price = null;

        if(search != null && search.getCryptocurrency() != null ) {
            price = cryptoService.getPrice(search);
            search.setPrice(price.getUnitPrice());
            search.setCurrency(price.getCountryCode());
            search.setDate(new Timestamp(System.currentTimeMillis()));
            cryptoService.saveSearch(search);
        }

        if(price != null) {
            model.addAttribute("price", price);
        }
        return "index";
    }


    @ModelAttribute("cryptocurrencies")
    private List<Cryptocurrency> getCryptocurrencies(){
        List<Cryptocurrency> cryptocurrencies = new ArrayList<>();
        cryptocurrencies.add(new Cryptocurrency("Bitcoin", "BTC"));
        cryptocurrencies.add(new Cryptocurrency("Ethereum", "ETH"));
        cryptocurrencies.add(new Cryptocurrency("Tether", "USDT"));
        cryptocurrencies.add(new Cryptocurrency("USD", "USDC"));
        cryptocurrencies.add(new Cryptocurrency("BNB", "BNB"));
        cryptocurrencies.add(new Cryptocurrency("Binance", "BUSD"));
        cryptocurrencies.add(new Cryptocurrency("XRP", "XRP"));
        cryptocurrencies.add(new Cryptocurrency("Cardano", "ADA"));
        cryptocurrencies.add(new Cryptocurrency("Solana", "SOL"));
        cryptocurrencies.add(new Cryptocurrency("Dogecoin", "DOGE"));
        return cryptocurrencies;
    }
}
