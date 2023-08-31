package model;

public class Toy implements Comparable{
    private String id;
    private String name;
    private String chance;

    public Toy(String id, String name, String chance){
        this.id = id;
        this.name = name;
        this.chance = chance;
    }

    public String getId (){
       return  this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getChance(){
        return this.chance;
    }
    public void setChance(String chance){
        this.chance = chance;
    }
    @Override
    public String toString(){
        return "ID: "+ this.id +"\n"+
                "Name: "+ this.name+"\n"+
                "Chance: "+ this.chance+"\n";
    }

    @Override
    public int compareTo(Object o) {
        int result = 0;
        Toy toy = (Toy) o;
        if (Integer.parseInt(toy.getChance()) > Integer.parseInt(this.chance)) result = 1;
        else if (Integer.parseInt(toy.getChance()) < Integer.parseInt(this.chance))  result = -1;
        return result;
    }
}
