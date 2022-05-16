package model;

import java.util.ArrayList;

public class HisUser {

    private int userID;
    ArrayList<Order> orders = new ArrayList<>();


    public HisUser() {
    }

    public HisUser(int userID, ArrayList<Order> orders) {
        this.userID = userID;
        this.orders = orders;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
