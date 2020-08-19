package model.Projectiles;

import java.awt.*;

public class MissileAnimExploding implements ProjectileAnimStrategy {

    private Missile context;

    public MissileAnimExploding(Missile context) {
        this.context = context;
    }

    @Override
    public void animate() {
        context.color = Color.YELLOW;
        context.SIZE += 5;
    }
}
