package model.Projectiles;

import java.awt.*;
import java.awt.geom.Point2D;

public class Laser extends Projectile {

    private static final int STATE_SHOOTING = 0;
    private static final int STATE_DONE = 1;
    private int DURATION;
    private int duration = 0;
    Point2D.Float target;

    public Laser(int blx, int bly, int tx, int ty, int durat){
        super(0,STATE_SHOOTING,Color.RED,5);
        super.location.x = blx;
        super.location.y = bly;
        rad = Math.atan2(ty - location.y, tx - location.x);
        while(tx > 0 && tx < 1290 && ty > 0 && ty < 675){
            tx += UNIT_MOVE * Math.cos(rad);
            ty += UNIT_MOVE * Math.sin(rad);
            DURATION = durat;
        }
        target = new Point2D.Float(tx, ty);
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(color);
        g2.setStroke(new BasicStroke(3)); // thickness
        g2.drawLine((int)location.x, (int)location.y, (int)target.x, (int)target.y);
    }

    @Override
    public void update() {
        updateState();
    }

    public void updateState() {
        if (state == STATE_SHOOTING) {
            if (duration >= DURATION) {
                state = STATE_DONE;
            } else {
                duration++;
            }
        } else {
            super.done = true;
        }
    }
}
