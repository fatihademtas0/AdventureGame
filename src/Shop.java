public class Shop extends NormalLoc {
    public Shop(Player player) {
        super(player, "Shop");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the shop !");
        System.out.println();
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
            System.out.print("Choose the action you want to take : ");
            choice = input.nextInt();
        }

        switch (choice) {
            case 1:
                showWeapons();
                break;
            case 2:
                showArmours();
                break;
            case 3:
                System.out.println("Come again !");
                break;
            default:
                System.out.println();

        }
        return true;
    }

    public void showWeapons() {
        System.out.println();
        System.out.println("Weapons");
        System.out.println("----------------------------------------------");
        for (Weapons w : Weapons.weapons()) {
            System.out.println("| " + w.getId() + " - " + w.getName() + " \t| Damage : " + w.getDamage() + " \t| Price : " + w.getPrice() + " |");
        }
        System.out.println("----------------------------------------------");
    }

    public void buyWeapon() {
        System.out.print("Select an weapon to purchase : ");
        int selectedID = input.nextInt();

        while (selectedID < 1 || selectedID > Weapons.weapons().length) {
            System.out.println("*******************************");
            System.out.println("Enter a valid number !");
            System.out.print("Select an weapon to purchase : ");
            selectedID = input.nextInt();
        }

        Weapons selectedWeapon = Weapons.getWeaponObjById(selectedID);

        if (selectedWeapon != null) {
            if (selectedWeapon.getPrice() <= this.getPlayer().getMoney()) {
                System.out.println("*******************************");
                System.out.println("Purchase successful !");
            } else {
                System.out.println("*******************************");
                System.out.println("You do not have enough money to buy this weapon !");
            }
        }
    }

    public void showArmours() {
        System.out.println("Armours");
    }
}
