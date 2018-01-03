package com.prndapplication.task.Main.Data;

/**
 * Created by kiyoungLee on 2018-01-03.
 */

public class CarInfo {

    private String main_image_url;
    private String status;
    private String status_display;
    private String model_part_name;
    private String grade_part_name;
    private int year;
    private int mileage;
    private int price;
    private int discounted_price;
    private String absolute_url;

    public String getMain_image_url() {
        return main_image_url;
    }

    public void setMain_image_url(String main_image_url) {
        this.main_image_url = main_image_url;
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

    public String getModel_part_name() {
        return model_part_name;
    }

    public void setModel_part_name(String model_part_name) {
        this.model_part_name = model_part_name;
    }

    public String getGrade_part_name() {
        return grade_part_name;
    }

    public void setGrade_part_name(String grade_part_name) {
        this.grade_part_name = grade_part_name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
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

    public String getAbsolute_url() {
        return absolute_url;
    }

    public void setAbsolute_url(String absolute_url) {
        this.absolute_url = absolute_url;
    }
}
