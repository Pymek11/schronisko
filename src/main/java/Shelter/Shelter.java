package Shelter;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Shelter {
    private List<Animal> animalList;
    private List<Employee> employeeList;
    private List<Adoption> adoptionList;
    private List<User> userList;
    private List<String> speciesList;

    private static Shelter instance;


    public Shelter() {
        this.animalList = new ArrayList<>();
        this.employeeList = new ArrayList<>();
        this.adoptionList = new ArrayList<>();
        this.userList = new ArrayList<>();
        this.speciesList = Arrays.asList("pies","kot");

        loadAnimalListFromCSV("ListaZwierzat");
        loadEmployeeListFromCSV("ListaPracownikow");
        loadAdoptionListFromCSV("ListaWnioskow");
        loadUserListFromCSV("ListaUzytkownikow");
    }
    public static Shelter getInstance() {
        if (instance == null) {
            instance = new Shelter();
        }
        return instance;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public List<User> getGetUserList() {
        return userList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<Adoption> getAdoptionList() {
        return adoptionList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<String> getSpeciesList() {
        return speciesList;
    }

    private void loadAnimalListFromCSV(String filename) {
        String filePath = "src/main/resources/com/example/schronisko/" + filename;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Pominięcie nagłówka
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                //ID,Species,Breed,Age,Weight,Description,Picture
                Animal animal = new Animal(Integer.parseInt(data[0]), data[1], data[2],data[3], Integer.parseInt(data[4]),Float.parseFloat(data[5]));
                animal.setDescription(data[6]);
                animal.setPicture(data[7]);
                animalList.add(animal);
            }

        } catch (IOException e) {
            System.out.println("Błąd podczas wczytywania listy zwierząt z pliku CSV.");
            e.printStackTrace();
        }
    }

    private void loadEmployeeListFromCSV(String filename) {
        String filePath = "src/main/resources/com/example/schronisko/" + filename;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
               String[] data = line.split(",");
                Employee employee = new Employee(Integer.parseInt(data[0]), data[1], data[2],data[3],data[4]);
                addEmployeeToList(employee);
            }
        } catch (IOException e) {
            System.out.println("Błąd podczas wczytywania listy pracowników z pliku CSV.");
            e.printStackTrace();
        }
    }

    private void loadAdoptionListFromCSV(String filename) {
        String filePath = "src/main/resources/com/example/schronisko/" + filename;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Adoption adoption = new Adoption(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]));
                addAdoptionApplicationToList(adoption);
            }
        } catch (IOException e) {
            System.out.println("Błąd podczas wczytywania listy adopcji z pliku CSV.");
            e.printStackTrace();
        }
    }

    private void loadUserListFromCSV(String filename) {
        String filePath = "src/main/resources/com/example/schronisko/" + filename;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                User user = new User(Integer.parseInt(data[0]), data[1], data[2],data[3],data[4]);
                addUserToList(user);
            }
        } catch (IOException e) {
            System.out.println("Błąd podczas wczytywania listy użytkowników z pliku CSV.");
            e.printStackTrace();
        }
    }

    public Animal getAnimalListElem(int i){
        try {
            if(i<animalList.size()){
                return animalList.get(i);
            }else{
                throw  new IndexOutOfBoundsException();
            }

        }catch (IndexOutOfBoundsException e){
            System.out.println("Nie ma takiego elementu!!!");
        }
        return null;
    }
    public void addAnimalToList(Animal animal){
        animalList.add(animal);
    }

    public Employee getEmployeeListElem(int i){
        try {
            if(i<employeeList.size()){
                return employeeList.get(i);
            }else{
                throw  new IndexOutOfBoundsException();
            }

        }catch (IndexOutOfBoundsException e){
            System.out.println("Nie ma takiego elementu!!!");
        }
        return null;
    }
    public void addEmployeeToList(Employee employee){
        employeeList.add(employee);
    }

    public Adoption getAdoptionListElem(int i){
        try {
            if(i<adoptionList.size()){
                return adoptionList.get(i);
            }else{
                throw  new IndexOutOfBoundsException();
            }

        }catch (IndexOutOfBoundsException e){
            System.out.println("Nie ma takiego elementu!!!");
        }
        return null;
    }
    public void addAdoptionApplicationToList(Adoption adoption){
        adoptionList.add(adoption);
    }

    public User getUserListElem(int i){
        try {
            if(i<userList.size()){
                return userList.get(i);
            }else{
                throw  new IndexOutOfBoundsException();
            }

        }catch (IndexOutOfBoundsException e){
            System.out.println("Nie ma takiego elementu!!!");
        }
        return null;
    }
    public void addUserToList(User user){
        userList.add(user);
    }

    // Zapisz listy zwierzat do pliku csv
    public void saveAnimalListToCSV() {
        String filePath = "src/main/resources/com/example/schronisko/ListaZwierzat";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("ID,Species,Breed,Age,Weight,Description,Picture\n"); // Nagłówki kolumn
            for (Animal animal : animalList) {
                writer.write(
                        animal.getID() + "," +
                        animal.getImie() +","+
                        animal.getSpecies() + "," +
                        animal.getBreed() + "," +
                        animal.getAge() + "," +
                        animal.getWeight() + "," +
                        animal.getDescription() + "," +
                        animal.getPicture() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisu do pliku CSV.");
            e.printStackTrace();
        }
    }

    public void saveEmployeeListToCSV() {
        String filePath = "src/main/resources/com/example/schronisko/ListaPracownikow";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("ID,Name,Address,Email,AdoptionId\n"); // Nagłówki kolumn
            for (User user : userList) {
                writer.write(
                        user.getId() + "," +
                        user.getName() + ","+
                        user.getAddress() + ","+
                        user.getEmail()+ ","+
                        user.getPassword()+ ","+
                        user.getAdoptionIdList() +"\n");
            }
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisu do pliku CSV.");
            e.printStackTrace();
        }
    }

    public void saveAdoptionListToCSV() {
        String filePath = "src/main/resources/com/example/schronisko/ListaWnioskow" ;
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("IDWniosku,IDSkladajacego,IDZwierzecia\n"); // Nagłówki kolumn
            for (Adoption adoption : adoptionList) {
                writer.write(
                        adoption.getId()+","+
                        adoption.getIdofSubbmiter()+","+
                        adoption.getIdofAnimal()+"\n");
            }
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisu do pliku CSV.");
            e.printStackTrace();
        }
    }

    public void saveUserListToCSV() {
        String filePath = "src/main/resources/com/example/schronisko/ListaUzytkownikow";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("ID,Name,Address,Email,Haslo,AdoptionId\n"); // Nagłówki kolumn
            for (User user : userList) {
                writer.write(
                        user.getId() + "," +
                        user.getName() + ","+
                        user.getAddress() + ","+
                        user.getEmail()+ ","+
                        user.getPassword()+ ","+
                        user.getAdoptionIdList() +"\n");
            }
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisu do pliku CSV.");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Shelter shelter = new Shelter();
        Animal animal = new Animal(0,"Burek","Pies","Mieszaniec",10,20);
        animal.setPicture("pies1.png");
        shelter.addAnimalToList(animal);
        Animal animal1 = new Animal(0,"Azor","Pies","Mieszaniec",9,15.1f);
        animal1.setPicture("pies2.png");
        shelter.addAnimalToList(animal1);
        Animal animal3 = new Animal(0,"Pymek","Pies","Mieszaniec",17,62.1f);
        animal3.setPicture("pies10.png");
        shelter.addAnimalToList(animal3);
        Animal animal4 = new Animal(0,"Suchar","Pies","Mieszaniec",5,12.1f);
        animal4.setPicture("pies3.png");
        shelter.addAnimalToList(animal4);
        Animal animal5 = new Animal(0,"Moris","Pies","Mieszaniec",13,9.3f);
        animal5.setPicture("pies4.png");
        shelter.addAnimalToList(animal5);
        Animal animal6 = new Animal(0,"Riko","Pies","Mieszaniec",11,14.1f);
        animal6.setPicture("pies5.png");
        shelter.addAnimalToList(animal6);
        Animal animal7 = new Animal(0,"Bazyl","Pies","Mieszaniec",5,12f);
        animal7.setPicture("pies6.png");
        shelter.addAnimalToList(animal7);
        Animal animal8 = new Animal(0,"Cazar","Pies","Mieszaniec",6,9.2f);
        animal8.setPicture("pies7.png");
        shelter.addAnimalToList(animal8);
        Animal animal9 = new Animal(0,"Reksio","Pies","Mieszaniec",3,13.4f);
        animal9.setPicture("pies8.png");
        shelter.addAnimalToList(animal9);
        Animal animal2 = new Animal(0,"Magnus","Pies","Mieszaniec",8,23f);
        animal2.setPicture("pies9.png");
        shelter.addAnimalToList(animal2);
        Animal animal11 = new Animal(0,"Wojtek","NiePies","Niedźwiedź",78,453.5f);
        animal11.setPicture("pies11.png");
        shelter.addAnimalToList(animal11);
        shelter.saveUserListToCSV();
        shelter.saveEmployeeListToCSV();
        shelter.saveAnimalListToCSV();
    }
}

