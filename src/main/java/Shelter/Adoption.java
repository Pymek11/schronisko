package Shelter;

import java.util.Random;

public class Adoption {
    private int id;
    private int idofSubbmiter;
    private int idofAnimal;

    public Adoption(int id_, int idofSubbmiter_, int idofAnimal_){
        if(id_ == 0){
            id = generateID();
        }else {
            this.id = id_;

        }
        this.idofSubbmiter=idofSubbmiter_;
        this.idofAnimal=idofAnimal_;


    }
    private int generateID() {
        Random random = new Random();
        return 100000 + random.nextInt(900000); // Losowe ID z przedziału 100000 - 999999
    }
    public int getId(){
        return id;
    }

    public int getIdofAnimal() {
        return idofAnimal;
    }
    public void setIdofAnimal(int idofAnimal_){
        idofAnimal=idofAnimal_;
    }
    public int getIdofSubbmiter(){
        return idofSubbmiter;
    }
    public void setIdofSubbmiter(int idofSubbmiter_){
        idofSubbmiter=idofSubbmiter_;
    }
}
