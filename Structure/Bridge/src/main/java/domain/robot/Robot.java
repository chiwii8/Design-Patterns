package domain.robot;

import domain.movement.MovementSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Robot.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 01/01/2026
 */

public abstract class Robot {
    private final String [] typeMovements={"forward","left","right","backtrack"};
    private MovementSystem movementSystem;
    ///List of the movement instruction to doTask
    protected List<String> movementInstructions;

    public Robot(MovementSystem movementSystem){
        this.movementSystem = movementSystem;
        this.movementInstructions = new ArrayList<>();
        this.setDefaultMovements();

    }

    public abstract void doTask();

    public void move(String move){
        switch (move){
            case "backtrack":
                movementSystem.backtrack();
                break;
            case "right":
                movementSystem.right();
                break;
            case "left":
                movementSystem.left();
                break;
            case "forward":
            default:
                movementSystem.forward();
        }

    }

    ///Suppose is always correct instruction
    public void setMovementInstruction(String instruction){
        if(Arrays.asList(typeMovements).contains(instruction))
            movementInstructions.add(instruction);
        else {
            System.out.println("Instruction invalid");
            System.out.println("Possible Instructions: " + typeMovements.toString());
        }
    }

    public void deleteInstructions(){
        movementInstructions.clear();
    }

    /**
     * Default Instruction movement for the robot
     */
    public void setDefaultMovements(){
        ///Clear if Instructions in the list
        movementInstructions.clear();
        movementInstructions.add(typeMovements[0]);
        movementInstructions.add(typeMovements[1]);
        movementInstructions.add(typeMovements[2]);
        movementInstructions.add(typeMovements[3]);
    }
}
