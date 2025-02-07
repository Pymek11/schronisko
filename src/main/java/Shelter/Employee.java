package Shelter;

import java.util.Random;

public class Employee{
    private String name;
    private String address;
    private String password;
    private int id;

    public Employee(int id_, String name_, String address_, String password) {
        this.id = id_;
        this.name = name_;
        this.address = address_;
        this.password = password;
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
    public int getId() {
        return id;
    }
    private int generateID() {
        Random random = new Random();
        return random.nextInt(10000); // Losowe ID z przedziału 100000 - 999999
    }
    public String getPassword() {
        return password;
    }
}
