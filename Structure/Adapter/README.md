# Adapter Pattern – Step by Step Example

The Adapter pattern is a **structural design pattern** that allows objects with **incompatible interfaces** to work together.

It acts as a bridge between an existing class and the interface that the client expects, without modifying the original code.

---

## 🎯 Use Case

Imagine we have an old controller that works with a basic inputs.

Later, we need to integrate an external inputs (`INewInputs`) whose is **not compatible** with our system.

Instead of rewriting existing code or modifying the external service, we use an **Adapter** to make them work together.

---

## 🛠️ Step-by-Step Explanation

### 1️⃣ Step 1: Define the Target Interface

```java
public interface INewInputs {
    void move();
    void jump();
}
```

* This is the interface expected by the client.
* The client code will only depend on this abstraction.

---

### 2️⃣ Step 2: Existing (Adaptee) Class

```java
public class OldControl {
    public void up(){
        System.out.println("Old Control: the character move foward");
    }

    public void pressA(){
        System.out.println("Old Control: the character jump");
    }
}
```

* This class already exists.
* Its interface does **not match** what the client expects.

---

### 3️⃣ Step 3: Create the Adapter

```java
public class AdapterGameInput  implements INewInputs {
    private OldControl control;

    public AdapterGameInput(OldControl control){
        this.control = control;
    }

    @Override
    public void move() {
        control.up();
    }

    @Override
    public void jump() {
        control.pressA();
    }
}
```

* The Adapter implements the **target interface**.
* Internally, it delegates the call to the adaptee.
* It translates the request into a compatible format.

---

### 4️⃣ Step 4: Use the Adapter

```java
    OldControl control;
    INewInputs newControl;

    
    control = new OldControl();
    newControl = new AdapterGameInput(control);

    ///Now you can play the game without problems with the control
    newControl.move();
    newControl.jump();
```

* The client works with the new controller.
* It is completely unaware of the legacy system.

---

## 🔍 When to Use Adapter

* You need to integrate **legacy or third-party code**
* Interfaces are incompatible
* You want to reuse existing classes without modifying them

---

## 💡 Summary

* **Purpose:** Allow incompatible interfaces to work together.
* **Benefits:** Reusability, separation of concerns, flexibility.
* **Typical Use Cases:** Legacy systems, third-party libraries, API integrations.
* **Key Idea:** Wrap an existing class to adapt it to a new interface.

With the Adapter pattern, integration becomes **clean,
