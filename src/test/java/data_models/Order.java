package data_models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Integer orderNumber;
    private Date creationDate;
    private Address deliveryAddress;
    private String promocode;
    private String certificate;
    private String paymentType;
    private String Total;
    List<Product> products;

    public Order(){
        deliveryAddress=new Address();
        products=new ArrayList<Product>();
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPromocode() {
        return promocode;
    }

    public void setPromocode(String promocode) {
        this.promocode = promocode;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public List<Product> getOrderLine() {
        return products;
    }

    public void setOrderLine(List<Product> orderLine) {
        this.products = orderLine;
    }

    public void addOrderLine(Product product) {
        this.products.add(product);
    }
}
