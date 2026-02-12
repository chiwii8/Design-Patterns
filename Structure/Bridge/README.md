# Bridge Pattern – Step by Step Example

The Bridge pattern is a **structural design pattern** that **decouples an abstraction from its implementation**, allowing the two to vary independently.

It is useful when both the abstractions and their implementations may change frequently and independently.

---

## 🎯 Use Case

Imagine we have a `Robot` abstraction that can have different types of movement systems, such as:

* `LegSystem`
* `WheelSystem`

Each device has its own implementation for `forward`,  `left`, `right`, `backtrack`
We want to **change both robot types and movement systems independently**.

---

## 🛠️ Step-by-Step Explanation

### 1️⃣ Step 1: Define the Implementor Interface

```java
public interface MovementSystem  {
    void forward();
    void left();
    void right();
    void backtrack();
}

```

* This interface represents the **implementation side**.
* Concrete mvement systems will implement this interface.

---

### 2️⃣ Step 2: Implement Concrete Devices

```java
public class LegSystem implements MovementSystem{
    @Override
    public void forward() {
        System.out.println("The robot walk forward");
    }

    @Override
    public void left() {
        System.out.println("The robot turn to left");
    }

    @Override
    public void right() {
        System.out.println("The robot turn to right");
    }

    @Override
    public void backtrack() {
        System.out.println("The robot start turn 180 degrees to the left ");
        left();
        forward();
    }
}

public class WheelSystem implements MovementSystem{
    @Override
    public void forward() {
        System.out.println("The robot move forward");
    }

    @Override
    public void left() {
        System.out.println("The robot turn to left");
    }

    @Override
    public void right() {
        System.out.println("The robot turn to right");
    }

    @Override
    public void backtrack() {
        System.out.println("The robot move backward");
    }
}
```

* These are the **concrete implementations**.
* Each device behaves differently but adheres to the same interface.

---

### 3️⃣ Step 3: Define the Abstraction

```java
public abstract class Robot {
    private final String [] typeMovements={"forward","left","right","backtrack"};
    private MovementSystem movementSystem;
    ///List of the movement instruction to doTask
    protected List<String> movementInstructions;

    public Robot(MovementSystem movementSystem){
        this.movementSystem = movementSystem;
        this.movementInstructions = new ArrayList<>();
        this.setDefaultMovements();

    }

    public abstract void doTask();

    public void move(String move){
        switch (move){
            case "backtrack":
                movementSystem.backtrack();
                break;
            case "right":
                movementSystem.right();
                break;
            case "left":
                movementSystem.left();
                break;
            case "forward":
            default:
                movementSystem.forward();
        }

    }

    ///Suppose is always correct instruction
    public void setMovementInstruction(String instruction){
        if(Arrays.asList(typeMovements).contains(instruction))
            movementInstructions.add(instruction);
        else {
            System.out.println("Instruction invalid");
            System.out.println("Possible Instructions: " + typeMovements.toString());
        }
    }

    public void deleteInstructions(){
        movementInstructions.clear();
    }

    /**
     * Default Instruction movement for the robot
     */
    public void setDefaultMovements(){
        ///Clear if Instructions in the list
        movementInstructions.clear();
        movementInstructions.add(typeMovements[0]);
        movementInstructions.add(typeMovements[1]);
        movementInstructions.add(typeMovements[2]);
        movementInstructions.add(typeMovements[3]);
    }
}
```

* The abstraction maintains a reference to the **implementor**.
* Methods delegate functionality to the implementor.
* Default movements provide a standard set of instructions for the robot.

---

### 4️⃣ Step 4: Implement Refined Abstraction

```java
public class CleanRobot extends Robot{

    public CleanRobot(MovementSystem movementSystem) {
        super(movementSystem);
    }

    @Override
    public void doTask() {
        System.out.println("The  Cleanrobot starts cleaning the area");
        this.movementInstructions.forEach(this::move);
    }
}
public class RoboDog  extends Robot{
    public RoboDog(MovementSystem movementSystem) {
        super(movementSystem);
    }

    @Override
    public void doTask() {
        System.out.println("The RoboDog start walking around the area");
        this.movementInstructions.forEach(this::move);
    }
}
```

* Refined abstraction can extend functionality without modifying the implementor.
* Multiple robot types can share the same movement system.

---

### 5️⃣ Step 5: Use the Bridge

```java

    cleaner = new CleanRobot(new WheelSystem());
    roboDog = new RoboDog(new LegSystem());

    cleaner.doTask();
    roboDog.doTask();
```

* The client can combine **any robot** with **any movement system**.
* Abstraction and implementation can vary independently.

---

## 🔍 When to Use Bridge

* You want to avoid **permanent binding between abstraction and implementation**
* Both abstraction and implementation may **change independently**
* You want to **increase flexibility and scalability**

---

## 💡 Summary

* **Purpose:** Decouple abstraction from implementation so they can vary independently.
* **Benefits:** Flexibility, extensibility, maintainable code.
* **Typical Use Cases:** UI frameworks, device controllers, cross-platform applications.
* **Key Idea:** Use composition to separate abstraction and implementation.

With the Bridge pattern, your code becomes **modular, scalable, and easier to maintain**.
