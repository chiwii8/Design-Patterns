# Prototype Pattern – Step by Step Example

This document explains the **Prototype design pattern** using a clear and practical example.

The Prototype pattern allows you to **create new objects by copying (cloning) existing ones**, instead of instantiating them from scratch. This is especially useful when object creation is expensive or complex.

---

## 🎯 Use Case

Imagine we are working with objects that represent **Shapes** with many predefined types.

Instead of recreating the same object structure repeatedly, we:

* Create a base object (prototype)
* Clone it whenever we need a new instance
* Customize only what changes

---

## 🛠️ Step-by-Step Explanation

### 1️⃣ Step 1: Define the Prototype Interface

```java
public interface Prototype {
    Prototype clone();
}
```

* Declares a `clone()` method that all concrete prototypes must implement.
* This method is responsible for copying the object.

### 2️⃣ Step 2: Create a Concrete Prototype

```java
public class Shape implements Prototype {
    private String color;
    private int x,y;

    public Shape(Shape shape){
        super();
        this.x = shape.x;
        this.y = shape.y;
        this.color = shape.color;
    }

    /// Set and get methods

    @Override
    public abstract Shape clone();
}


public class Circle extends Shape {
    private double radius;

    public Circle(Circle circle){
        super(circle);
        this.radius = circle.radius;
    }

    @Override
        public Shape clone() {
            return new Circle(this);
        }
}
```

* The `clone()` method creates a **new instance**.
* Copies the internal state from the original object.
* This is an example of a **shallow copy**.

### 3️⃣ Step 3: Use the Prototype

```java
 ///Initialize the objects
    circle = new Circle();
    circle.setColor("Red");
    circle.setX(5);
    circle.setY(10);

    Shape copy = (Circle) circle.clone();
```

* `original` and `copy` are **different objects**.
* Changes to the clone do not affect the original.

---

## 🔍 When to Use Prototype

* Object creation is **costly or complex**
* You want to **avoid subclassing** for object creation
* You need many similar objects with small differences

---

## 💡 Summary

* **Purpose:** Create new objects by cloning existing ones.
* **Benefits:** Better performance, simpler object creation, reduced coupling.
* **Typical Use Cases:** Document templates, configuration objects, game characters.
* **Key Idea:** Copy an existing object instead of building a new one.

With the Prototype pattern, object creation becomes **faster, cleaner, and more flexible**.
