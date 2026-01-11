package domain;

/**
 * RescueMission.java
 * <p>
 * Description: implementation of recue mission extends from {@link Mission} with additional reward
 *
 * @author aleja
 * @since 05/01/2026
 */

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
