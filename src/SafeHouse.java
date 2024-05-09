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
        return true;
    }

    public void recover() {
        this.getPlayer().setHealth(this.getPlayer().getDefaultHealth());
    }
}
