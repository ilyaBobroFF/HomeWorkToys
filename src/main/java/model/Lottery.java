package model;

import java.util.PriorityQueue;
import java.util.Queue;

public class Lottery {
    /** Алгоритм комплектации списка разыгранных игрушек. */
    public Magazine raffle(Magazine magazine) {
        Magazine result = new Magazine();
        for (Toy toy : magazine.getToys()) {
            for (int i = 0; i < Integer.parseInt(toy.getChance()) / 10; i++) {
                result.addToy(toy);
            }
        }
        return result;
    }
    /** Передача выигрыша по величине выпадения. */
    public Toy getMaxToy(Magazine listlottery) {
        Queue<Toy> queueResult = new PriorityQueue<>();
        queueResult.addAll(listlottery.getToys());
        Toy toy = queueResult.poll();
        return toy;
    }
    /** Удаление из списка переданного выигрыша. */
    public Magazine delToy(Toy toydel, Magazine listlottery) {
        Magazine newmagazine = new Magazine();
        boolean delOk = false;
        for (Toy toy : listlottery.getToys()) {
            if (toydel.getId().equals(toy.getId()) && !delOk) delOk = true;
            else newmagazine.addToy(toy);
        }
        return newmagazine;
    }
    /** Передача выигрыша в произвольном порядке */
    public Toy getRandomToy(Magazine listlottery) {
        int size = listlottery.getSize();
        int step = (int)(Math.random() * size);
        System.out.println(step);
        return listlottery.getToyIndex(step);
        }
}
