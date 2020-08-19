package model.Text;

import model.GameFigure;

import java.awt.*;

public abstract class Text extends GameFigure {
    String text;
    Color color;
    Font font;

    public Text(String text, int x, int y, Color color, Font font){
        super(x,y);
        this.text = text;
        this.color = color;
        this.font = font;
    }

    @Override
    protected double getCollisionAngle() {
        return 0;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setFont(font);
        g2.setColor(color);
        g2.drawString(text, (int) location.x, (int) location.y);
    }

    @Override
    public int getCollisionRadius() {
        return 0;
    }

    @Override
    public void update(){}

    @Override
    public void upgrade(){}

    @Override
    public String getStats(){return "";}

    @Override
    public String getUpgradeStat(){return "";}

    @Override
    public String getUpgrade_price(){ return "";}

}
