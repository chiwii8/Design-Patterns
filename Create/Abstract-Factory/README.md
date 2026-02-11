# Abstract Factory Pattern – Step by Step Example

The Abstract Factory pattern provides an interface for creating **families of related objects** without specifying their concrete classes.

---

## 🎯 Use Case

Imagine we are building an application that supports **different types of art**, for example:

* **Digital art**
* **Traditional art**

Each art type must provide a consistent family of elements:

* `Picture`
* `Portrait`

The goal is to ensure that **elements from the same art style are always used together**, without the client knowing the concrete implementations.

---

## 🛠️ Step-by-Step Explanation

### 1️⃣ Step 1: Define Abstract Products

```java
public abstract class Picture {
}

public abstract class Portrait {
}
```

* These abstract classes define the **products** that belong to the same family.
* Client code depends only on abstractions, not concrete classes.

---

### 2️⃣ Step 2: Define the Abstract Factory

```java
public interface AbstractFactory {
    Picture createPicture();
    Portrait createPortrait();
}
```

* Declares factory methods for **each product in the family**.
* Ensures related objects are created together.

---

### 3️⃣ Step 3: Create Concrete Products

Each art style provides its own concrete implementations.

**Digital art products:**

```java
public class DigitalPicture extends Picture {
}

public class DigitalPortrait extends Portrait {
}
```

**Traditional art products:**

```java
public class TraditionalPicture extends Picture {
}

public class TraditionalPortrait extends Portrait {
}
```

* Each concrete product belongs to **one specific family**.
* Mixing products from different families is avoided by design.

---

### 4️⃣ Step 4: Implement Concrete Factories

```java
public class DigitalFactory implements AbstractFactory {

    @Override
    public Picture createPicture() {
        return new DigitalPicture();
    }

    @Override
    public Portrait createPortrait() {
        return new DigitalPortrait();
    }
}
```

```java
public class TraditionalFactory implements AbstractFactory {

    @Override
    public Picture createPicture() {
        return new TraditionalPicture();
    }

    @Override
    public Portrait createPortrait() {
        return new TraditionalPortrait();
    }
}
```

* Each concrete factory represents **one product family**.
* Switching the factory switches the entire family of objects.

---

### 5️⃣ Step 5: Use the Abstract Factory

```java
AbstractFactory factory = selectTypeArt(typeArt);
Object element = createArt(typePicture, factory);

System.out.println(
    "The element created is: " + element.getClass().getSimpleName()
);
```

```java
private static AbstractFactory selectTypeArt(char type) {
    if (type == 'd') {
        return new DigitalFactory();
    }
    return new TraditionalFactory();
}

private static Object createArt(char type, AbstractFactory factory) {
    if (type == 'p') {
        return factory.createPicture();
    }
    return factory.createPortrait();
}
```

* The client never references concrete classes directly.
* Only the selected factory determines which objects are created.

> 💡 **Note:** Using `Object` works, but a common interface or superclass for all art elements would be a cleaner design.

---

## 🔍 When to Use Abstract Factory

* You work with **families of related objects**
* You want to guarantee **product consistency**
* You need to switch entire product families at runtime

---

## 💡 Summary

* **Purpose:** Create families of related objects without specifying concrete classes.
* **Benefits:** Consistency, scalability, strong abstraction.
* **Typical Use Cases:** Art styles, UI themes, database drivers, cross-platform components.
* **Key Idea:** One factory represents one product family.

With the Abstract Factory pattern, your application becomes **flexible, consistent, and easy to extend**.
