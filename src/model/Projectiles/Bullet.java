package model.Projectiles;

import model.GameFigure;
import java.awt.*;
import java.awt.geom.Point2D;

public class Bullet extends Projectile {

    public static final int STATE_SHOOTING = 0;
    public static final int STATE_DONE = 1;

    Point2D.Float target;
    private GameFigure context;

    public Bullet(int blx, int bly, GameFigure context){
        super(4, STATE_SHOOTING,Color.RED,30);
        super.location.x = blx;
        super.location.y = bly;
        this.context = context;
        target = new Point2D.Float(context.location.x, context.location.y);
        animStrategy = new BulletAnimShooting(this);
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
        if(state == STATE_DONE){
            super.done = true;
        }
        target = new Point2D.Float(context.location.x, context.location.y);
        animStrategy.animate();
    }

    public void updateState(){
        if (state == STATE_SHOOTING) {
            if(hitCount > 0 || context.done){
                state = STATE_DONE;
            }
        }
    }
}
