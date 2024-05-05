public class Inventory {
    private Weapons weapons;
    private Armour armour;

    public Inventory(){
        this.weapons = new Weapons("Fist",0,0,0);
        this.armour = new Armour("Shirt",0,0,0);
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
}
