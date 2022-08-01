package com.zooplus.challenge.convertor.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "crypto_name")
    private String cryptoName;

    @Column(name = "crypto_value")
    private double cryptoValue ;

    @Column(name = "crypto_code")
    private String cryptoCode ;

}
