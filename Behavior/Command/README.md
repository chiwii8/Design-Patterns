# Command Pattern – Step by Step Example

The Command pattern is a **behavioral design pattern** that turns a request into a standalone object containing all the information needed to perform an action.

This pattern allows you to:

- Parameterize objects with actions
- Queue or log requests
- Support undo/redo operations
- Decouple the sender from the receiver

---

## 🎯 Use Case

Imagine we are developing a video game.

The player can perform actions such as:

- 🏃 `Move`
- 🦘 `Jump`
- ⚔️ `Attack`

These actions are triggered by **buttons** (keyboard keys or controller inputs).

We want:

- Buttons to trigger actions
- Actions to be reusable and flexible
- The button system to be independent from the `Player` class

The Command pattern lets us encapsulate each action as an object.

---

## 🛠️ Step-by-Step Explanation

---

## 1️⃣ Step 1: Create the Command Interface

```java
public interface Command {
    void execute();
}
```

* This class represents a generic command.
* Every concrete command must implement ``execute()``.

### 2️⃣ Step 2: Create the Receiver (Player)

```java 

public class Player {
    public void jump(){
        System.out.println("The playe jump");
    }

    public void attack(){
        System.out.println("The player attack with a knife");
    }

    public void move(){
        System.out.println("The player move forward");
    }
}
```

* The Player class contains the real game logic.
* It does not know anything about buttons or commands.

### 3️⃣ Step 3: Create Concrete Commands
```java

public class AttackCommand implements Command{
    private Player player;

    public AttackCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.attack();
    }
}
public class JumpCommand implements Command{
    private Player player;

    public JumpCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.jump();
    }
}
public class MoveCommand implements Command{
    private Player player;

    public MoveCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        this.player.move();
    }
}

```

* Each command wraps a request to the ``Player``.
* The button does not directly call the ``Player`` class

### 4️⃣ Step 4: Create the Invoker (Button)

```java
public interface IButton {
    void setCommand(Command command);
    void press();
}

public class Button implements IButton{
    private Command command;

    public Command getCommand() {
        return command;
    }

    @Override
    public void press() {
        command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
```

* The button triggers a command

* It does not know what the command does.


### 5️⃣ Step 5: Use the Command Pattern

```java

public class Main {
    public static void main(String [] args){
        ///Define variables
        Player player;
        Button button,button1;


        ///Initialize variables
        player = new Player();

        button = new Button();
        button.setCommand(new MoveCommand(player));

        button1 = new Button();
        button1.setCommand(new AttackCommand(player));

        button.press();
        button1.press();

        button.setCommand(new JumpCommand(player));

        button.press();

    }
}

```

### 🔍 When to Use Command

* You want to decouple sender and receiver

* You need undo/redo functionality

* You want to queue or log actions

* You want flexible action assignment (e.g., remappable controls)

### 💡 Summary

* **Purpose**: Encapsulate a request as an object.

* **Benefits**: Loose coupling, extensibility, supports undo/redo.

* **Typical Use Cases**: Game controls, UI buttons, task scheduling, macro systems.

* **Key Idea**: Turn actions into objects.