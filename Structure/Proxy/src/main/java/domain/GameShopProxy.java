package domain;

/**
 * GameShopProxy.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 03/01/2026
 */

public class GameShopProxy implements Shop{
    private GameShop realShop;
    private double buyerMoney;

    public GameShopProxy(double buyerMoney) {
        this.buyerMoney = buyerMoney;
    }

    @Override
    public void buy(String item, double price) {
        if(buyerMoney>=price){
            realShop = new GameShop();
            realShop.buy(item,price);
            buyerMoney-=price;
            System.out.println("The player has " + buyerMoney + " left");
        }
        else
            System.out.println("You dont have enough money to buy that item");
    }
}
