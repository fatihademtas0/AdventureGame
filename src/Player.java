import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int defaultHealth;
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
            System.out.println();
        }
    }

    public void printInfo() {
        Game.waitSec();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(this.getName() + "'s Weapon : " + this.getInventory().getWeapons().getName());
        System.out.println(this.getName() + "'s Armour : " + this.getInventory().getArmour().getName());
        System.out.println(this.getName() + "'s Health : " + this.getHealth());
        System.out.println(this.getName() + "'s Damage : " + this.getDamage());
        System.out.println(this.getName() + "'s Block  : " + this.getInventory().getArmour().getBlock());
        System.out.println(this.getName() + "'s Money  : " + this.getMoney());
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
                System.out.println("-------------------------");
                System.out.println("You are a Samurai now !");
                System.out.println("-------------------------");
                System.out.println();
                break;
            case 2:
                initPlayer(new Archer());
                System.out.println("-------------------------");
                System.out.println("You are an Archer now !");
                System.out.println("-------------------------");
                System.out.println();
                break;
            case 3:
                initPlayer(new Knight());
                System.out.println("-------------------------");
                System.out.println("You are a Knight now !");
                System.out.println("-------------------------");
                System.out.println();
                break;
            default:
                System.out.println("Please enter a valid number !");
        }
    }

    public void initPlayer(Characters characters) {
        this.setDamage(characters.getDamage());
        this.setHealth(characters.getHealth());
        this.setDefaultHealth(characters.getHealth());
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

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }
}
