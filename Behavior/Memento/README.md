# Memento Pattern – Step by Step Example

The **Memento pattern** is a **behavioral design pattern** that allows you to capture and restore an object's internal state **without exposing its internal structure**.

It is commonly used to implement:

- 💾 Save systems
- ↩️ Undo/Redo functionality
- 🔄 State restoration

---

## 🎯 Use Case

Imagine we are developing a game and we want to implement a **Save Game** system.

The game must be able to:

- Save the current state of the player
- Restore the game later from that saved state

The player has:

- ❤️ Health
- 🎒 Level

We want to save and restore this state **without exposing the internal structure of the Player class**.

This is where the **Memento pattern** fits perfectly.

---

## 🛠️ Step-by-Step Explanation

The pattern has three main roles:

- **Originator** → The object whose state we want to save (`Player`)
- **Memento** → The object that stores the saved state
- **Caretaker** → The object that manages saved states (`SaveStore`)

---

## 1️⃣ Step 1: Create the Memento

```java
public class MementoPlayer {


    private int life;
    private int level;

    public MementoPlayer(int life, int level) {
        this.life = life;
        this.level = level;
    }

    public int getLife() {
        return life;
    }

    public int getLevel() {
        return level;
    }
}
```

* Store a snapshot of the Player's state.
* It is immutable.

### 2️⃣ Step 2: Create the Originator (Player)

```java
public class Player {
    private final int initLevel = 1;
    private final int defaultLife =100;

    private int life;
    private int level;

    public Player() {
        this.life = this.defaultLife;
        this.level = this.initLevel;
    }

    public Player(int life, int level) {
        this.life = life;
        this.level = level;
    }

    public void showStatus(){
        System.out.println("Player - Life: " + life + ", Level: " + level);
    }


    public void receiveDamage(int damage){
        this.life-=damage;
    }

    public void levelup(){
        this.level++;
    }


    public MementoPlayer save(){
        return new MementoPlayer(life,level);
    }

    public void load(MementoPlayer mementoPlayer){
        this.life = mementoPlayer.getLife();
        this.level = mementoPlayer.getLevel();
    }
}
```

* save() creates a snapshot.

* load() restores a previous state.

* The Player does not expose its internal structure.

### 3️⃣ Step 3: Create the Caretaker (Save Manager)

```java
public class SaveStore {
    private Stack<MementoPlayer>  history = new Stack<>();

    public void save(MementoPlayer mementoPlayer){
        this.history.add(mementoPlayer);
    }

    public MementoPlayer undo(){
        if(!this.history.empty())
            return this.history.pop();
        return null;
    }
}
```

* Manages saved states.

* Does not modify or inspect mementos.

* Simply stores and retrieves them.

### 4️⃣ Step 4: Use the Memento Pattern

```java
public class Main {
    public static void main(String [] args){
        Player player = new Player();
        SaveStore saveStore = new SaveStore();

        player.showStatus();

        saveStore.save(player.save());

        player.receiveDamage(30);
        player.levelup();
        player.showStatus();


        player.load(saveStore.undo());
        player.showStatus();
    }
}
```

### 🔍 When to Use Memento

* You need save/load functionality

* You need undo/redo operations

* You want to restore object state safely

* You want to preserve encapsulation

### 💡 Summary

* **Purpose**: Capture and restore an object's internal state.

* **Benefits**: Encapsulation, clean undo/save systems.

* **Typical Use Cases**: Save games, text editors, configuration backups.

* **Key Idea**: Store snapshots of an object’s state without exposing its internals.

    