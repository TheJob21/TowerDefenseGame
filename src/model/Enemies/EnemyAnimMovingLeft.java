package model.Enemies;

import model.Enemies.StarWars.SWEnemy;

public class EnemyAnimMovingLeft implements EnemyAnimStrategy {
    private Enemy context;

    public EnemyAnimMovingLeft(Enemy context) {
        this.context = context;
    }

    @Override
    public void animate() {
        context.location.x -= context.UNIT_MOVE;
    }
}
