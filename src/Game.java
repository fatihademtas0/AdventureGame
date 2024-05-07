
import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome Adventurer !");

        System.out.print("Name : ");
        String name = input.nextLine();

        Player player = new Player(name);

        player.printChar();

        System.out.print("Select a character : ");
        int charSel = input.nextInt();

        player.selectChar(charSel);

        Location location = null;
        while (true) {

            player.printInfo();

            System.out.println();
            System.out.println("---------------------");
            System.out.println("--LOCATİONS--");
            System.out.println("1 - \t Safe House");
            System.out.println("2 - \t Shop");
            System.out.println("3 - \t Cave");
            System.out.println("4 - \t Forest");
            System.out.println("5 - \t River");
            System.out.println("0 - \t Exit Game");
            System.out.println("---------------------");

            System.out.print("Select a location to go : ");
            int selectLoc = input.nextInt();

            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    System.out.println();
                    break;
                case 2:
                    location = new Shop(player);
                    System.out.println();
                    break;
                case 3:
                    location = new Cave(player);
                    System.out.println();
                    break;
                case 4:
                    location = new Forest(player);
                    System.out.println();
                    break;
                case 5:
                    location = new River(player);
                    System.out.println();
                    break;
                default:
                    System.out.println("----------------------------");
                    System.out.println("You entered an invalid location number !");
                    System.out.println("You are sent to the Safe House !");
                    System.out.println("----------------------------");
                    location = new SafeHouse(player);
                    System.out.println();
            }

            if (location == null) {
                System.out.println("Farewell Adventurer !");
                break;
            }

            if (!location.onLocation()) {
                System.out.println();
                System.out.println("-----GAME OVER-----");
                break;
            }
        }
    }
}
