package data_models;

public class Address {
    private String city;
    private String street;
    private String house;
    private String apartment;
    private String floor;
    private String deliveryLifting;

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getDeliveryLifting() {
        return deliveryLifting;
    }

    public void setDeliveryLifting(String deliveryLifting) {
        this.deliveryLifting = deliveryLifting;
    }


}
