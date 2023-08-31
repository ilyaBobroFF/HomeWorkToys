package filework;

import model.Magazine;
import model.Toy;
import java.io.FileWriter;
import java.io.IOException;


public class Filesave {
    private String filename;

    public Filesave(String filename){
        this.filename = filename;
    }
    /** Запись в файл любого перечня игрушек */
    public void writeFile(Magazine magaz){
        try(FileWriter writer = new FileWriter(filename, false))
        {
            for (Toy toy: magaz.getToys()) {
                String text = toy.toString();
                writer.write(text);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
