
import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome Adventurer !");

        System.out.print("Name : ");
        String name = input.nextLine();

        Player player = new Player(name);

        player.showChar();

        System.out.print("Select a character : ");
        int charSel = input.nextInt();

        player.selectChar(charSel);

        Location location = null;
        while (true) {
            System.out.println();
            System.out.println("---------------------");
            System.out.println("--LOCATİONS--");
            System.out.println("1 - \t Safe House");
            System.out.println("2 - \t Shop");
            System.out.println("---------------------");

            System.out.print("Select a location to go : ");
            int selectLoc = input.nextInt();

            switch (selectLoc) {
                case 1:
                    location = new SafeHouse(player);
                    System.out.println();
                    break;
                case 2:
                    location = new Shop(player);
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

            if (!location.onLocation()) {
                System.out.println();
                System.out.println("-----GAME OVER-----");
                break;
            }
        }


    }
}
