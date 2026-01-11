package domain;

/**
 * NormalMission.java
 * <p>
 * Description: implementation of normal mission extends from {@link Mission} with the same reward
 *
 * @author aleja
 * @since 05/01/2026
 */

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
