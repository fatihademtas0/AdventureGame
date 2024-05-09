public abstract class Characters {
    private int id;
    private String charName;
    private int damage;
    private int health;
    private int money;

    public Characters(int id, String charName, int damage, int health, int money) {
        this.id = id;
        this.charName = charName;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    /*
        public static Characters[] characters() {
            Characters[] charactersList = new Characters[3];
            charactersList[0] = new Characters(1,  "Samurai", 5,21,15);
            charactersList[1] = new Characters(2, "Archer", 7, 18,20);
            charactersList[2] = new Characters(3, "Knight", 8, 24,5);

            return charactersList;
        }

     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
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

}
