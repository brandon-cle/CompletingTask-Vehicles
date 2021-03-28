/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vehicle_code.backend.pojo;

/**
 *
 * @author Usuario
 */
public class MainObj_Vehicle {
    private int stockNumber;//20
    private int year;//4
    private String make;//30
    private String model;//30
    private String style;//30
    private String vin;//20
    private String exteriorColor;//30
    private String interiorColor;//30
    private String miles;//7
    private float price;//7
    private String engine;//50
    private String image;//100
    private String status;//20
    private Transmission transmission;//20
    

    //LOS VALORES EXISTENTES QUE TOMARÁ EL VEHICULO-OBJETO(RADIO BUTTON)
    public enum Transmission{
            AUTOMATIC, MANUAL
    }
    //HAGO ESTE CONSTRUCTOR SOLAMENTE PARA COMBO BOX Y RADIO BUTTON
    public MainObj_Vehicle(int year, String make, String model, String exteriorColor, String interiorColor, Transmission transmission, String status) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.status = status;
        this.transmission = transmission;
    }

    
    
    //INCLUYENDO TODO PARA LA CREACIÓN DE UN VEHICULO-OBJETO
    public MainObj_Vehicle(int stockNumber, int year, String make, String model, String style, String vin, String exteriorColor, String interiorColor, String miles, float price, String engine, String image, String status) {
        this.stockNumber = stockNumber;
        this.year = year;
        this.make = make;
        this.model = model;
        this.style = style;
        this.vin = vin;
        this.exteriorColor = exteriorColor;
        this.interiorColor = interiorColor;
        this.miles = miles;
        this.price = price;
        this.engine = engine;
        this.image = image;
        this.status = status;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getExteriorColor() {
        return exteriorColor;
    }

    public void setExteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
    }

    public String getInteriorColor() {
        return interiorColor;
    }

    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }

    public String getMiles() {
        return miles;
    }

    public void setMiles(String miles) {
        this.miles = miles;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
