package model.Towers;

import controller.Main;
import model.Projectiles.Bullet;
import model.Sounds;

import java.awt.*;

public class gunTower extends Tower {

    private static int init_fire_rate = 20;
    private static Color color = Color.GREEN;
    public static int init_range = 125;
    public static int PRICE = 100+10*Main.win.selectedDifficulty();
    private int upgradePrice =50+5*Main.win.selectedDifficulty();

    public gunTower(float x, float y) {
        super(x, y, color, init_range, init_fire_rate, PRICE);
        barrel.x1 = super.location.x;
        barrel.y1 = super.location.y;
        upgrade_price = Integer.toString(upgradePrice);
        upgradeStat = "+25 range";
        if (Main.selectedMap == 1) {
            super.sound = Sounds.doIt;
        } else {
            super.sound = Sounds.arFiring;
        }
        Sounds.loadSound(sound);
    }

    @Override
    public void update() {
        updateState();
        updateBarrel();

        if(tx != location.x && ty != 0){ // if in range try to shoot
            if(state == LOADED){ // if gun is loaded shoot
                Bullet b = new Bullet((int)barrel.x2, (int)barrel.y2, target);
                Main.gameData.friendObject.add(b);
                loading = 0;
            }
        }
    }

    @Override
    public void upgrade(){
        if(super.level==1){
            if(Main.user.getBank() >= upgradePrice) {
                super.range += 25;
                super.level++;
                Main.user.spendMoney(upgradePrice);
                value += upgradePrice;
                upgradePrice =100+10*Main.win.selectedDifficulty();
                upgrade_price = Integer.toString(upgradePrice);
                upgradeStat = "+3 fire rate";
                Main.win.displayTextBox("Range upgraded");
            }
            else{
                Main.win.displayTextBox("Insufficient funds");
            }
        }else if(super.level==2){
            if(Main.user.getBank() >= upgradePrice) {
                super.fire_rate /= 2;
                super.level++;
                Main.user.spendMoney(upgradePrice);
                value += upgradePrice;
                upgradeStat = "";
                upgrade_price = "Max level";
                Main.win.displayTextBox("Fire rate upgraded");
            }
            else{
                Main.win.displayTextBox("Insufficient funds");
            }
        }else{
            Main.win.displayTextBox("Max tower level reached");
        }
    }

    @Override
    public String getStats(){
        return "Range: " + range + ", Fire Rate: " + 60.0/(double)fire_rate + "/second";
    }
}