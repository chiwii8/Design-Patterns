package domain.chain;

/**
 * HandlerArmor.java
 * <p>
 * Description: This handler reduce the damage in half
 *
 * @author aleja
 * @since 04/01/2026
 */

public class HandlerArmor extends HandlerDamage{

    @Override
    public void processDamage(int damage) {
        int reduced = damage/2;
        System.out.println("The armor reduce the damage a " + reduced);

        if(handlerDamage!=null){
            handlerDamage.processDamage(reduced);
        }
    }
}
