package org.example.Entities;

public class Sucker {

    private int id;
    private double money;
    private String name;
    private String address;
    private String banned;

    public Sucker(){

    }

    public Sucker(int id, String name, double money, String address) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.address = address;
        banned = "N";
    }

    public Sucker(String name, double money, String address) {
        this.name = name;
        this.money = money;
        this.address = address;
        banned = "N";
    }

    public Sucker(String name, double money, String address, String ban) {
        this.name = name;
        this.money = money;
        this.address = address;
        banned = ban;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBanned() {
        return banned;
    }

    public void setBanned(String banned) {
        this.banned = banned;
    }

    @Override
    public String toString() {
        return "Sucker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", address='" + address + '\'' +
                ", banned='" + banned + '\'' +
                '}';
    }
}

