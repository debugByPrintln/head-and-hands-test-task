package entity;

import entity.attribute.Damage;
import entity.play_item.Dice;

public abstract class Creature {
    private final int attack;

    private final int defense;

    private final int maxHealth;

    private int currentHealth;

    private final Damage damage;

    public Creature(int attack, int defense, int maxHealth, int minDamage, int maxDamage) {
        if (attack < 1 || attack > 30){
            throw new IllegalArgumentException("Attack must be in range of [1; 30].");
        }
        if (defense < 1 || defense > 30){
            throw new IllegalArgumentException("Defense must be in range of [1; 30].");
        }
        if (maxHealth <= 0){
            throw new IllegalArgumentException("Initial health must be greater than 0.");
        }
        this.attack = attack;
        this.defense = defense;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.damage = new Damage(minDamage, maxDamage);
    }

    public void attack(Creature target){
        if (getCurrentHealth() <= 0){
            System.out.println("This creature can't attack because it's dead!");
            return;
        }

        if (target.getCurrentHealth() <= 0){
            System.out.println("Target is already dead!");
            return;
        }

        int attackMod = getAttackModifier(target);
        boolean hit = false;

        for (int i = 0; i < attackMod; i++) {
            int rolled = Dice.rollDice();

            if (rolled >= 5){
                hit = true;
                break;
            }
        }

        if (hit){
            int hitDmg = this.damage.getDamage();
            target.setCurrentHealth(target.getCurrentHealth() - hitDmg);
            System.out.println("Hit! Damage was: " + hitDmg);
            if (target.getCurrentHealth() <= 0){
                System.out.println("Target has died!");
                target.setCurrentHealth(0);
            }
        }
        else {
            System.out.println("Miss!");
        }
    }


    private int getAttackModifier(Creature target){
        int attackMod = this.attack - target.getDefense() + 1;

        return Math.max(attackMod, 1);
    }

    public void setCurrentHealth(int value){
        this.currentHealth = value;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public Damage getDamage() {
        return damage;
    }
}
