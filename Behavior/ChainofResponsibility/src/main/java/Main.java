import domain.chain.HandlerArmor;
import domain.chain.HandlerDamage;
import domain.chain.HandlerLife;
import domain.chain.HandlerShield;

/**
 * Main.java
 * <p>
 * Description: This is an example using a Different handlers to do Design pattern of Chain of Responsibility to reduce the life of a player in a videogame
 *
 * @author aleja
 * @since 04/01/2026
 */

public class Main {
    public static void main(String [] args){
        ///Define variables
        HandlerDamage life;
        HandlerDamage armor;
        HandlerDamage shield;
        int damage = 50;

        shield = new HandlerShield();
        armor = new HandlerArmor();
        life = new HandlerLife();

        shield.setFollow(armor);
        armor.setFollow(life);

        shield.processDamage(damage);

    }
}
