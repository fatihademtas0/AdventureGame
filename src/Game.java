
import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome Adventurer !");
        System.out.println("You have to gather 3 magical item from different areas to win the game.");

        System.out.print("Your Name : ");
        String name = input.nextLine();

        Player player = new Player(name);

        System.out.print("Loading the characters");
        waiting();
        player.printChar();

        System.out.print("Select a character : ");
        int charSel = input.nextInt();

        System.out.print("Creating");
        waiting();

        player.selectChar(charSel);

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            waitSec();
            System.out.println("---------------------");
            System.out.println("--LOCATİONS--");
            System.out.println("1 - \t Safe House");
            System.out.println("2 - \t Shop");
            System.out.println("3 - \t Cave");
            System.out.println("4 - \t Forest");
            System.out.println("5 - \t River");
            System.out.println("6 - \t Mine");
            System.out.println("0 - \t Exit Game");
            System.out.println("---------------------");

            System.out.print("Select a location to go : ");
            int selectLoc = input.nextInt();

            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    System.out.print("Area loading");
                    waiting();
                    System.out.println();
                    location = new SafeHouse(player);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Area loading");
                    waiting();
                    System.out.println();
                    location = new Shop(player);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Area loading");
                    waiting();
                    System.out.println();
                    if (player.closeLocation("Cave")) {
                        System.out.println("You've accomplished everything there is to achieve in Cave !");
                        System.out.println("Hit the road Adventurer " + player.getName() + " !");
                        System.out.println();
                        waitSec();
                        System.out.print("You are sent to the safe house . Please wait");
                        waiting();
                        System.out.println();
                        location = new SafeHouse(player);
                    } else {
                        location = new Cave(player);
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.print("Area loading");
                    waiting();
                    System.out.println();
                    if (player.closeLocation("Forest")) {
                        System.out.println("You've accomplished everything there is to achieve in Forest !");
                        System.out.println("Hit the road Adventurer " + player.getName() + " !");
                        System.out.println();
                        System.out.print("You are sent to the safe house . Please wait");
                        waiting();
                        System.out.println();
                        location = new SafeHouse(player);
                    } else {
                        location = new Forest(player);
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.print("Area loading");
                    waiting();
                    System.out.println();
                    if (player.closeLocation("River")) {
                        System.out.println("You've accomplished everything there is to achieve in River !");
                        System.out.println("Hit the road Adventurer " + player.getName() + " !");
                        System.out.println();
                        System.out.print("You are sent to the safe house . Please wait");
                        waiting();
                        System.out.println();
                        location = new SafeHouse(player);
                    } else {
                        location = new River(player);
                        System.out.println();
                    }
                    break;
                case 6:
                    System.out.print("Area loading");
                    waiting();
                    System.out.println();
                    location = new Mine(player);
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
            if (player.checkWin()) {
                player.checkReward();
                System.out.println();
                System.out.println("------------------CONGRATS------------------");
                waitSec();
                System.out.println("You collected all the rewards !");
                System.out.println();
                System.out.println("------------------YOU WON THE GAME !------------------");
                break;
            }
        }
    }

    public static void waiting() {
        int count = 0;
        while (count < 3) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
            count++;
        }
        System.out.println();
    }

    public static void waitSec() {
        int count = 0;
        while (count < 2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
        System.out.println();
    }
}
