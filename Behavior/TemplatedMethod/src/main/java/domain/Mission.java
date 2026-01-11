package domain;

/**
 * Mision.java
 * <p>
 * Description: Abstract class following Templated Method Pattern
 *
 * @author aleja
 * @since 05/01/2026
 */

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
