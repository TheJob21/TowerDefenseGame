package model.Projectiles;

import model.GameFigure;

import java.awt.*;

public abstract class Projectile extends GameFigure {
    public int SIZE = 0;
    protected int state;
    public Color color;
    public int UNIT_MOVE;
    protected double rad=0;
    protected ProjectileAnimStrategy animStrategy;

    public Projectile(int sz, int ste, Color clr, int um){
        SIZE=sz;
        state=ste;
        color=clr;
        UNIT_MOVE=um;
    }
    @Override
    public int getCollisionRadius() {
        return SIZE/2;
    }

    @Override
    public String getUpgrade_price(){ return "";}

    @Override
    public String getStats(){return "";}

    @Override
    public void upgrade() {}

    @Override
    public String getUpgradeStat(){return "";}

    @Override
    protected double getCollisionAngle() {
        return rad;
    }
}
