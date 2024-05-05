import Characters.Archer;
import Characters.Characters;
import Characters.Knight;
import Characters.Samurai;

import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;
    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void printChar() {
        Characters[] chars = {new Samurai(), new Archer(), new Knight()};

        for (Characters c : chars) {

            System.out.println("-----------------------------------------------------------------");
            System.out.println(c.getId() + " -\t " + c.getCharName() + " \t| Damage : " + c.getDamage() +
                    "\t| Health : " + c.getHealth() + "\t| Money : " + c.getMoney() + " \t|");
            System.out.println("-----------------------------------------------------------------");
        }
        /*
        for (Characters c : Characters.characters()){
            System.out.println("-----------------------------------------------------------------");
            System.out.println(c.getId()+" -\t "+c.getCharName()+" \t| Damage : "+c.getDamage()+
                    "\t| Health : "+c.getHealth()+"\t| Money : "+c.getMoney()+" \t|");
            System.out.println("-----------------------------------------------------------------");
        }

         */
        /*
        System.out.println("-----------------------------------------------------------------");
        System.out.println("1 - Samurai \t| Damage : 5 \t| Health : 21 \t| Money : 15 \t|");
        System.out.println("2 - Archer  \t| Damage : 7 \t| Health : 18 \t| Money : 20 \t|");
        System.out.println("3 - Knight  \t| Damage : 8 \t| Health : 24 \t| Money : 5  \t|");
        System.out.println("------------------------------------------------------------------");
         */
    }

    public void printInfo() {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("Your Health : " + this.getHealth());
        System.out.println("Your Damage : " + this.getDamage());
        System.out.println("Your Money  : " + this.getMoney());
        System.out.println("Your Weapon : " + this.inventory.getWeapons().getName());
        System.out.println("Your armour : " + this.inventory.getArmour().getName());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    public void selectChar(int charSel) {
        while (charSel < 1 || charSel > 3) {
            System.out.println("*******************************");
            System.out.println("Enter a valid number !");
            System.out.println("*******************************");
            System.out.print("Select a character : ");
            charSel = input.nextInt();
        }
        switch (charSel) {
            case 1:
                initPlayer(new Samurai());
                System.out.println("*******************************");
                System.out.println("You are a Samurai now !");
                System.out.println("*******************************");
                break;
            case 2:
                initPlayer(new Archer());
                System.out.println("*******************************");
                System.out.println("You are an Archer now !");
                System.out.println("*******************************");
                break;
            case 3:
                initPlayer(new Knight());
                System.out.println("*******************************");
                System.out.println("You are a Knight now !");
                System.out.println("*******************************");
                break;
            default:
                System.out.println("Please enter a valid number !");
        }
    }

    public void initPlayer(Characters characters) {
        this.setDamage(characters.getDamage());
        this.setHealth(characters.getHealth());
        this.setMoney(characters.getMoney());
    }

    public int getDamage() {
        return damage + this.inventory.getWeapons().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
