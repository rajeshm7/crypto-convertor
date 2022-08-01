package com.zooplus.challenge.convertor.utility;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;

@Component
public class Utility {

    private final String LOCALHOST_IPV4 = "127.0.0.1";
    private final String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";
    private final String UNKNOWN = "unknown";

    public String getClientIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if(ipAddress == null || ipAddress.isBlank() || UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }

        if(ipAddress == null || ipAddress.isBlank() || UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }

        if(ipAddress == null || ipAddress.isBlank() || UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if(LOCALHOST_IPV4.equals(ipAddress) || LOCALHOST_IPV6.equals(ipAddress)) {
                try {
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    ipAddress = inetAddress.getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }

        if(!ipAddress.isBlank()
                && ipAddress.length() > 15
                && ipAddress.indexOf(",") > 0) {
            ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
        }

        return ipAddress;
    }

    public String getCountryCode(String ipAddress){
        if(ipAddress.startsWith("1")){
            return "EUR";
        }else if(ipAddress.startsWith("2")){
            return "GBP";
        }else if(ipAddress.startsWith("3")){
            return "USD";
        }else if(ipAddress.startsWith("4")){
            return "JPY";
        }else if(ipAddress.startsWith("5")){
            return "AUD";
        }
        return "EUR";
    }

    public String getCurrencySymbol(String countryCode){
        Locale locale = Locale.GERMANY;
        if(countryCode.equals("EUR")){
            locale = Locale.GERMANY;
        }else if(countryCode.equals("GBP")){
            locale = Locale.UK;
        }else if(countryCode.equals("USD")){
            locale = Locale.US;
        }else if(countryCode.equals("JPY")){
            locale = Locale.JAPAN;
        }else if(countryCode.equals("AUD")){
            locale = Locale.US;
        }
        java.util.Currency currency = java.util.Currency.getInstance(locale);
        return currency.getSymbol(locale);
    }

}
