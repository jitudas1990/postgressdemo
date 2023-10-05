package com.example.hibernatepostgress.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name="student_address")
public class Adress {
    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private Integer AddressId;
    @Column(length = 50)
    private String street;
    private  String city;
    private  boolean isOpen;
    @Transient
    private  double x;
    @Column(name="added_date")
    @Temporal(TemporalType.DATE)
    private Date addedDate;
    private byte[] image;
    public Adress(){
        super();
    }
    public Adress(int addressId, String street, String city, boolean isOpen, double x, Date addedDate, byte[] image) {
        AddressId = addressId;
        this.street = street;
        this.city = city;
        this.isOpen = isOpen;
        this.x = x;
        this.addedDate = addedDate;
        this.image = image;
    }

    public void setAddressId(int addressId) {
        AddressId = addressId;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getAddressId() {
        return AddressId;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public double getX() {
        return x;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public byte[] getImage() {
        return image;
    }
}
