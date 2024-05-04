public class Shop extends NormalLoc{
    public Shop(Player player){
        super(player,"Shop");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are at the shop !");
        return true;
    }
}
