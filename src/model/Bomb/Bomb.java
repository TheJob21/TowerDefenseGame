package model.Bomb;

import model.GameFigure;

import java.awt.geom.Point2D;

public abstract class Bomb extends GameFigure {
    public final int range;
    public final int price;
    public Bomb(float x, float y, int range, int price){
        location = new Point2D.Float(x,y);
        this.range = range;
        this.price = price;
    }

    @Override
    public String getUpgrade_price(){ return "";}

    @Override
    public String getStats(){return "";}

    @Override
    public void upgrade() {}

    @Override
    public String getUpgradeStat(){return "";}
}
