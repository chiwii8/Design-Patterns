# Mediator Pattern – Step by Step Example

Instead of objects communicating directly with each other, they communicate through a **Mediator**, reducing coupling and making the system easier to maintain.

---

## 🎯 Use Case

Imagine we are developing a simple combat system in a game.

We only have:

- 🎮 `Player`
- 👾 `Enemy`

When one attacks the other:

- Combat messages must be shown

Instead of making `Player` directly modify `Enemy` (and vice versa), we introduce a **CombatMediator** that manages all attack interactions.

This keeps both classes decoupled and makes the combat logic centralized.

---

## 🛠️ Step-by-Step Explanation

---

## 1️⃣ Step 1: Create the Mediator Interface

```java
public interface Mediator {
    void notify(String event);
}
```

### 2️⃣ Step 2: Create Entities

```java
public class Enemy {
    Mediator mediator;

    public Enemy(Mediator mediator) {
        this.mediator = mediator;
    }

    public void receiveAttack(){
        System.out.println("The enemy receive damage");
        mediator.notify("ENEMY_DAMAGED");
    }
}

public class Player {
    Mediator mediator;

    public Player(Mediator mediator) {
        this.mediator = mediator;
    }

    public void Attack(){
        System.out.println("Player attack");
        this.mediator.notify("PLAYER_ATTACK");
    }
}
```

### 3️⃣ Step 3: Implement the Concrete Mediator

```java

public class Sound {

    public void reproduce(){
        System.out.println("Slashhh");
    }
}

public class ResultAttack {

    public void result(){
        System.out.println("The enemy is defeat");
    }
}

public class MediatorGame implements Mediator{
    private Sound sound;
    private ResultAttack resultAttack;
    public MediatorGame(Sound sound, ResultAttack resultAttack) {
        this.sound = sound;
        this.resultAttack = resultAttack;
    }

    @Override
    public void notify(String event) {
        if(event.equalsIgnoreCase("PLAYER_ATTACK")){
            sound.reproduce();
        }else if(event.equalsIgnoreCase("ENEMY_DAMAGED"))
            this.resultAttack.result();
    }
}
```

### 4️⃣ Step 4: Use the Mediator
```java
public class Main {

    public static void main(String [] args){
        Sound sound = new Sound();
        ResultAttack resultAttack = new ResultAttack();

        Mediator mediatorGame = new MediatorGame(sound,resultAttack);

        Player player = new Player(mediatorGame);
        Enemy enemy = new Enemy(mediatorGame);

        player.Attack();
        enemy.receiveAttack();
    }
}
```

### 🔍 When to Use Mediator

* Objects interact frequently

* Interaction logic becomes complex

* You want to reduce tight coupling

* You want centralized control of behavior

### 💡 Summary

* Purpose: Centralize communication between objects.

* **Benefits**: Loose coupling, better organization, easier extension.

* **Typical Use Cases**: Game combat systems, chat rooms, GUI component communication.

* **Key Idea**: Objects communicate through a mediator instead of directly.