package com.zooplus.challenge.convertor.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "cryptocurrency")
    private String cryptocurrency;

    @Column(name = "ipaddress")
    private String ipaddress;

    @Column(name = "currency")
    private String currency;

    @Column(name = "price")
    private Double price;

    public History(Timestamp date, String name, String username, String cryptocurrency, String ipaddress, String currency, Double price) {
        this.date = date;
        this.name = name;
        this.username = username;
        this.cryptocurrency = cryptocurrency;
        this.ipaddress = ipaddress;
        this.currency = currency;
        this.price = price;
    }
}
