package com.zooplus.challenge.convertor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Search {

    private String name;

    private String username;

    private Timestamp date;

    private String cryptocurrency;

    private String ipaddress;

    private String currency;

    private double price;

}
