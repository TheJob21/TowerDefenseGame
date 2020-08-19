package model.Projectiles;

public class FlameAnimBurning implements ProjectileAnimStrategy {

    Flame context;

    FlameAnimBurning(Flame context){
        this.context = context;
    }

    @Override
    public void animate() {
        context.SIZE+=5;
    }
}
