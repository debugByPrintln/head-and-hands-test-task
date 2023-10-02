package entity.play_item;

import utils.Randomizer;

public class Dice {
    private static final int minRoll = 1;

    private static final int maxRoll = 6;

    public static int rollDice(){
        return Randomizer.getRandomInt(minRoll, maxRoll);
    }
}
