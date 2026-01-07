package domain.chain;

/**
 * domain.chain.HandlerDamage.java
 * <p>
 * Description: Handler that pass the responsibility to the next handler if exists
 *
 * @author aleja
 * @since 04/01/2026
 */

abstract public class HandlerDamage {
    protected HandlerDamage handlerDamage;

    public void setFollow(HandlerDamage handlerDamage){
        this.handlerDamage = handlerDamage;
    }

    public abstract void processDamage(int damage);

}
