package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Player.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 04/01/2026
 */

public class Player {
    private final int startedLife=100;
    private int life = startedLife;
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }


    public void receiveDamage(int damage){
        if(life<=0){
            System.out.println("I cant continue fighting");
        }else {
            life -= damage;
            notifyLife();
        }
    }

    public void reset(){
        this.life = startedLife;
    }

    private void notifyLife(){
        for (Observer o : this.observers )
            o.update(this.life);
    }
}
