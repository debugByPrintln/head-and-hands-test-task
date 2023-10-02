package entity.attribute;

import utils.Randomizer;

public class Damage {
    private final int minDamage;

    private final int maxDamage;

    public Damage(int minDamage, int maxDamage) {
        if (minDamage > maxDamage){
            throw new IllegalArgumentException("Max damage must be greater than min damage.");
        }
        else {
            this.minDamage = minDamage;
            this.maxDamage = maxDamage;
        }
    }

    public int getDamage(){
        return Randomizer.getRandomInt(minDamage, maxDamage);
    }
}
