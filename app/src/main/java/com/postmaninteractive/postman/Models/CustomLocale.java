package com.postmaninteractive.postman.Models;

public class CustomLocale {

    private double[] range;
    private String country, region, eu, timezone, city;
    private float[] ll;
    private int metro, area;


    public CustomLocale(double[] range, String country, String region, String eu, String timezone, String city, float[] ll, int metro, int area) {
        this.range = range;
        this.country = country;
        this.region = region;
        this.eu = eu;
        this.timezone = timezone;
        this.city = city;
        this.ll = ll;
        this.metro = metro;
        this.area = area;
    }

    public double[] getRange() {
        return range;
    }

    public void setRange(double[] range) {
        this.range = range;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getEu() {
        return eu;
    }

    public void setEu(String eu) {
        this.eu = eu;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float[] getLl() {
        return ll;
    }

    public void setLl(float[] ll) {
        this.ll = ll;
    }

    public int getMetro() {
        return metro;
    }

    public void setMetro(int metro) {
        this.metro = metro;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
