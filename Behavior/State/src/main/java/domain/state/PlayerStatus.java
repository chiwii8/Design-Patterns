package domain.state;

import domain.Player;

public interface PlayerStatus {
    void receiveDamage(Player player, int damage);
}
