package model.Enemies;

import model.Enemies.StarWars.SWEnemy;

public class EnemyAnimMovingRight implements EnemyAnimStrategy {

    private Enemy context;

    public EnemyAnimMovingRight(Enemy context) {
        this.context = context;
    }

    @Override
    public void animate() {
        context.location.x += context.UNIT_MOVE;
    }
}
