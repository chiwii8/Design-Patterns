# Observer Pattern – Step by Step Example

When one object (the **Subject**) changes its state, all its dependents (the **Observers**) are notified automatically.

This pattern is commonly used in:

- Event systems  
- GUI updates  
- Game state notifications  

---

## 🎯 Use Case

Imagine we are developing a game.

We have:

- 🎮 `Player` (Subject)
- 🖥️ `HUD` (Observer)
- 🔊 `SoundSystem` (Observer)

When the player's health changes:

- The HUD must update the health bar
- The SoundSystem must play a state of the player state.

### 1️⃣ Step 1: Create the Observer Interface
```java
public interface Observer {
    void update(int life);
}
```

### 2️⃣ Step 2: Implement the Player (Concrete Subject)

```java
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
```

### 3️⃣ Step 3: Implement Concrete Observers

```java
public class HUD implements Observer{
    @Override
    public void update(int life) {
        System.out.println("HUD: actual life: " + life);
    }
}

public class Sound implements Observer{
    @Override
    public void update(int life) {
        if(life>50)
            System.out.println("I'm ready for more");
        else if(life>0)
            System.out.println("I need to finish quick this battle");
        else
            System.out.println("How can i lose?");
    }
}

```

### 4️⃣ Step 4: Use the Observer Pattern


```java
public class Main {
    public static void main(String [] args){
        ///Define variables
        Observer sound;
        Observer hud;
        Player player;

        ///Initialize variables
        sound = new Sound();
        hud = new HUD();
        player = new Player();

        player.addObserver(hud);
        player.addObserver(sound);

        player.receiveDamage(35);
        player.receiveDamage(40);
        player.receiveDamage(30);

        player.receiveDamage(100);
    }
}
```

### 🔍 When to Use Observer

* Multiple objects depend on one object’s state

* You want automatic event notification

* You want loose coupling between components

* You are building event-driven systems

### 💡 Summary

* **Purpose**: Notify multiple objects when state changes.

* **Benefits**: Loose coupling, scalable event systems.

* **Typical Use Cases**: UI updates, event listeners, game state systems.

* **Key Idea**: Observers subscribe and react automatically to changes.