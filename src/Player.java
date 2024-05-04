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
    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }

    public void showChar() {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("1 - Samurai \t| Damage : 5 \t| Health : 21 \t| Money : 15 \t|");
        System.out.println("2 - Archer  \t| Damage : 7 \t| Health : 18 \t| Money : 20 \t|");
        System.out.println("3 - Knight  \t| Damage : 8 \t| Health : 24 \t| Money : 5  \t|");
        System.out.println("------------------------------------------------------------------");
    }

    public void selectChar(int charSel) {
        switch (charSel) {
            case 1:
                initPlayer(new Samurai());
                System.out.println("You are a Samurai now !");
                break;
            case 2:
                initPlayer(new Archer());
                System.out.println("You are an Archer now !");
                break;
            case 3:
                initPlayer(new Knight());
                System.out.println("You are a Knight now !");
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
        return damage;
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
}
