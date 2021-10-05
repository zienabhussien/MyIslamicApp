package com.example.myislamicapplication.data.pojo.prayertimes;

public class City {
    private String code, name;
    private int lat, lng;

    public City() {
    }

    public City(String code, String name, int lat, int lng) {
        this.code = code;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getLat() {
        return lat;
    }

    public int getLng() {
        return lng;
    }

    @Override
    public String toString() {
        return "City{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
