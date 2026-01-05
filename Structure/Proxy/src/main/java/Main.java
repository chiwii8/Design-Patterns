import domain.GameShopProxy;

/**
 * Main.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 03/01/2026
 */

public class Main {
    public static void main(String [] args){
        ///Define variables
        GameShopProxy gameShopProxy;
        double playerMoney;

        ///Initialize variables
        playerMoney = 20;
        gameShopProxy = new GameShopProxy(playerMoney);

        ///Buy
        gameShopProxy.buy("Wood",15);

    }
}
