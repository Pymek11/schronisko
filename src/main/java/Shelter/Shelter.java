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
                Animal animal = new Animal(Integer.parseInt(data[0]), data[1], data[2],data[3], Integer.parseInt(data[4]),Float.parseFloat(data[5]));
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

    }
}

