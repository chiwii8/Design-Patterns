package domain.visitor;

import domain.Enemy;
import domain.Player;

public interface Visitor {
    void visitPlayer(Player player);
    void visitEnemy(Enemy enemy);
}
