
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
        int randomNumber = this.randomCreatureNumber();
        System.out.println("Creature : " + this.getCreature().getName());
        System.out.println("Creature number : " + randomNumber);
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
            if (combat(randomNumber)) {
                System.out.println(this.getName() + " has been cleared !");
                System.out.println(this.getName() + " is safe now !");
                return true;
            }

        } else if (select == 2) {
            System.out.println("***** Your escape chance is %50 ! *****");
            System.out.println("Your chances of escaping will be decided by a coin toss !");
            System.out.println("HEADS ---> RUN");
            System.out.println("TAİLS ---> FİGHT");
            System.out.print("Press enter for coin toss : ");
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
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("YOU ARE DEAD !");
            return false;
        }
        return true;
    }

    public boolean combat(int number) {
        int round = 1;
        for (int i = 1; i <= number; i++) {
            printPlayerStats();
            printEnemyStats(i);

            // if there are more than 1 creature when we killed one
            // loop moves to the second (or third) stage and the creatures health regenerates
            this.getCreature().setHealth(this.getCreature().getDefaulHealth());

            while (this.getPlayer().getHealth() > 0 && this.getCreature().getHealth() > 0) {// while the enemy or player is still alive
                System.out.println("START FİGHT");
                // we declare a variable for a shortcut to player's block
                int playersBlock = this.getPlayer().getInventory().getArmour().getBlock();

                System.out.println("ROUND " + round);
                System.out.print("FİGHT --> 1 --- 0 <--- RUN ");
                int slct = input.nextInt();

                if (slct == 1) {
                    System.out.println();
                    System.out.println("*****************");
                    System.out.println("YOU HİT !");
                    this.getCreature().setHealth(this.getCreature().getHealth() - this.getPlayer().getDamage());
                    afterHit(i);
                    if (this.getCreature().getHealth() > 0) {
                        System.out.println();
                        System.out.println("*****************");
                        System.out.println("ENEMY HİT !");
                        int blockedDamage = this.getCreature().getDamage() - playersBlock; // if enemy's damage is lower than our block we take that hit as 0
                        if (blockedDamage <= 0) {
                            blockedDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - blockedDamage);
                        afterHit(i);
                    }
                }
                round++;
            }
        }
        return false;
    }

    public void afterHit(int i) {
        System.out.println("*****************");

        if (this.getPlayer().getHealth() <= 0) {
            this.getPlayer().setHealth(0);
        }
        System.out.println("Your Health : " + this.getPlayer().getHealth());

        if (this.getCreature().getHealth() <= 0) {
            this.getCreature().setHealth(0);
        }
        System.out.println(i+". "+this.getCreature().getName() + "'s Health : " + this.getCreature().getHealth());

        System.out.println("*****************");
    }

    public void printPlayerStats() {
        System.out.println("*****************");
        System.out.println("Player's Stats");
        System.out.println("Your Health : " + this.getPlayer().getHealth());
        System.out.println("Your Block  : " + this.getPlayer().getInventory().getArmour().getBlock());
        System.out.println("Your Damage : " + this.getPlayer().getDamage());
        System.out.println("Your Money  : " + this.getPlayer().getMoney());
        System.out.println("*****************");
    }

    public void printEnemyStats(int i) {
        System.out.println("*****************");
        System.out.println(i + ". Enemy's Stats");
        System.out.println("Enemy's Health : " + this.getCreature().getHealth());
        System.out.println("Enemy's Damage : " + this.getCreature().getDamage());
        System.out.println("Enemy's Loot  : " + this.getCreature().getLoot());
        System.out.println("*****************");
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
