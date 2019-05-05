package com.postmaninteractive.postman.Models;

public class EventEntry {

    private String title, type, message, instructions, reach, day, month, year, hour, minute, city, country, continent;
    private String bound;
    private String[] photos;
    private String contactName, contactPhone, contactEmail;
    private String address;
    private String by;
    private String byUsername;
    private String _id;

    private String meta, data;


    public EventEntry(String meta, String data, String _id) {
        this.meta = meta;
        this.data = data;
        this._id = _id;
    }

    public EventEntry(String title, String type, String message, String instructions, String reach, String day, String month, String year, String hour, String minute, String city, String country, String continent, String bound, String[] photos, String contactName, String contactPhone, String contactEmail, String address, String by, String byUsername, String _id, String meta, String data) {
        this.title = title;
        this.type = type;
        this.message = message;
        this.instructions = instructions;
        this.reach = reach;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.city = city;
        this.country = country;
        this.continent = continent;
        this.bound = bound;
        this.photos = photos;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.address = address;
        this.by = by;
        this.byUsername = byUsername;
        this._id = _id;
        this.meta = meta;
        this.data = data;
    }


    public EventEntry(String title, String type, String message, String instructions, String reach, String day, String month, String year, String hour, String minute, String city, String country, String continent, String bound, String[] photos, String contactName, String contactPhone, String contactEmail, String address, String by, String byUsername) {
        this.title = title;
        this.type = type;
        this.message = message;
        this.instructions = instructions;
        this.reach = reach;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.city = city;
        this.country = country;
        this.continent = continent;
        this.bound = bound;
        this.photos = photos;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.address = address;
        this.by = by;
        this.byUsername = byUsername;

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getReach() {
        return reach;
    }

    public void setReach(String reach) {
        this.reach = reach;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getBound() {
        return bound;
    }

    public void setBound(String bound) {
        this.bound = bound;
    }

    public String[] getPhotos() {
        return photos;
    }

    public void setPhotos(String[] photos) {
        this.photos = photos;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getByUsername() {
        return byUsername;
    }

    public void setByUsername(String byUsername) {
        this.byUsername = byUsername;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
