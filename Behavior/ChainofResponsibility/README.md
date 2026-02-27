# Chain of Responsibility Pattern – Step by Step Example

The Chain of Responsibility pattern is a **behavioral design pattern** that allows a request to be passed along a chain of handlers until it is processed.

Each handler:

- Receives the request
- Processes part of it (if applicable)
- Passes the remaining request to the next handler

This pattern helps decouple the sender of a request from its receivers.

---

## 🎯 Use Case

Imagine we are developing a video game combat system.

When a character receives damage, multiple defensive systems may reduce it:

- 🛡️ `Shield` absorbs damage first  
- 🪖 `Armor` reduces part of the remaining damage  
- ❤️ `Health` loses the final remaining damage  

We want to process damage in a **specific order**, without hardcoding all logic into a single class.

The Chain of Responsibility pattern allows each defense system to handle part of the damage and pass the rest along the chain.

---

## 🛠️ Step-by-Step Explanation

---

### 1️⃣ Step 1: Create the Abstract Handler

```java
abstract public class HandlerDamage {
    protected HandlerDamage handlerDamage;

    public void setFollow(HandlerDamage handlerDamage){
        this.handlerDamage = handlerDamage;
    }

    public abstract void processDamage(int damage);

}
```

* Define the structure of the chain
* Each handler can forward the request to the next one

### 2️⃣ Step 2: Implement Concrete Handlers

```java
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

public class HandlerLife extends HandlerDamage{

    private Life life;

    public HandlerLife() {
        this.life = new Life();
    }

    @Override
    public void processDamage(int damage) {
        this.life.receiveDamage(damage);
    }
}
```

### 3️⃣ Step 3: Build the Chain

```java
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
```

### 🔍 When to Use Chain of Responsibility

* Multiple objects can handle a request

* The exact handler is not known in advance

* You want to avoid large conditional logic

* You want flexible and dynamic request processing chains

### 💡 Summary

* **Purpose**: Pass a request along a chain of handlers.

* **Benefits**: Loose coupling, flexible processing order, clean separation of responsibilities.

* **Typical Use Cases**: Logging systems, validation pipelines, middleware, game combat systems.

* **Key Idea**: Each handler processes part of the request and passes the rest forward.