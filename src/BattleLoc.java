import java.sql.SQLOutput;

public abstract class BattleLoc extends Location {
    private Creature creature;
    private String award;
    private int maxCreature;

    public BattleLoc(Player player, String name, Creature creature, String award, int maxCreature) {
        super(player, name);
        this.creature = creature;
        this.award = award;
        this.maxCreature = maxCreature;
    }

    @Override
    boolean onLocation() {
        System.out.println("**********************");
        System.out.println("You are here : " + this.getName());
        System.out.println("Creature : " + this.getCreature().getName());
        System.out.println("Creature number : " + randomCreatureNumber());
        System.out.println("**********************");
        System.out.println("1 - Fight");
        System.out.println("2 - Run");
        System.out.println("**********************");
        System.out.print("Select an action : ");
        int select = input.nextInt();
        while (select < 1 || select > 2) {
            System.out.println("*******************************");
            System.out.println("Enter a valid number !");
            System.out.println("*******************************");
            System.out.print("Select an action : ");
            select = input.nextInt();
        }
        if (select == 1) {
            // FİGHT
        } else if (select == 2) {
            System.out.println("***** Your escape chance is %50 ! *****");
            System.out.println("Your chances of escaping will be decided by a coin toss !");
            System.out.println("HEADS ---> RUN");
            System.out.println("TAİLS ---> FİGHT");
            System.out.print("Press any key for coin toss : ");
            input.nextLine(); // to clean input
            input.nextLine();

            int number = (int) (Math.random() * (2)) + 1;

            if (number == 1) {
                System.out.println("*************");
                System.out.println("İT'S HEADS !");
                System.out.println("*************");
                System.out.println("You have succesfully escaped from the " + this.getName() + " !");
            } else if (number == 2) {
                System.out.println("*************");
                System.out.println("İT'S TAİLS !");
                System.out.println("*************");
                System.out.println("You have to stay and fight");
                // FİGHT
            }
        }
        return true;
    }

    public int randomCreatureNumber() {
        int number = (int) (Math.random() * (this.getMaxCreature())) + 1;
        return number;
    }

    public Creature getCreature() {
        return creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxCreature() {
        return maxCreature;
    }

    public void setMaxCreature(int maxCreature) {
        this.maxCreature = maxCreature;
    }
}
