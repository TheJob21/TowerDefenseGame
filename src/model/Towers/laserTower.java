package model.Towers;

import controller.Main;
import model.Projectiles.Laser;
import model.Sounds;

import java.awt.*;

public class laserTower extends Tower {

    private static int init_fire_rate = 40;
    private static Color color = Color.CYAN;
    public static int init_range = 100;
    public static int PRICE = 500+50*Main.win.selectedDifficulty();
    public static int upgradePrice = 50+5*Main.win.selectedDifficulty();
    private int laserDuration = 5;

    public laserTower(float x, float y) {
        super(x, y, color, init_range, init_fire_rate, PRICE);
        barrel.x1 = super.location.x;
        barrel.y1 = super.location.y;
        upgrade_price = Integer.toString(upgradePrice);
        upgradeStat = "+25 range";
        if (Main.selectedMap == 1) {
            super.sound = Sounds.soUncivilized;
        } else {
            super.sound = Sounds.sLaser;
        }
        Sounds.loadSound(sound);
    }

    @Override
    protected double getCollisionAngle() {
        return 0;
    }

    @Override
    public void update() {
        updateState();
        updateBarrel();

        if(tx != location.x && ty != 0){ // if in range try to shoot
            if(state == LOADED){ // if laser is loaded shoot
                Laser l = new Laser((int)barrel.x2, (int)barrel.y2, (int) tx, (int) ty, laserDuration);
                Main.gameData.lineObject.add(l);
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
                upgradePrice = 150+15*Main.win.selectedDifficulty();
                upgrade_price = Integer.toString(upgradePrice);
                upgradeStat = "+.5 fire rate";
                Main.win.displayTextBox("Range upgraded");
            }
            else{
                Main.win.displayTextBox("Insufficient funds");
            }
        }else if(super.level==2){
            if(Main.user.getBank() >= upgradePrice) {
                fire_rate -= 10;
                super.level++;
                Main.user.spendMoney(upgradePrice);
                value += upgradePrice;
                upgradePrice = 400+40*Main.win.selectedDifficulty();
                upgrade_price = Integer.toString(upgradePrice);
                upgradeStat = "+1 fire rate";
                Main.win.displayTextBox("Fire rate upgraded");
            }
            else{
                Main.win.displayTextBox("Insufficient funds");
            }
        }else if(super.level==3){
            if(Main.user.getBank() >= upgradePrice) {
                fire_rate -= 10;
                super.level++;
                Main.user.spendMoney(upgradePrice);
                value += upgradePrice;
                upgradePrice = 750+75*Main.win.selectedDifficulty();
                upgrade_price = Integer.toString(upgradePrice);
                upgradeStat = "+5 laser duration";
                Main.win.displayTextBox("Fire rate upgraded");

            }
            else{
                Main.win.displayTextBox("Insufficient funds");
            }
        }else if(super.level==4){
            if(Main.user.getBank() >= upgradePrice) {
                laserDuration = 10;
                super.level++;
                Main.user.spendMoney(upgradePrice);
                value += upgradePrice;
                upgradeStat = "";
                upgrade_price = "Max level";
                Main.win.displayTextBox("Laser duration upgraded");
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
        return "Range: " + range + ", Fire Rate: " + 60.0/(double)fire_rate + "/second, Laser Duration: " + laserDuration;
    }
}
