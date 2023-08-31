package model;

import model.Toy;

import java.util.ArrayList;
import java.util.List;

public class Magazine {
    private List<Toy> magazine;

    public Magazine() {
        this.magazine = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        magazine.add(toy);
    }

    public List<Toy> getToys() {
        return this.magazine;
    }

    public int getSize(){
        return this.magazine.size();
    }
    public Toy getToyIndex(int index){
        if (magazine.size() == 0) return null;
        else return this.magazine.get(index);
    }

}
