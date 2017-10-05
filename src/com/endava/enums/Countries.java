package com.endava.enums;

public enum Countries {
    MOLDOVA("MOLDOVA"),
    GRECIA("GRECIA"),
    ROMANIA("ROMANIA"),
    POLAND("POLAND"),
    RUSSIA("RUSSIA"),
    ITALIA("ITALIA"),
    USA("USA"),
    GERMANY("GERMANY"),
    LATVIA("LATVIA"),
    LITVA("LITVA"),
    BOLGARIA("BOLGARIA");

    private String country;

    Countries(String country) {
        this.country = country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
