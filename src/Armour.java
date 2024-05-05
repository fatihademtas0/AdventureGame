public class Armour {
    private String name;
    private int id;
    private int block;
    private int price;

    public Armour(String name, int id, int block, int price) {
        this.name = name;
        this.id = id;
        this.block = block;
        this.price = price;
    }

    public static Armour[] armour() {
        Armour[] armourList = new Armour[3];
        armourList[0] = new Armour("Light", 1, 1, 25);
        armourList[1] = new Armour("Medium", 2, 3, 35);
        armourList[2] = new Armour("Heavy", 3, 5, 45);

        return armourList;
    }

    public static Armour getArmourObjById(int id) {
        for (Armour w : Armour.armour()) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
