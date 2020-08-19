package model.Towers;

import controller.Main;
import model.GameFigure;
import model.Sounds;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public abstract class Tower extends GameFigure {

    int fire_rate;
    static int LOADED = 0;
    private static int RELOADING = 1;
    int range;
    private final int BASE_SIZE = 30;
    final int BARREL_LEN = 30;
    Rectangle2D.Float base;
    Line2D.Float barrel;
    private final Color color;
    int loading = 0;
    int state = RELOADING;
    String upgrade_price;
    int level = 1;
    GameFigure target;
    protected float tx;
    protected float ty;
    protected boolean soundPlayed = false;
    protected String upgradeStat = "";
    protected String sound = "";

    public Tower(float x, float y, Color color, int range, int fire_rate, int value) {
        super(x,y, value);
        base = new Rectangle2D.Float(x-BASE_SIZE/2, y - BASE_SIZE/2, BASE_SIZE, BASE_SIZE);
        barrel = new Line2D.Float(x, y, x, y-BARREL_LEN);
        this.color = color;
        this.range = range;
        this.fire_rate = fire_rate;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(color);
        g2.setStroke(new BasicStroke(2));
        if(selected)
            g2.drawOval((int)location.x - range, (int)location.y - range, range*2,range*2);
        g2.fillRect((int)location.x - 15, (int)location.y - 15, 30,30);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2)); // thickness of the line
        g2.draw(base);
        g2.setStroke(new BasicStroke(5)); // thickness of the line
        g2.draw(barrel);
    }

    public void updateBarrel(){
        tx = location.x;
        ty = 0;
        for(GameFigure enemy: Main.gameData.enemyObject) {// Find enemy in range
            if (this.collideWith(enemy)) {
                target = enemy;
                tx = enemy.location.x;
                ty = enemy.location.y;
                break;
            }
        }
        double rad = Math.atan2(ty-super.location.y, tx-super.location.x);
        float barrel_x = (float)(BARREL_LEN * Math.cos(rad));
        float barrel_y = (float) (BARREL_LEN * Math.sin(rad));
        barrel.x2 = super.location.x + barrel_x;
        barrel.y2 = super.location.y + barrel_y;
    }

    protected void updateState(){
        if(loading >= fire_rate){
            state = LOADED;
        }else{
            state = RELOADING;
            loading++;
        }
        if(selected){
            if(!soundPlayed && !Sounds.clip.isActive()) {
                Sounds.loadSound(sound);
                soundPlayed = true;
            }
        }else soundPlayed = false;
    }

    @Override
    public String getUpgrade_price(){ return upgrade_price; }

    @Override
    public int getCollisionRadius() {
        return range;
    }

    @Override
    protected double getCollisionAngle() {
        return 0;
    }

    @Override
    public String getUpgradeStat(){return upgradeStat;}
}
