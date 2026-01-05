import domain.Enemy;
import domain.TypeEnemy;

/**
 * Main.java
 * <p>
 * Description: Example
 *
 * @author aleja
 * @since 03/01/2026
 */

public class Main {
    public static void main(String [] args) {
        ///Define variables
        TypeEnemy typeEnemy;
        Enemy enemy, enemy1, enemy2;


        ///Initialize variables
        typeEnemy = new TypeEnemy("MutantDog", "Grrrr");
        enemy = new Enemy(10, 3, typeEnemy);
        enemy1 = new Enemy(20, 3, typeEnemy);
        enemy2 = new Enemy(0, 0, typeEnemy);

        enemy.render();
        enemy1.render();
        enemy2.render();
    }
}
