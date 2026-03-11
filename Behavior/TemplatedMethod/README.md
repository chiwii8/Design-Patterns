# Template Method Pattern - Step by Step Example


## 🎯 Use Case

Imagine we have a game with different missions

The missions could share the different stages of the mission. We have two different mission:

* Normal: Ready, execute
* Rescue: Ready, execute, reward

---

## 🛠️ Step-by-Step Explanation

---

## 1️⃣ Step 1: Create the TemplateMethod Interface

```java
public abstract class Mission {
    public final void executeMission(){
        ready();
        execute();
        reward();
    }

    protected abstract void ready();
    protected abstract void execute();
    protected void reward(){
        System.out.println("Basic reward");
    }
}

```

## 2️⃣ Step 2: Implement Concrete Templated

```java
public class NormalMission extends Mission {

    @Override
    protected void ready() {
        System.out.println("Starting the mission");
    }

    @Override
    protected void execute() {
        System.out.println("Doing the mission");
    }
}

public class RescueMission extends Mission {

    @Override
    protected void ready() {
        System.out.println("Starting rescue mission");
    }

    @Override
    protected void execute() {
        System.out.println("Recue the NPC of mission");
    }

    @Override
    protected void reward() {
        super.reward();
        System.out.println("Additional reward: Elixir");
    }
}
```

## 3️⃣ Step 3: Use the Pattern

```java
public class Main {
    public static void main(String [] args){
        Mission m1 = new RescueMission();
        Mission m2 = new NormalMission();

        m1.executeMission();
        System.out.println("---------");
        m2.executeMission();
    }
}

```

### 🔍 When to Use Template Method

* You have a fixed algorithm structure with steps that vary in subclasses

* You want to avoid duplicating code for similar workflows

* You want to enforce a specific sequence of operations

* You want to allow subclasses to implement or override certain steps without changing the overall algorithm

### 💡 Summary

* **Purpose**: Define the skeleton of an algorithm in a base class and let subclasses implement specific steps.

* **Benefits**: Code reuse, consistent workflow, easier maintenance, adherence to the open/closed principle.

* **Typical Use Cases**: Game missions, document processing, data pipelines, GUI rendering, template-based workflows.

* **Key Idea**: Use inheritance to define fixed steps and allow subclasses to customize only the variable parts.