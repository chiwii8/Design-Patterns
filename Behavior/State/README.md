# State Pattern – Step by Step Example
It is commonly used when:

- An object must behave differently depending on its state
- State transitions happen at runtime
- You want to avoid large conditional statements

---

## 🎯 Use Case

Imagine a game character that can have different statuses:

- 🙂 **Normal**
- ☠️ **Poisoned**
- 💀 **Defeated**

Depending on the state:

- The character may lose health over time (poisoned)
- The character may be unable to attack (defeated)
- The character behaves normally otherwise

We want to encapsulate each state and avoid messy `if-else` logic in the `Player` class.

---

## 🛠️ Step-by-Step Explanation

---

## 1️⃣ Step 1: Create the State Interface

```java
public interface PlayerStatus {
    void receiveDamage(Player player, int damage);
}
```

## 2️⃣ Step 2: Implement Concrete States
```java
public class NormalState implements PlayerStatus{

    @Override
    public void receiveDamage(Player player, int damage) {
        player.setLife(player.getLife()-damage);
        System.out.println("The player receive " + damage + " of damage");

        if(player.getLife() <=0){
            player.setStatus(new DefeatedStatus());
            System.out.println("The player is defeated");
        }
    }
}

public class DefeatedStatus implements PlayerStatus{

    @Override
    public void receiveDamage(Player player, int damage) {
        System.out.println("The player is defeated. Cant do nothing");
    }
}

public class PoisonStatus implements PlayerStatus{
    @Override
    public void receiveDamage(Player player, int damage) {
        int posionDamage = 5; ///Const damage
        int actuallife = player.getLife() - damage - posionDamage;
        System.out.println("The player receive " + damage + " of damage");
        System.out.println("The poisoned player receive " + posionDamage + " of poison damage");

        player.setLife(actuallife);

        if(actuallife<=0){
            player.setStatus(new DefeatedStatus());
            System.out.println("Player defeated");
        }
    }
}

```
## 3️⃣ Step 3: Create the Context (Player)

```java
public class Player {
    private final int defaultLife = 100;
    private PlayerStatus status;
    private int life;

    public Player() {
        status = new NormalState();
        this.life = defaultLife;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void receiveDamage(int damage){
        status.receiveDamage(this,damage);
    }
}

```

## 4️⃣ Step 4: Use the State Pattern
```java
public class Main {
    public static void main(String [] args){

        Player player = new Player();

        player.receiveDamage(20);

        //Chage manual status
        player.setStatus(new PoisonStatus());
        player.receiveDamage(40);

        player.receiveDamage(50);
    }
}
```

### 🔍 When to Use State

* An object’s behavior depends on its state

* The object must change behavior at runtime

* You want to avoid large conditional statements

* You want each state to encapsulate its own behavior

### 💡 Summary

* **Purpose**: Allow an object to change its behavior when its internal state changes.

* **Benefits**: Clean code, encapsulated behavior, easier maintenance.

* **Typical Use Cases**: Game character statuses, TCP connection states, workflow systems.

* **Key Idea**: Represent state as separate classes and delegate behavior to them.