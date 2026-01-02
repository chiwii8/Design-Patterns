import domain.movement.LegSystem;
import domain.movement.WheelSystem;
import domain.robot.CleanRobot;
import domain.robot.RoboDog;
import domain.robot.Robot;

/**
 * Main.java
 * <p>
 * Description: Execution of the example of robot using the different {@link domain.movement.MovementSystem}
 *
 * @author aleja
 * @since 01/01/2026
 */

public class Main {
    public static void main(String [] args){
        //Define variables
        Robot cleaner;
        Robot roboDog;

        ///Initialize variables
        cleaner = new CleanRobot(new WheelSystem());
        roboDog = new RoboDog(new LegSystem());

        ///We use the default movementInstruction for the example
        cleaner.doTask();
        roboDog.doTask();



    }
}
