package model.Projectiles;

import java.awt.*;
import java.awt.geom.Point2D;

public class Missile extends Projectile {

    private static final int INIT_MISSILE_SIZE = 5;
    private int MAX_MISSILE_SIZE;
    private static final int STATE_SHOOTING = 0;
    private static final int STATE_EXPLODING = 1;
    private static final int STATE_DONE = 2;
    Point2D.Float target;
    ProjectileAnimStrategy animStrategy;

    public Missile(int blx, int bly, int tx, int ty, int max_size, int msl_speed){
        super(INIT_MISSILE_SIZE,STATE_SHOOTING,Color.RED,msl_speed);
        super.location.x = blx;
        super.location.y = bly;
        target = new Point2D.Float(tx, ty);
        animStrategy = new MissileAnimShooting(this);
        MAX_MISSILE_SIZE = max_size;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(color);
        g2.setStroke(new BasicStroke(1)); // thickness
        g2.fillOval((int)super.location.x - SIZE/2,(int)super.location.y-SIZE/2,SIZE,SIZE);
    }

    @Override
    public void update() {
        updateState();
        animStrategy.animate(); // strategy design patterns
    }

    private void updateState() {
        if (state == STATE_SHOOTING) {
            if(hitCount > 0 || target.distance(location) <= (UNIT_MOVE/2+1)){
                state = STATE_EXPLODING;
                animStrategy = new MissileAnimExploding(this);
            }
        } else if(state == STATE_EXPLODING) {
            if (SIZE >= MAX_MISSILE_SIZE) {
                state = STATE_DONE;
            }
        } else {
            super.done = true;
        }
    }
}