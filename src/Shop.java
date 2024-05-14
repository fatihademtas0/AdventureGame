public class Shop extends NormalLoc {
    public Shop(Player player) {
        super(player, "Shop");
    }

    @Override
    public boolean onLocation() {
        boolean showMenu = true;
        System.out.println("Welcome to the shop !");
        while (showMenu) {
            waitSec();
            System.out.println();
            System.out.println(this.getPlayer().getName() + "'s money : " + this.getPlayer().getMoney());
            System.out.println("----------------");
            System.out.println("1 - Weapons ");
            System.out.println("2 - Armours ");
            System.out.println("3 - Exit ");
            System.out.println("----------------");
            System.out.println();

            System.out.print("Choose the action you want to take : ");
            int choice = input.nextInt();

            while (choice < 1 || choice > 3) {
                System.out.println("*******************************");
                System.out.println("Enter a valid number !");
                System.out.println("*******************************");
                System.out.print("Choose the action you want to take : ");
                choice = input.nextInt();
            }

            switch (choice) {
                case 1:
                    System.out.print("Loading weapons");
                    waiting();
                    showWeapons();
                    buyWeapon();
                    break;
                case 2:
                    System.out.print("Loading armours");
                    waiting();
                    showArmours();
                    buyArmour();
                    break;
                case 3:
                    System.out.println("Come again !");
                    System.out.print("Leaving the shop");
                    waiting();
                    showMenu = false;
                    break;
            }

        }
        return true;
    }

    public void showWeapons() {
        System.out.println();
        System.out.println("Weapons");
        System.out.println("----------------------------------------------");
        for (Weapons w : Weapons.weapons()) {
            System.out.println("| " + w.getId() + " - " + w.getName() +
                    " \t| Damage : " + w.getDamage() + " \t| Price : " + w.getPrice() + " |");
        }
        System.out.println("| 4 - Exit\t\t|");
        System.out.println("----------------------------------------------");
    }

    public void buyWeapon() {
        int playerMoney = this.getPlayer().getMoney();

        System.out.print("Select a weapon to purchase : ");
        int selectedID = input.nextInt();
        waitSec();

        while (selectedID < 1 || selectedID > Weapons.weapons().length + 1) {
            System.out.println("*******************************");
            System.out.println("Enter a valid number !");
            System.out.println("*******************************");
            System.out.print("Select a weapon to purchase : ");
            selectedID = input.nextInt();
            waitSec();
        }

        if (selectedID != 4) {
            Weapons selectedWeapon = Weapons.getWeaponObjById(selectedID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() <= this.getPlayer().getMoney()) {
                    System.out.println("--------------------------------");
                    System.out.println("Purchase successful !");
                    System.out.println("--------------------------------");

                    System.out.println("Your old weapon is : " + this.getPlayer().getInventory().getWeapons().getName());

                    this.getPlayer().getInventory().setWeapons(selectedWeapon); // sets player's new weapon

                    System.out.println("Your new weapon is : " + this.getPlayer().getInventory().getWeapons().getName());

                    System.out.println("--------------------------------");

                    this.getPlayer().setMoney(playerMoney - selectedWeapon.getPrice()); // sets player's money

                    System.out.println("Your current money = " + this.getPlayer().getMoney());

                } else {
                    System.out.println("*******************************");
                    System.out.println("You do not have enough money to buy this weapon !");
                    System.out.println("*******************************");
                }
            }
        }

    }

    public void showArmours() {
        System.out.println("Armours");
        System.out.println("----------------------------------------------");
        for (Armour a : Armour.armour()) {
            System.out.println("| " + a.getId() + " - " + a.getName() +
                    " \t| Block : " + a.getBlock() + " \t| Price : " + a.getPrice() + " |");
        }
        System.out.println("| 4 - Exit\t\t|");
        System.out.println("----------------------------------------------");
    }

    public void buyArmour() {
        int playerMoney = this.getPlayer().getMoney();

        System.out.print("Select an armour to purchase : ");
        int selectedID = input.nextInt();
        waitSec();

        while (selectedID < 1 || selectedID > Armour.armour().length + 1) {
            System.out.println("*******************************");
            System.out.println("Enter a valid number !");
            System.out.println("*******************************");
            System.out.print("Select an armour to purchase : ");
            selectedID = input.nextInt();
            waitSec();
        }

        if (selectedID != 4) {
            Armour selectedArmour = Armour.getArmourObjById(selectedID);

            if (selectedArmour != null) {
                if (selectedArmour.getPrice() <= this.getPlayer().getMoney()) {
                    System.out.println("--------------------------------");
                    System.out.println("Purchase successful !");
                    System.out.println("--------------------------------");

                    System.out.println("Your old armour is : " + this.getPlayer().getInventory().getArmour().getName());

                    this.getPlayer().getInventory().setArmour(selectedArmour); // set player's armour

                    System.out.println("Your new armour is : " + this.getPlayer().getInventory().getArmour().getName());

                    System.out.println("--------------------------------");

                    this.getPlayer().setMoney(playerMoney - selectedArmour.getPrice()); // set player's money

                    System.out.println("Your current money = " + this.getPlayer().getMoney());
                } else {
                    System.out.println("*******************************");
                    System.out.println("You do not have enough money to buy this armour !");
                    System.out.println("*******************************");
                }
            }
        }

    }
}
