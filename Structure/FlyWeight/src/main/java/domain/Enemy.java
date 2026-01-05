package domain;

/**
 * Enemy.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 03/01/2026
 */

public class Enemy {
    ///Define the position of the enemy
    private final int defaultLife = 100;
    private int x;
    private int y;
    private int life;
    private TypeEnemy typeEnemy;

    public Enemy(int x, int y, TypeEnemy typeEnemy) {
        this.x = x;
        this.y = y;
        this.typeEnemy = typeEnemy;
        this.life = this.defaultLife;
    }

    public void render(){
        System.out.println("Apperared a new " + typeEnemy.getName() + " " + typeEnemy.getSound());
        System.out.println("Enemy in position [ " + this.x + ", " + this.y + "] with life " + this.life);
    }
}
