package domain.chain;

import java.time.Instant;
import java.util.Random;


/**
 * Shield.java
 * <p>
 * Description: This handler reduce the damage receive depends on the defense realize
 *
 * @author aleja
 * @since 04/01/2026
 */

public class HandlerShield extends HandlerDamage{

    private Random random;

    public HandlerShield(){
        this.random = new Random();
        random.setSeed(Instant.now().getEpochSecond());
    }

    @Override
    public void processDamage(int damage) {

        int defended = random.nextInt(0,10);

        if(defended==0){
            System.out.println("The player failed to defend");
        }else{
            System.out.println("Defended:" + defended);
            damage -= (int)(((double)defended/10)*damage);
            System.out.println("The player Sucessfully reduce the damage, The damage recieve is " + damage);
        }

        if(damage > 0 && handlerDamage != null){
            handlerDamage.processDamage(damage);
        }

    }
}
