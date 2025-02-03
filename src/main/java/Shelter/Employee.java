package Shelter;

import java.util.Random;

public class Employee{
    private String name;
    private String address;
    private String stanowisko;
    private int id;

    public Employee(int id_, String name_, String address_, String stanowisko_) {
        if(id == 0 ){
            this.id = generateID();
        }else{
            this.id=id_;
        }
        this.name = name_;
        this.address = address_;
        this.stanowisko = stanowisko_;

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getStanowisko() {
        return stanowisko;
    }
    public void setStanowisko(String stanowisko_) {
        this.stanowisko = stanowisko_;
    }
    public int getId() {
        return id;
    }
    private int generateID() {
        Random random = new Random();
        return random.nextInt(10000); // Losowe ID z przedziału 100000 - 999999
    }
}
