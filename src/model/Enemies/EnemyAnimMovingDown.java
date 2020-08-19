package model.Enemies;

import model.Enemies.StarWars.SWEnemy;

public class EnemyAnimMovingDown implements EnemyAnimStrategy {

    private Enemy context;

    public EnemyAnimMovingDown(Enemy context) {
        this.context = context;
    }

    @Override
    public void animate() {
        context.location.y += context.UNIT_MOVE;
    }
}
