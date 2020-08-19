package model;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class GameFigure {

    public Point2D.Float location;
    public boolean done = false;
    public int hitCount = 0;
    public int value = 0;
    public int HP;
    public int UNIT_MOVE;
    public int DAMAGE;
    public boolean selected = false;

    public GameFigure(float x, float y){
        location = new Point2D.Float(x,y);
    }
    public GameFigure(float x, float y, int price){
        this.location = new Point2D.Float(x,y);
        this.value = price;
    }

    public GameFigure(){
        this(0,0);
    }

    public boolean collideWith(GameFigure o) {
        double dist = this.location.distance(o.location);
        if (dist <= this.getCollisionRadius() + o.getCollisionRadius())
            return true;
        else
            return false;
    }

    public boolean collideWithLine(GameFigure o){
        double rad = Math.atan2(o.location.y - location.y, o.location.x - location.x);
        if (o.location.x >= 0) {
            if(rad >= this.getCollisionAngle() - 0.1 && rad <= this.getCollisionAngle() + 0.1)
                return true;
            return false;
        }
        else
            return false;
    }

    protected abstract double getCollisionAngle();
    public abstract String getUpgradeStat();
    public abstract void render(Graphics2D g2);
    public abstract void update();
    public abstract int getCollisionRadius();
    public abstract void upgrade();
    public abstract String getUpgrade_price();
    public abstract String getStats();
}
