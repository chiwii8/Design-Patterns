# Strategy Pattern – Step by Step Example

This pattern is commonly used when:

- You have multiple ways of performing an operation  
- You want to switch algorithms at runtime  
- You want to avoid conditional statements for different behaviors

---

## 🎯 Use Case

Imagine we have a game with an `Enemy` character.

The enemy can move differently depending on the **difficulty level**:

- 🟢 **Easy** → Line movements  
- 🟡 **Medium** → Zig Zag movement
- 🔴 **Hard** → movement with prediction of your movement  

We want to **encapsulate each movement behavior** and switch it dynamically based on the difficulty level.

---

## 🛠️ Step-by-Step Explanation

---

## 1️⃣ Step 1: Create the Strategy Interface

```java
public interface MovementStrategy {
    void move();
}
```

## 2️⃣ Step 2: Implement Concrete Strategies

```java
public class EasyLevel extends LevelStrategy{
    @Override
    public void move() {
        System.out.println("The enemy move always in line");
    }
}

public class MediumLevel extends LevelStrategy{
    @Override
    public void move() {
        System.out.println("The enemy move in zigzag");
    }
}

public class HardLevel extends LevelStrategy{
    @Override
    public void move() {
        System.out.println("The enemy move doing predictions of your attacks");
    }
}

```

## 3️⃣ Step 3: Create the Context (Enemy)

```java
public class Enemy implements MovementStrategy{
    private LevelStrategy levelStrategy;

    public Enemy(LevelStrategy levelStrategy) {
        this.levelStrategy = levelStrategy;
    }

    public Enemy(){

    }

    public void setLevelStrategy(LevelStrategy levelStrategy) {
        this.levelStrategy = levelStrategy;
    }

    @Override
    public void move() {
        levelStrategy.move();
    }
}
```

## 4️⃣ Step 4: Use the Strategy Pattern

```java
public class Main {
    public static void main(String [] args){
        ///Define variables
        Enemy enemy;
        Enemy enemy1;
        Enemy enemy2;
        LevelStrategy easy;
        LevelStrategy medium;
        LevelStrategy hard;

        ///Initialize variable
        enemy = new Enemy();
        enemy1 = new Enemy();
        enemy2 = new Enemy();

        easy = new EasyLevel();
        medium = new MediumLevel();
        hard = new HardLevel();

        enemy.setLevelStrategy(easy);
        enemy1.setLevelStrategy(medium);
        enemy2.setLevelStrategy(hard);


        enemy.move();
        enemy1.move();
        enemy2.move();

        ///Exchange the Levels
        enemy2.setLevelStrategy(easy);
        enemy1.setLevelStrategy(hard);
        enemy.setLevelStrategy(medium);


        enemy.move();
        enemy1.move();
        enemy2.move();


    }
}
```

### 🔍 When to Use Strategy

* You have multiple algorithms for a task

* You want to switch behavior dynamically

* You want to avoid long if-else or switch statements

* You want to encapsulate algorithm logic

### 💡 Summary

* **Purpose**: Encapsulate interchangeable behaviors and delegate execution.

* **Benefits**: Flexibility, clean code, easier maintenance, open/closed principle.

* **Typical Use Cases**: Game AI, sorting algorithms, payment methods, compression strategies.

* **Key Idea**: Use composition to assign behaviors dynamically instead of using conditionals.