package model.Towers;

import controller.Main;
import model.Projectiles.Missile;
import model.Sounds;

import java.awt.*;

public class missileTower extends Tower {

    private static int init_fire_rate = 60;
    private static Color color = Color.ORANGE;
    public static int init_range = 125;
    public static int PRICE = 250+25*Main.win.selectedDifficulty();
    private int upgradePrice = 50+5*Main.win.selectedDifficulty();
    private static int mx_msl = 30;
    private static int msl_speed = 25;

    public missileTower(float x, float y) {
        super(x, y, color, init_range, init_fire_rate, PRICE);
        barrel.x1 = super.location.x;
        barrel.y1 = super.location.y;
        upgrade_price = Integer.toString(upgradePrice);
        upgradeStat = "+15 range";
        if (Main.selectedMap == 1) {
            super.sound = Sounds.reallyBigGun;
        } else {
            super.sound = Sounds.rocketLaunch;
        }
        Sounds.loadSound(sound);
    }

    @Override
    public void update() {
        updateState();
        updateBarrel();

        if(tx != location.x && ty != 0){ // if in range try to shoot
            if(state == LOADED){ // if missile is loaded shoot
                Missile m = new Missile((int)barrel.x2, (int)barrel.y2, (int) tx, (int) ty, mx_msl, msl_speed);
                Main.gameData.friendObject.add(m);
                loading = 0;
            }
        }
    }

    @Override
    public void upgrade(){
        if(super.level==1){
            if(Main.user.getBank() >= upgradePrice) {
                super.range += 15;
                super.level++;
                Main.user.spendMoney(upgradePrice);
                value += upgradePrice;
                upgradePrice = 100+10*Main.win.selectedDifficulty();
                upgrade_price = Integer.toString(upgradePrice);
                upgradeStat = "+15 explosion radius";
                Main.win.displayTextBox("Range upgraded");
            }
            else{
                Main.win.displayTextBox("Insufficient funds");
            }
        }else if(super.level==2){
            if(Main.user.getBank() >= upgradePrice) {
                mx_msl += 15;
                super.level++;
                Main.user.spendMoney(upgradePrice);
                value += upgradePrice;
                upgradePrice = 150+15*Main.win.selectedDifficulty();
                upgrade_price = Integer.toString(upgradePrice);
                upgradeStat = "+.5 fire rate";
                Main.win.displayTextBox("Explosion radius upgraded");
            }
            else{
                Main.win.displayTextBox("Insufficient funds");
            }
        }else if(super.level==3){
            if(Main.user.getBank() >= upgradePrice) {
                fire_rate -= 20;
                super.level++;
                Main.user.spendMoney(upgradePrice);
                value += 150;
                upgradeStat = "+10 projectile speed";
                Main.win.displayTextBox("Fire rate upgraded");
            }
            else{
                Main.win.displayTextBox("Insufficient funds");
            }
        }else if(super.level==4){
            if(Main.user.getBank() >= upgradePrice) {
                msl_speed += 10;
                super.level++;
                Main.user.spendMoney(upgradePrice);
                value += upgradePrice;
                upgrade_price = "Max level";
                upgradeStat = "";
                Main.win.displayTextBox("Missile speed upgraded");
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
        return "Range: " + range + ", Missile Speed: " + msl_speed + ", Explosion Radius: " + mx_msl + ", Fire Rate: " + (60.0/(double)fire_rate) + "/second";
    }
}
