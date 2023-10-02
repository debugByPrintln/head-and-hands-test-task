import entity.Monster;
import entity.Player;

public class AppRunner {
    public static void main(String[] args) {
        Player player = new Player(25, 5, 100, 10, 20);
        Monster monster = new Monster(30, 30, 50, 40, 70);

        System.out.println("Player attacks monster!");
        player.attack(monster);
        System.out.println("Monster current health is: " + monster.getCurrentHealth() + "\n");

        System.out.println("Monster attacks player!");
        monster.attack(player);
        System.out.println("Player current health is: " + player.getCurrentHealth() + "\n");

        System.out.println("Player use heal!");
        player.selfHeal();
        System.out.println("Player current health is: " + player.getCurrentHealth() + "\n");

        System.out.println("Player attacks monster!");
        player.attack(monster);
        System.out.println("Monster current health is: " + monster.getCurrentHealth() + "\n");
    }
}


