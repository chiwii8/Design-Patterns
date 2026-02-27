# Flyweight Pattern – Step by Step Example

The Flyweight pattern is a **structural design pattern** that allows you to **reduce memory usage** by sharing common state between multiple objects instead of duplicating it.

It is especially useful when your application needs to create **a large number of similar objects**, such as enemies in a video game.

---

## 🎯 Use Case

Imagine we are developing a video game with **thousands of enemies** on screen.

Each enemy has:

- A `position` (x, y)
- A `currentHealth`

But many enemies share the same:

- `name` (Orc, Goblin, Dragon)
- `sound`

Instead of storing repeated data in every enemy instance, we can separate:

- **Intrinsic state (shared)** → type, sound 
- **Extrinsic state (unique per instance)** → position, currentHealth  

Using the Flyweight pattern, all enemies of the same type will **share the same intrinsic data**.

---

## 🛠️ Step-by-Step Explanation

---

### 1️⃣ Step 1: Create the Flyweight Interface

```java
public class TypeEnemy {
    ///Reference to the species
    private String name;
    private String sound;

    public TypeEnemy(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
```

* This class contains the shared state

* These values are provided at runtime

### 2️⃣ Step 2: Create the Factory
```java
public class TypeEnemy {
    ///Reference to the species
    private String name;
    private String sound;

    public TypeEnemy(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
```

* Ensure that enemy types are shared.
* Crates a new ``EnemyType`` only if it does not already exists
* Reuses existing instances

### 3️⃣ Step 3: Create the Context (Unique State)

```java
public class Enemy {
    ///Define the position of the enemy
    private final int defaultLife = 100;
    private int x;
    private int y;
    private int life;
    private TypeEnemy typeEnemy;

    public Enemy(int x, int y, TypeEnemy typeEnemy) {
        this.x = x;
        this.y = y;
        this.typeEnemy = typeEnemy;
        this.life = this.defaultLife;
    }

    public void render(){
        System.out.println("Apperared a new " + typeEnemy.getName() + " " + typeEnemy.getSound());
        System.out.println("Enemy in position [ " + this.x + ", " + this.y + "] with life " + this.life);
    }
}
```

* Store the extrinsic (unique) state.

### 4️⃣  Step 4: Use the Flyweight
```java
public class Main {
    public static void main(String [] args) {
        ///Define variables
        TypeEnemy typeEnemy;
        Enemy enemy, enemy1, enemy2;


        ///Initialize variables
        typeEnemy = EnemyFactory.getEnemyType("MutantDog", "Grrrr");
        enemy = new Enemy(10, 3, typeEnemy);
        enemy1 = new Enemy(20, 3, typeEnemy);
        enemy2 = new Enemy(0, 0, typeEnemy);

        enemy.render();
        enemy1.render();
        enemy2.render();
    }
}
```

* All three enemies share the same EnemyType.

* Only position and health differ.

* Memory usage is reduced significantly when many enemies exist.

### 🔍 When to Use Flyweight

* You need to create many similar objects

* Many objects share common data

* Memory optimization is important

* Object creation is expensive

### 💡 Summary

* **Purpose**: Share common state between multiple objects.

* **Benefits**: Reduced memory usage, improved scalability.

* **Typical Use Cases**: Game enemies, particles, bullets, trees in a forest.

* **Key Idea**: Separate shared (intrinsic) state from unique (extrinsic) state.