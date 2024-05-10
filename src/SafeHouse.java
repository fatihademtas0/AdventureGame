public class SafeHouse extends NormalLoc {
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the Safe House !");
        recover();
        waitSec();
        System.out.println("Your health has been recovered !");
        checkReward();
        return true;
    }

    public void recover() {
        this.getPlayer().setHealth(this.getPlayer().getDefaultHealth());
    }

    public void checkReward(){
        System.out.println(this.getPlayer().getInventory().getFood());
        System.out.println(this.getPlayer().getInventory().getFirewood());
        System.out.println(this.getPlayer().getInventory().getFish());

    }
}
