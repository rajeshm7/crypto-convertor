package com.zooplus.challenge.convertor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Price {

    private double unitPrice;

    private String symbol;

    private String countryCode;

}
