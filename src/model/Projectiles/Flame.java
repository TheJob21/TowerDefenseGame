package model.Projectiles;

import java.awt.*;
import java.awt.geom.Point2D;

public class Flame extends Projectile {

    private static final int INIT_FLAME_SIZE = 5;
    private static int MAX_FLAME_SIZE;
    private static final int STATE_SHOOTING = 0;
    private static final int STATE_BURNING = 1;
    private static final int STATE_DONE = 2;

    Point2D.Float target;

    public Flame(int blx, int bly, int tx, int ty, int flame_speed, int mx_flame){
        super(INIT_FLAME_SIZE,STATE_SHOOTING,Color.RED,flame_speed);
        super.location.x = blx;
        super.location.y = bly;
        target = new Point2D.Float(tx, ty);
        MAX_FLAME_SIZE = mx_flame;
        animStrategy = new FlameAnimShooting(this);
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
        animStrategy.animate();
    }

    private void updateState() {
        if (state == STATE_SHOOTING) {
            if(hitCount > 0 || target.distance(location) <= (UNIT_MOVE/2+1)){
                state = STATE_BURNING;
                animStrategy = new FlameAnimBurning(this);
            }
        } else if(state == STATE_BURNING) {
            if (SIZE >= MAX_FLAME_SIZE) {
                state = STATE_DONE;
            }
        } else {
            super.done = true;
        }
    }
}
