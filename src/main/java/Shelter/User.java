package Shelter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User {
    private String name;
    private String address;
    private String email;
    private String password;
    private int id;
    private List<Integer> adoptionIdList= new ArrayList<>();

    public User(int id, String name, String address, String email,String password) {
        if(id == 0 ){
            this.id = generateID();
        }else{
            this.id=id;
        }
        this.name = name;
        this.address = address;
        this.email = email;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
