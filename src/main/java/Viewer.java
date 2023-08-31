
import controller.Controller;
import model.Magazine;
import model.Toy;
import java.util.Scanner;

public class Viewer {
    private String fileLottery = "Lottery.txt";
    private String filename = "Toys.txt";
    private Controller controller = new Controller(filename, fileLottery);

    /** Запуск всех действий */
    public void run (){
        int mode = firstinfo();

        switch (mode){
            case 1:
                Toy toy = getToy();
                controller.addToy(toy);
                break;
            case 2:
                Magazine magazine = controller.getToys();
                System.out.println(magazine.getToys());
                break;
            case 3:
                Magazine result = controller.playToy();
                System.out.println(result.getToys()); // Отображение разыгранных призов
                break;
            case 4:
                toy = controller.getPrize();
                while (toy != null){
                    System.out.println("Выигрыш: \n"+toy);
                    int submode = getPrize();
                    if (submode == 1) toy = controller.getPrize();
                    else if (submode == 0) break;
                    else {
                        System.out.println("Повторите ввод");
                        submode = getPrize();
                    }
                }
                if(toy == null) System.out.println("Игрушки закончились. Повторите розыгрыш.");
                break;
            case 5:
                toy = controller.getRandomPrize();
                while (toy != null){
                    System.out.println("Выигрыш: \n"+toy);
                    int submode = getPrize();
                    if (submode == 1) toy = controller.getRandomPrize();
                    else if (submode == 0) break;
                    else {
                        System.out.println("Повторите ввод для произвольного приза");
                        submode = getPrize();
                    }
                }
                if(toy == null) System.out.println("Игрушки закончились. Повторите произвольный розыгрыш.");
                break;
            case 6:
                Scanner sc = new Scanner(System.in);
                System.out.print("Введите идентификатор игрушки: ");
                String id = sc.nextLine();
                System.out.print("Введите новую частоту выпадения: ");
                String chance = sc.nextLine();
                controller.changeToy(id, chance, filename);
                break;
            case 7:
                sc = new Scanner(System.in);
                System.out.print("Введите идентификатор игрушки: ");
                id = sc.nextLine();
                controller.deleteToy(id, filename);
                break;
        }
    }
    /** Меню при выдаче разыгранных призов */
    private int getPrize() {
        Scanner in = new Scanner(System.in);
        System.out.print("1 - Выдать следующий приз\n" +
                "0 - Приостановить и выйти: \n");
        int num = in.nextInt();
        return num;
    }

    /** Основное меню информации для выбора действий */
    private int firstinfo() {
        System.out.println("1 - Добавить новую игрушку \n" +
                "2 - Просмотр имеющихся игрушек \n" +
                "3 - Выполнить розыгрыш\n" +
                "4 - Передать выигрыш по большей частоте\n" +
                "5 - Передать выигрыш в произвольном порядке\n" +
                "6 - Изменить частоту выпадения игрушки по ID\n" +
                "7 - Удалить игрушку");
        Scanner in = new Scanner(System.in);
        System.out.print("Выберите режим работы: ");
        int num = in.nextInt();
        return num;
    }
    /** Меню для добавления игрушки */
    private Toy getToy() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите идентификатор игрушки: ");
        String id = sc.nextLine();
        System.out.print("Введите наименование игрушки: ");
        String name = sc.nextLine();
        System.out.print("Введите вероятность выпадения игрушки. От 10 до 100, кратное 10: ");
        String chance = sc.nextLine();
        sc.close();
        return new Toy(id, name, chance);
    }
}