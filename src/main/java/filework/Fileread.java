package filework;

import model.Magazine;
import model.Toy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Fileread {
    private String filename;
    public Fileread(String filename){
        this.filename = filename;
    }
    /** Чтение файла с перечнем игрушек */
    public Magazine readeFile(){
        Magazine magaz = new Magazine();
        try(FileReader reader = new FileReader(filename))
        {
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();
            String id = "";
            String name = "";
            String chance = "";
            while (line != null) {
                String[] print = line.split(": ");
                id = print[1];
                line = br.readLine();
                print = line.split(": ");
                name = print[1];
                line = br.readLine();
                print = line.split(": ");
                chance = print[1];
                line = br.readLine();
                Toy toy = new Toy(id, name, chance);
                magaz.addToy(toy);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return magaz;
    }
}
