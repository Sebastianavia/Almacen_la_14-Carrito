package model;

import java.util.ArrayList;

public class InformationOrder {
    private int Id;
    private int totalElements;
    private int Price;
    ArrayList<Producto> oredrProducts= new ArrayList<>();


    public InformationOrder() {
    }

    public InformationOrder(int id, int totalElements, int price, ArrayList<Producto> oredrProducts) {
        Id = id;
        this.totalElements = totalElements;
        Price = price;
        this.oredrProducts = oredrProducts;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public ArrayList<Producto> getOredrProducts() {
        return oredrProducts;
    }

    public void setOredrProducts(ArrayList<Producto> oredrProducts) {
        this.oredrProducts = oredrProducts;
    }
}
