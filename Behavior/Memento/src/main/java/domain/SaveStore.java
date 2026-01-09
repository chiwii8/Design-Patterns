package domain;

import java.util.Stack;

/**
 * SaveStore.java
 * <p>
 * Description: Caretaker: save the mementos
 *
 * @author aleja
 * @since 04/01/2026
 */

public class SaveStore {
    private Stack<MementoPlayer>  history = new Stack<>();

    public void save(MementoPlayer mementoPlayer){
        this.history.add(mementoPlayer);
    }

    public MementoPlayer undo(){
        if(!this.history.empty())
            return this.history.pop();
        return null;
    }
}
