package model.Enemies;

import model.Enemies.StarWars.SWEnemy;

public class EnemyAnimMovingUp implements EnemyAnimStrategy {
    private Enemy context;

    public EnemyAnimMovingUp(Enemy context) {
        this.context = context;
    }

    @Override
    public void animate() {
        context.location.y -= context.UNIT_MOVE;
    }
}
