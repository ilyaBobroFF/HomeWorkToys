package controller;

import filework.Fileread;
import filework.Filesave;
import model.Lottery;
import model.Magazine;
import model.Toy;

public class Controller {
    private final String filename;
    private final String fileLottery;

    public Controller(String filename, String fileLottery) {
        this.filename = filename;
        this.fileLottery = fileLottery;
    }

    /** Основное добавление игрушки. В контроллере. */
    public void addToy(Toy toy){
        Fileread fileread = new Fileread(filename);
        Magazine magazine = fileread.readeFile();
        magazine.addToy(toy);
        Filesave filesave = new Filesave(filename);
        filesave.writeFile(magazine);
    }
    /** Чтение файла со списком игрушек. В контроллере. */
    public Magazine getToys() {
        Fileread fileread = new Fileread(filename);
        return fileread.readeFile();
    }
    /** Основной розыгрыш игрушек. В контроллере */
    public Magazine playToy() {
        Fileread fileread = new Fileread(filename);
        Magazine first = fileread.readeFile();
        Lottery lottery = new Lottery();
        Magazine result = lottery.raffle(first);
        Filesave filesave = new Filesave(fileLottery);
        filesave.writeFile(result);
        return result;
    }
    /** Выдача приза по порядку в зависимости от частоты выпадения */
    public Toy getPrize() {
        Fileread fileread = new Fileread(fileLottery);
        Magazine listlottery = fileread.readeFile();
        Lottery lottery = new Lottery();
        Toy toy = lottery.getMaxToy(listlottery);
        Magazine magazineChange = lottery.delToy(toy, listlottery);
        Filesave filesave = new Filesave(fileLottery);
        filesave.writeFile(magazineChange);
        return toy;
    }
    /** Выдача приза в произвольном порядке */
    public Toy getRandomPrize() {
        Fileread fileread = new Fileread(fileLottery);
        Magazine listlottery = fileread.readeFile();
        Lottery lottery = new Lottery();
        Toy toy = lottery.getRandomToy(listlottery);
        Magazine magazineChange = lottery.delToy(toy, listlottery);
        Filesave filesave = new Filesave(fileLottery);
        filesave.writeFile(magazineChange);
        return toy;
    }
    /** Изменение частоты выпадения игрушки */
    public void changeToy(String id, String chance, String filename) {
        Magazine magazine = this.getToys();
        for (Toy toy : magazine.getToys()){
            if (toy.getId().equals(id)){toy.setChance(chance);}
        }
        Filesave filesave = new Filesave(filename);
        filesave.writeFile(magazine);
    }
    /** Удаление игрушки */
    public void deleteToy(String id, String filename) {
        Magazine magazine = this.getToys();
        Magazine newmagazine = new Magazine();
        for (Toy toy : magazine.getToys()){
            if (!toy.getId().equals(id)){newmagazine.addToy(toy);}
        }
        Filesave filesave = new Filesave(filename);
        filesave.writeFile(newmagazine);
    }
}
