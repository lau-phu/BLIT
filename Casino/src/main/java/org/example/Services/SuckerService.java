package org.example.Services;
import org.example.Entities.Sucker;

public class SuckerService extends Sucker {
    //involves with earning from the suckers

    private double gained;


    //constructor
    public SuckerService() {
        super();
        gained =0;
    }
    public SuckerService(String name, double money, String address, String ban) {
        super (name, money, address,ban);
        gained =0;
    }
    public SuckerService(int id, String name, double money, String address) {
        super(id, name, money, address);
        gained =0;
    }
    public SuckerService(String name, double money, String address) {
        super(name, money, address);
        gained =0;
    }

    public double getGained() {
        return gained;
    }

    public void setGained(double gained) {
        this.gained = gained;
    }

    public void gainMoney(double gain){

        if (getBanned().equalsIgnoreCase("Y")){
            System.out.println("user is banned!!");
            return;
        }

        gained += gain;

        setMoney(getMoney()+gain);

        if (gain > getMoney()*0.75 || getMoney()<0){
            setBanned("Y");
        }

    }
}
