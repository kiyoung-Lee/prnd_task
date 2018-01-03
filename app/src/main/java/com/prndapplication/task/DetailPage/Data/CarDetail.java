package com.prndapplication.task.DetailPage.Data;

import java.util.List;

/**
 * Created by kiyoungLee on 2018-01-03.
 */

public class CarDetail {

    private List<String> image_urls;
    private String full_name;
    private int price;
    private int discounted_price;
    private String status;
    private String status_display;
    private String car_number;
    private int mileage;
    private String initial_registration_date;
    private int year;
    private String fuel;

    public List<String> getImage_urls() {
        return image_urls;
    }

    public void setImage_urls(List<String> image_urls) {
        this.image_urls = image_urls;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscounted_price() {
        return discounted_price;
    }

    public void setDiscounted_price(int discounted_price) {
        this.discounted_price = discounted_price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus_display() {
        return status_display;
    }

    public void setStatus_display(String status_display) {
        this.status_display = status_display;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getInitial_registration_date() {
        return initial_registration_date;
    }

    public void setInitial_registration_date(String initial_registration_date) {
        this.initial_registration_date = initial_registration_date;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
}
