package com.ayoub.deliveryapp.model;

import java.util.List;

public class Discovery {

    private Long Id;
    private String name;

    private String latitude;

    private String longitude;
    private List<Product> products;
    private String imageUrl;


    public Discovery() {
    }

    public Discovery(Long id, String name, List<Product> products) {
        this.Id = id;
        this.name = name;
        this.products = products;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
