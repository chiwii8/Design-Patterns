import domain.Enemy;
import domain.strategy.EasyLevel;
import domain.strategy.HardLevel;
import domain.strategy.LevelStrategy;
import domain.strategy.MediumLevel;

/**
 * Main.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 04/01/2026
 */

public class Main {
    public static void main(String [] args){
        ///Define variables
        Enemy enemy;
        Enemy enemy1;
        Enemy enemy2;
        LevelStrategy easy;
        LevelStrategy medium;
        LevelStrategy hard;

        ///Initialize variable
        enemy = new Enemy();
        enemy1 = new Enemy();
        enemy2 = new Enemy();

        easy = new EasyLevel();
        medium = new MediumLevel();
        hard = new HardLevel();

        enemy.setLevelStrategy(easy);
        enemy1.setLevelStrategy(medium);
        enemy2.setLevelStrategy(hard);


        enemy.move();
        enemy1.move();
        enemy2.move();

        ///Exchange the Levels
        enemy2.setLevelStrategy(easy);
        enemy1.setLevelStrategy(hard);
        enemy.setLevelStrategy(medium);


        enemy.move();
        enemy1.move();
        enemy2.move();


    }
}
