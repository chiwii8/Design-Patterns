# Facade Pattern – Step by Step Example

The Facade pattern is a **structural design pattern that provides a simplified interface** to a set of interfaces in a subsystem.

It defines a higher-level interface that makes the subsystem easier to use without exposing its complexity.

## 🎯 Use Case
Imagine we are building a **video game** that has multiple complex systems:

* MapSystem – manages the game map

* HUDSystem – handles the heads-up display

* GraphicEngine – renders graphics

* AudioEngine – plays sound effects and music

* others systems

Each system has its own interface and methods. The client would need to interact with each system separately, which can be **complicated and error-prone**.

We create a **VideoGameFacade** that provides a **single interface** to start, pause, and stop the game, hiding the complexity of all subsystems.

## 🛠️ Step-by-Step Explanation

### 1️⃣ Step 1: Define Subsystems

```java
public class AudioEngine {
    public void start(){
        System.out.println("Audio system started");
    }
}
public class HUD {
    public void show(){
        System.out.println("HUD popup in the screen");
    }
}

public class GraphicEngine {
    public void start(){
        System.out.println("Graphic system started");
    }
}

public class Map {
    public void charge(String name){
        System.out.println("Map " + name + " charged");
    }
}

///Other systems
```

* Each subsystem has its own interface and responsibilities.

* Directly using all subsystems requires **many calls and tight coupling** in the client.

### 2️⃣ Step 2: Create the Facade
```java

public class VideoGameFacade {
    private AudioEngine audioEngine;
    private GraphicEngine graphicEngine;
    private HUD hud;
    private Map map;
    private PhysicsSystem physicsSystem;
    Player player;

    public VideoGameFacade() {
        this.audioEngine = new AudioEngine();
        this.hud = new HUD();
        this.map = new Map();
        this.graphicEngine = new GraphicEngine();
        this.physicsSystem = new PhysicsSystem();
        this.player = new Player();
    }

    public void Play(String nameMap){
        System.out.println("Starting Game ...");
        this.graphicEngine.start();
        this.audioEngine.start();
        this.physicsSystem.start();
        this.player.create();
        this.map.charge(nameMap);
        this.player.enterMap(nameMap);
        this.hud.show();
    }
}
```

* The Facade simplifies the client interaction.

* The client does not need to know about all the subsystems.

* Internal complexity is hidden behind a single interface.

### 3️⃣ Step 3: Use the Facade
```java
public class Main {
    public static void main(String [] args){
        VideoGameFacade game = new VideoGameFacade();
        game.Play("Devil Castle");
    }
}
```

* The client can now start with just one object
* All the subsystems are managed internally by the facade
* (Optional) you can implement pause or stop the game, to understand better the pattern.


## 🔍 When to Use Facade

* You want to **simplify complex** subsystems for clients.

* You want to **decouple clients from subsystem** components.

* You want to provide a **unified interface** for a set of operations.

## 💡 Summary

* **Purpose**: Provide a simplified interface to a complex subsystem.

* **Benefits**: Easier usage, reduced coupling, improved readability.

* **Typical Use Cases**: Video games, libraries, APIs, complex frameworks.

* **Key Idea**: Wrap multiple subsystems behind a single class to hide complexity.

With the Facade pattern, your client code becomes cleaner, more maintainable, and easier to use, without exposing subsystem details.