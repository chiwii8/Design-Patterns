# Iterator Pattern – Step by Step Example

The **Iterator pattern** is a **behavioral design pattern** that provides a way to access the elements of a collection **sequentially without exposing its internal structure**.

It allows you to traverse a collection without knowing how it is implemented internally (array, list, tree, etc.).

---

## 🎯 Use Case

Imagine we are developing a video game with an **Inventory** system.

The player can store multiple items:

We want to:

- Traverse the inventory
- Show all items
- Keep the internal structure hidden

Instead of exposing the internal `List<Item>`, we use the **Iterator pattern**.

---

## 🛠️ Step-by-Step Explanation

---

## 1️⃣ Step 1: Create the Iterator Interface

```java
/// You can implement or use the default implemented in the import of java.util
public interface Iterator<T> {
    boolean hasNext();
    T next();
}
```

### 2️⃣ Step 2: Implement the Inventory
```java
public class Inventory {
    ///Simple object inventory for the example
    private String [] objects = {
            "knife,potion,shield,key,arrows,bow"
    };

    /// you can implement a interface for the call of creation and iterator or create in the classes
    /// In case, you need in many classes is recommended use an interface. 
    public Iterator<String> newIterator(){
        return new IteratorInventory(objects);
    }
}

```

### 3️⃣ Step 3: Implement the Concrete Iterator
```java
public class IteratorInventory implements Iterator<String> {
    private String [] objects;
    private int position = 0;

    public IteratorInventory(String [] objects) {
        super();
        this.objects = objects;
    }

    @Override
    public boolean hasNext() {
        return position < this.objects.length;
    }

    @Override
    public String next() {
        return objects[position++];
    }
}
```

* Keep track of the current position.
* Traverses the inventory step by step.

### 4️⃣ Step 4: Use the Iterator

```java
public class Main {
    public static void main(String [] args){
        Inventory inventory = new Inventory();
        Iterator<String> iterator = inventory.newIterator();

        while (iterator.hasNext()){
            System.out.println("Object: " + iterator.next());
        }
    }
}

```

### 🔍 When to Use Iterator

* You want to traverse a collection without exposing its structure

* You need multiple traversal strategies

* You want to separate iteration logic from collection logic

### 💡 Summary

* **Purpose**: Provide sequential access to elements without exposing internal structure.

* **Benefits**: Encapsulation, clean separation of concerns.

* **Typical Use Cases**: Inventories, menus, collections, custom data structures.

* **Key Idea**: Move traversal logic into a separate iterator object.