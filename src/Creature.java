public class Creature {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int loot;
    private String reward;
    private int defaulHealth;

    public Creature(int id, String name, int damage, int health, int loot) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.defaulHealth = health;
        this.loot = loot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }

    public int getDefaulHealth() {
        return defaulHealth;
    }

    public void setDefaulHealth(int defaulHealth) {
        this.defaulHealth = defaulHealth;
    }

}


