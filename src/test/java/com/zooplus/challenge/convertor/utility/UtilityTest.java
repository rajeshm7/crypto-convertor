package com.zooplus.challenge.convertor.utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;


@SpringBootTest
class UtilityTest {

    @Autowired
    Utility utility;

    @Test
    void getClientIp() {
        String actual = utility.getClientIp(new MockHttpServletRequest());
        String expected ="127.0.0.1";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getCountryCode() {
        String ipAddress = "12345";
        String actual = utility.getCountryCode(ipAddress);
        String expected ="EUR";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getCurrencySymbol() {
        String countryCode = "EUR";
        String actual = utility.getCurrencySymbol(countryCode);
        String expected ="€";
        Assertions.assertEquals(expected, actual);
    }
}