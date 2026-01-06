package domain;

import domain.strategy.LevelStrategy;

/**
 * Enemy.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 04/01/2026
 */

public class Enemy implements MovementStrategy{
    private LevelStrategy levelStrategy;

    public Enemy(LevelStrategy levelStrategy) {
        this.levelStrategy = levelStrategy;
    }

    public Enemy(){

    }

    public void setLevelStrategy(LevelStrategy levelStrategy) {
        this.levelStrategy = levelStrategy;
    }

    @Override
    public void move() {
        levelStrategy.move();
    }
}
