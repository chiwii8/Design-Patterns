# Singleton Pattern

The Singleton pattern ensures that a class has **only one instance** and provides a **global point of access** to it.

---

## 🎯 Use Case

We want a configuration class `MainConfiguration` that holds some variables.

There should be **only one configuration instance** accessible throughout the program.

---

## 🛠️ Step-by-Step Explanation

### 1️⃣ Step 1: Private Constructor and Static Instance

```java
private static MainConfiguration instance; // holds the single instance

private MainConfiguration() {
    /* your settings
    *   **** variables
    */
}
```

* The **private constructor** prevents creating instances from outside.
* The **static instance variable** stores the unique object.

### 2️⃣ Step 2: Global Access Method

```java
public static MainConfiguration getInstance() {
    if (instance == null) {
        instance = new MainConfiguration();
    }
    return instance;
}
```

* `getInstance()` provides **a single access point**.
* Creates the instance **only when first needed** (lazy initialization).

### 3️⃣ Step 3: Using the Singleton

```java
MainConfiguration config = MainConfiguration.getInstance();

MainConfiguration anotherConfig = MainConfiguration.getInstance();
System.out.println(anotherConfig.getLanguage); // ES
System.out.println(anotherConfig.IsDarkMode); // true
```

* Both variables point to the **same instance**.
* Changes through one reference are visible everywhere.

### 4️⃣ Optional Improvements

* **Thread-Safe Singleton:**

```java
public static synchronized MainConfiguration getInstance() { ... }
```

* **Eager Initialization:**

```java
private static final MainConfiguration instance = new MainConfiguration();
public static MainConfiguration getInstance() { return instance; }
```

* Use these for **multi-threaded applications** or if you want the instance to be created immediately.

---

## 💡 Summary

* **Purpose:** Ensure a single instance of a class.
* **Benefits:** Global access, centralized state management.
* **Typical Use Cases:** Configurations, logging, database connections.

With this pattern, your application settings remain **consistent, centralized, and easily accessible**.
