package domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Enemy.java
 * <p>
 * Description: This factory Pattern ensure that create the enemy types and create if it does not already exist. 
 *
 * @author aleja
 * @since 27/02/2026
 */


public class EnemyFactory{

    private static final Map<String,TypeEnemy> enemyTypes = new HashMap<>();

        private EnemyFactory() throws IllegalAccessException {
            throw new IllegalAccessException("Factory class");
        }
    public static TypeEnemy getEnemyType( String type,
                                             String sound
                                             ){

        TypeEnemy newEnemyType = new TypeEnemy(type,sound);

        /// This method add the new TypeEnemy if not exists, in other case don't compute the operation
        enemyTypes.putIfAbsent(type, newEnemyType);

        return enemyTypes.get(type);
    }
}