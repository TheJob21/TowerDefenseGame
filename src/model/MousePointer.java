package model;

import controller.Main;
import model.Bomb.bigBomb;
import model.Bomb.smallBomb;
import model.Towers.flameTower;
import model.Towers.gunTower;
import model.Towers.laserTower;
import model.Towers.missileTower;

import java.awt.*;

public class MousePointer extends GameFigure {

    public MousePointer(int x, int y){
        super(x,y);
    }

    @Override
    public void render(Graphics2D g2) {
        if(Main.menuButton == 0){
            return;
        }else if(Main.menuButton == 1){
            if (Main.user.getBank() - gunTower.PRICE >= 0){
                g2.drawOval((int)location.x - gunTower.init_range, (int)location.y - gunTower.init_range, gunTower.init_range*2,gunTower.init_range*2);
                g2.drawRect((int)location.x - 15, (int)location.y - 15, 30,30);
            }
             else{
                Main.menuButton = 0;
                Main.win.displayTextBox("Insufficient funds, slay more enemies");
                //System.out.println("Insufficient Funds, slay more enemies");
             }
        }else if(Main.menuButton == 2){
            if (Main.user.getBank() - missileTower.PRICE >= 0){
                g2.drawOval((int)location.x - missileTower.init_range, (int)location.y - missileTower.init_range, missileTower.init_range*2,missileTower.init_range*2);
                g2.drawRect((int)location.x - 15, (int)location.y - 15, 30,30);
            }
            else{
                Main.menuButton = 0;
                Main.win.displayTextBox("Insufficient funds, slay more enemies");
                //System.out.println("Insufficient Funds, slay more enemies");
            }
        }else if(Main.menuButton == 3){
            if (Main.user.getBank() - laserTower.PRICE >= 0){
                g2.drawOval((int)location.x - laserTower.init_range, (int)location.y - laserTower.init_range, laserTower.init_range*2,laserTower.init_range*2);
                g2.drawRect((int)location.x - 15, (int)location.y - 15, 30,30);
            }
            else{
                Main.menuButton = 0;
                Main.win.displayTextBox("Insufficient funds, slay more enemies");
                //System.out.println("Insufficient Funds, slay more enemies");
            }
        }else if(Main.menuButton == 4){
            if (Main.user.getBank() - flameTower.PRICE >= 0){
                g2.drawOval((int)location.x - flameTower.init_range, (int)location.y - flameTower.init_range, flameTower.init_range*2,flameTower.init_range*2);
                g2.drawRect((int)location.x - 15, (int)location.y - 15, 30,30);
            }
            else{
                Main.menuButton = 0;
                Main.win.displayTextBox("Insufficient funds, slay more enemies");
                //System.out.println("Insufficient Funds, slay more enemies");
            }
        }else if(Main.menuButton == 5){
            if (Main.user.getBank() - smallBomb.PRICE >= 0)
                g2.drawOval((int)location.x - smallBomb.RANGE/2, (int)location.y - smallBomb.RANGE/2, smallBomb.RANGE,smallBomb.RANGE);
            else{
                Main.menuButton = 0;
                Main.win.displayTextBox("Insufficient funds, slay more enemies");
                //System.out.println("Insufficient Funds, slay more enemies");
            }
        }else if(Main.menuButton == 6){
            if (Main.user.getBank() - bigBomb.PRICE >= 0)
                g2.drawOval((int)location.x - bigBomb.RANGE/2, (int)location.y - bigBomb.RANGE/2, bigBomb.RANGE,bigBomb.RANGE);
            else{
                Main.menuButton = 0;
                Main.win.displayTextBox("Insufficient funds, slay more enemies");
                //System.out.println("Insufficient Funds, slay more enemies");
            }
        }
    }

    @Override
    public void update() {}

    @Override
    public void upgrade() {}

    @Override
    public String getUpgrade_price(){ return "";}

    @Override
    public String getUpgradeStat(){ return "";}

    @Override
    public String getStats(){return "";}

    @Override
    public int getCollisionRadius() { return 0;}

    @Override
    protected double getCollisionAngle() {
        return 0;
    }
}
