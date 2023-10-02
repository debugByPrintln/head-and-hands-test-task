package entity.attribute;

import utils.Randomizer;

public class Damage {
    private final int minDamage;

    private final int maxDamage;

    public Damage(int minDamage, int maxDamage) {
        if(minDamage < 0 || maxDamage < 0){
            throw new IllegalArgumentException("Damage can't be a negative integer.");
        }
        if (minDamage > maxDamage){
            this.minDamage = maxDamage;
            this.maxDamage = minDamage;
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
