package domain;

/**
 * TypeEnemy.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 03/01/2026
 */

public class TypeEnemy {
    ///Reference to the species
    private String name;
    private String sound;

    public TypeEnemy(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
