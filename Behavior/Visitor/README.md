# Visitor Pattern - Step by Step Example

## 🎯 Use Case

Imagine we have a game with a Character and an Enemy.

Both can exchange damage, and we want to separate the attack logic from the character and enemy classes.

Using the Visitor Pattern, we can:

* 🟢 Apply damage from a player attack to a Character

* 🟡 Apply damage from an enemy attack to the player

## 🛠️ Step-by-Step Explanation

## 1️⃣ Step 1: Create the Element Interface

```java
public interface Entity {
    void accept(Visitor visitor);
}

```

## 2️⃣ Step 2: Implement Concrete Elements

```java

public class Enemy implements Entity{
    @Override
    public void accept(Visitor visitor) {
        visitor.visitEnemy(this);
    }

    public int getStrength(){
        return 30;
    }
}

public class Player implements Entity {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitPlayer(this);
    }

    public int getlife(){
        return 100;
    }
}
```

## 3️⃣ Step 3: Create the Visitor Interface

```java
public interface Visitor {
    void visitPlayer(Player player);
    void visitEnemy(Enemy enemy);
}
```


## 4️⃣ Step 4: Implement a Concrete Visitor

```java
public class VisitorDamage implements Visitor{


    @Override
    public void visitPlayer(Player player) {
        System.out.println("Calculating damage to the player with life " + player.getlife());
    }

    @Override
    public void visitEnemy(Enemy enemy) {
        System.out.println("Calculating damage from the enemy with strength " + enemy.getStrength());
    }
}
```

## 5️⃣ Step 5: Use the Visitor Pattern

```java
public class Main {
    public static void main(String [] args){

        Entity player = new Player();
        Entity enemy = new Enemy();

        VisitorDamage visitorDamage = new VisitorDamage();

        player.accept(visitorDamage);
        enemy.accept(visitorDamage);
    }
}
```

### 🔍 When to Use Visitor

* You want to perform operations on a set of objects without modifying their classes

* You want to add new operations easily in the future

* You want double dispatch (behavior depends on both the visitor and the object type)

* You want to separate concerns between data and operations

### 💡 Summary

* **Purpose**: Separate operations from the objects they act on.

* **Benefits**: Open/closed principle, easy to add new operations, cleaner code.

* **Typical Use Cases**: Game interactions, AST processing, file system traversal, UI rendering.

* **Key Idea**: Use a visitor to operate on elements without modifying the element classes.