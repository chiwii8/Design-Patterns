import domain.Mission;
import domain.NormalMission;
import domain.RescueMission;

/**
 * Main.java
 * <p>
 * Description: Basic example of Templated method pattern using a mission as base you can modify to add new type of missions or modify the
 * preparation, execution and reward of the mission
 *
 * @author aleja
 * @since 05/01/2026
 */

public class Main {
    public static void main(String [] args){
        Mission m1 = new RescueMission();
        Mission m2 = new NormalMission();

        m1.executeMission();
        System.out.println("---------");
        m2.executeMission();
    }
}
