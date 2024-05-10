public class Inventory {
    private Weapons weapons;
    private Armour armour;
    private String food;
    private String firewood;
    private String fish;

    public Inventory() {
        this.weapons = new Weapons("Fist", 0, 0, 0);
        this.armour = new Armour("Shirt", 0, 0, 0);
        this.fish = "Empty";
        this.food = "Empty";
        this.firewood = "Empty";
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }

    public Armour getArmour() {
        return armour;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFirewood() {
        return firewood;
    }

    public void setFirewood(String firewood) {
        this.firewood = firewood;
    }

    public String getFish() {
        return fish;
    }

    public void setFish(String fish) {
        this.fish = fish;
    }
}
