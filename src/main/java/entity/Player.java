package entity;

public class Player extends Creature {
    private int healsCounter = 4;

    public Player(int attack, int defense, int maxHealth, int minDamage, int maxDamage) {
        super(attack, defense, maxHealth, minDamage, maxDamage);
    }

    public void selfHeal(){
        if (healsCounter > 0){
            int healAmount = (int) (0.3 * getMaxHealth());

            if ((healAmount + getCurrentHealth()) > getMaxHealth()){
                healsCounter--;
                setCurrentHealth(getMaxHealth());
            }
            else{
                healsCounter--;
                setCurrentHealth((healAmount + getCurrentHealth()));
            }
            System.out.println("Player has used heal! His current health is: " + getCurrentHealth());
        }
        else{
            System.out.println("Player can't heal anymore!");
        }

    }
}
