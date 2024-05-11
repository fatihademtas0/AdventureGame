
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
        System.out.println("------------------------");
        System.out.println("You entered the " + this.getName() + " ! ");
        int randomNumber = this.randomCreatureNumber();
        System.out.println("You have to get the " + this.getAward() + " !");
        waitSec();
        System.out.println("CAUTİON ! " + this.getCreature().getName() + "s rule this filthy place !");
        System.out.print("Searching the area for any danger ");
        waiting();
        if (randomNumber == 1)
            System.out.println("Looks like there is just 1 " + this.getCreature().getName() + " here.");
        else
            System.out.println("Looks like there are " + randomNumber + " " + this.getCreature().getName() + "s here.");
        waitSec();
        System.out.println("The " + this.getCreature().getName() + " is approaching !");
        System.out.println("GET READY !");
        waitSec();
        System.out.println("------------------------");
        System.out.println();
        System.out.println("1 - Fight");
        System.out.println("2 - Run");
        System.out.println();
        System.out.print("Select an action : ");
        int select = input.nextInt();
        System.out.println();
        while (select < 1 || select > 2) {
            System.out.println("*******************************");
            System.out.println("Enter a valid number !");
            System.out.println("*******************************");
            System.out.print("Select an action : ");
            select = input.nextInt();
        }
        if (select == 1 && combat(randomNumber)) {
            System.out.println("---------------------------------");
            System.out.println("You defeated all the " + this.getCreature().getName() + "s !");
            System.out.println("You won the " + this.getAward() + " of the " + this.getName() + " ! ");
            reward();
            System.out.println(this.getName() + " is safe !");
            System.out.print("For now");
            waiting();

            return true;
        } else if (select == 2) {
            coinToss();
            System.out.println();
            if (combat(randomNumber)) {
                System.out.println();
                System.out.println("---------------------------------");
                System.out.println("You defeated all the " + this.getCreature().getName() + "s !");
                System.out.println("You won the **" + this.getAward() + "** of the " + this.getName() + " ! ");
                reward();
                System.out.println(this.getName() + " is safe !");
                System.out.print("For now");
                waiting();
                return true;
            }
            else
                return false;
        }
        if (this.getPlayer().getHealth() <= 0) {
            waitSec();
            System.out.println("*****************");
            System.out.println("YOU ARE DEAD !");
            System.out.println("*****************");
            return false;
        }
        return true;
    }

    public boolean combat(int number) {
        int round = 1;
        int random = createNumber();
        for (int i = 1; i <= number; i++) {
            if (this.getCreature().getHealth() <= 0) {
                round = 1; // every creature dies the round loop reset itself
            }
            // if there are more than 1 creature when we killed one
            // loop moves to the second (or third) stage and the creatures health regenerates
            this.getCreature().setHealth(this.getCreature().getDefaulHealth());

            printPlayerStats();
            printEnemyStats(i);

            System.out.println();
            System.out.println("We toss a coin to decide who hits first !");
            System.out.print("Coin is spinning");
            waiting();
            if (random == 1) {
                System.out.println("-----------------------------");
                System.out.println("You are attacking first ! ");
                System.out.println("-----------------------------");
                System.out.println();
            } else {
                System.out.println("-----------------------------");
                System.out.println("Enemy is attacking first ! ");
                System.out.println("-----------------------------");
                System.out.println();
            }

            System.out.print("START FİGHT");
            waiting();
            while (this.getPlayer().getHealth() > 0 && this.getCreature().getHealth() > 0) {// while the enemy or player is still alive
                System.out.println();
                System.out.println("ROUND " + round);
                System.out.println();
                waitSec();
                System.out.print("FİGHT ---> <1> --- <0> <--- RUN (-5 HEALTH) ");
                int slct = input.nextInt();
                waitSec();

                if (slct == 1) {
                    System.out.println();
                    // we are deciding who hits first
                    // first rounds decided by a coin toss
                    // and other rounds need to be in the same order as round 1
                    if (random == 1 && round == 1) {
                        playerHit(i);
                        if (this.getCreature().getHealth() > 0) {
                            enemyHit(i);
                        }
                    } else if (random == 2 && round == 1) {
                        enemyHit(i);
                        if (this.getPlayer().getHealth() > 0) {
                            playerHit(i);
                        }
                    } else if (random == 1 && round != 1) {
                        playerHit(i);
                        if (this.getCreature().getHealth() > 0) {
                            enemyHit(i);
                        }
                    } else if (random == 2 && round != 1) {
                        enemyHit(i);
                        if (this.getPlayer().getHealth() > 0) {
                            playerHit(i);
                        }
                    }
                } else {
                    // if player selected to run in combat  decreasing player's health 5 point
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - 5);
                    return false;
                }
                round++;
            }
            if (this.getPlayer().getHealth() > this.getCreature().getHealth()) {
                System.out.println();
                System.out.println("-------------------------------");
                System.out.println("You defeated the " + this.getCreature().getName() + " !");
                System.out.println("Remaining " + this.getCreature().getName() + " : " + (number - i));
                System.out.print("Current balance : " + this.getPlayer().getMoney() + " + " + this.getCreature().getLoot());
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getCreature().getLoot());
                System.out.println(" = " + this.getPlayer().getMoney());
                System.out.println("-------------------------------");
                System.out.println();
            } else
                return false;
        }
        return true;
    }

    public void playerHit(int i) {
        System.out.println();
        System.out.println("-------------------");
        System.out.println("YOU HİT " + this.getPlayer().getDamage() + " DAMAGE !");
        System.out.println("-------------------");
        waitSec();
        System.out.println();
        this.getCreature().setHealth(this.getCreature().getHealth() - this.getPlayer().getDamage());
        afterHit(i);
    }

    public void enemyHit(int i) {
        // we declare a variable for a shortcut to player's block
        int playersBlock = this.getPlayer().getInventory().getArmour().getBlock();

        System.out.println();
        System.out.println("-------------------");
        System.out.println("ENEMY HİT " + this.getCreature().getDamage() + " DAMAGE !");
        System.out.println("-------------------");
        waitSec();
        System.out.println();
        int blockedDamage = this.getCreature().getDamage() - playersBlock; // if enemy's damage is lower than our block we take that hit as 0
        if (blockedDamage <= 0) {
            blockedDamage = 0;
        }
        this.getPlayer().setHealth(this.getPlayer().getHealth() - blockedDamage);
        afterHit(i);
    }

    public void coinToss() {
        System.out.println("***** Your escape chance is %50 ! *****");
        System.out.println("Your chances of escaping will be decided by a coin toss !");
        System.out.println("HEADS ---> RUN");
        System.out.println("TAİLS ---> FİGHT");
        waitSec();
        System.out.print("Press enter to flip the coin : ");
        input.nextLine(); // to clean input
        input.nextLine();
        System.out.print("COİN İS FALLİNG SLOWLY");
        waiting();

        int number = (int) (Math.random() * (2)) + 1;

        if (number == 1) {
            System.out.println();
            System.out.println("--------------");
            System.out.println("İT'S HEADS !");
            System.out.println("--------------");
            System.out.println();
            waitSec();
            System.out.println("You have succesfully escaped from the " + this.getName() + " !");
            System.out.println();
            waitSec();
        } else if (number == 2) {
            System.out.println();
            System.out.println("--------------");
            System.out.println("İT'S TAİLS !");
            System.out.println("--------------");
            System.out.println();
            waitSec();
            System.out.print("You have to stay and fight");
            waiting();
            System.out.println();
        }
    }

    public void afterHit(int i) {
        System.out.println("-------------------");

        if (this.getPlayer().getHealth() <= 0) {
            this.getPlayer().setHealth(0);
        }
        System.out.println(this.getPlayer().getName() + "'s Health : " + this.getPlayer().getHealth());

        if (this.getCreature().getHealth() <= 0) {
            this.getCreature().setHealth(0);
        }
        System.out.println(i + ". " + this.getCreature().getName() + "'s Health : " + this.getCreature().getHealth());

        System.out.println("-------------------");
        waitSec();
    }

    public void printPlayerStats() {
        System.out.println("---------------------");
        System.out.println(this.getPlayer().getName() + "'s Stats");
        System.out.println(this.getPlayer().getName() + "'s Health : " + this.getPlayer().getHealth());
        System.out.println(this.getPlayer().getName() + "'s Block  : " + this.getPlayer().getInventory().getArmour().getBlock());
        System.out.println(this.getPlayer().getName() + "'s Damage : " + this.getPlayer().getDamage());
        System.out.println(this.getPlayer().getName() + "'s Money  : " + this.getPlayer().getMoney());
        System.out.println("---------------------");
        waitSec();
        System.out.println();
    }

    public void printEnemyStats(int i) {
        System.out.println("---------------------");
        System.out.println(i + ". " + this.getCreature().getName() + "'s Stats");
        System.out.println(this.getCreature().getName() + "'s Health : " + this.getCreature().getHealth());
        System.out.println(this.getCreature().getName() + "'s Damage : " + this.getCreature().getDamage());
        System.out.println(this.getCreature().getName() + "'s Loot  : " + this.getCreature().getLoot());
        System.out.println("---------------------");
        waitSec();
        System.out.println();
    }

    public void reward() {
        switch (this.getName()) {
            case "Cave":
                this.getPlayer().getInventory().setFood(this.getAward());
            case "Forest":
                this.getPlayer().getInventory().setFirewood(this.getAward());
            case "River":
                this.getPlayer().getInventory().setFish(this.getAward());
        }
    }

    public int randomCreatureNumber() {
        int number = (int) (Math.random() * (this.getMaxCreature())) + 1; // creates number between 1-3 (both included)
        return number;
    }

    public int createNumber() {
        int number = (int) (Math.random() * (2)) + 1; // creates number between 1-2 (both included)
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
