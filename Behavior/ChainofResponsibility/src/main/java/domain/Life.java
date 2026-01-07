package domain;

/**
 * Life.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 04/01/2026
 */

public class Life {
    private final int DefaultLife = 100;
    private int actualLife = DefaultLife;

    public void receiveDamage(int damage){
        this.actualLife -=damage;
        System.out.println("The player lost " + damage + " of life");
        System.out.println("Actual life: " + actualLife);
    }

    public int getActualLife() {
        return actualLife;
    }

    public void reset(){
        this.actualLife = DefaultLife;
    }
}
