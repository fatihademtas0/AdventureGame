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

    public void checkReward() {
        String food = this.getPlayer().getInventory().getFood();
        String firewood = this.getPlayer().getInventory().getFirewood();
        String fish = this.getPlayer().getInventory().getFish();
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("Checking rewards");
        waiting();
        System.out.println("Cave's reward   : " + food);
        System.out.println("Forest's reward : " + firewood);
        System.out.println("River's reward  : " + fish);
        System.out.println("--------------------------");
    }

    public void checkReward2() {
        System.out.println(this.getPlayer().getInventory().getFood());
        System.out.println(this.getPlayer().getInventory().getFirewood());
        System.out.println(this.getPlayer().getInventory().getFish());

    }
}
