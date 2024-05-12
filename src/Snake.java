import java.util.Random;

public class Snake extends Creature {
    private static Random random = new Random();

    public Snake() {
        super(4, "Snake", createRandomDamageSnake(), 12, createRandomLootNumber());
    }

    public static int createRandomDamageSnake() {


        int min = 3;
        int max = 6;
        return random.nextInt(max - min + 1) + min;
    }

    public static int createRandomLootNumber() {
        int min = 1;
        int max = 1000;
        int randomItem = random.nextInt(max - min + 1) + min;
        //int randomItem2 = random.nextInt(max - min + 1) + min;
        return randomItem;
    }
}

