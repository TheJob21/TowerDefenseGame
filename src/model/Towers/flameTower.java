package model.Towers;

import controller.Main;
import model.Projectiles.Flame;
import model.Sounds;

import java.awt.*;

public class flameTower extends Tower {

    private static int init_fire_rate = 2;
    private static Color color = Color.RED;
    public static int init_range = 100;
    public static int PRICE = 1000+100*Main.win.selectedDifficulty();
    private int upgradePrice =250+25*Main.win.selectedDifficulty();
    private static int flame_speed = 12;
    private static int mx_flame = 25;

    public flameTower(float x, float y) {
        super(x, y, color, init_range, init_fire_rate, PRICE);
        barrel.x1 = super.location.x;
        barrel.y1 = super.location.y;
        upgrade_price = Integer.toString(upgradePrice);
        upgradeStat = "+25 range";
        if (Main.selectedMap == 1) {
            sound = Sounds.highGround;
        } else {
            sound = Sounds.flameThrower;
        }
        Sounds.loadSound(sound);
    }

    @Override
    public void update() {
        updateState();
        updateBarrel();

        if(tx != location.x && ty != 0){ // if in range try to shoot
            if(state == LOADED){ // if gun is loaded shoot
                Flame f = new Flame((int)barrel.x2, (int)barrel.y2, (int) tx, (int) ty, flame_speed, mx_flame);
                Main.gameData.friendObject.add(f);
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
                upgradePrice =300+30*Main.win.selectedDifficulty();
                upgrade_price = Integer.toString(upgradePrice);
                upgradeStat = "+12 projectile speed";
                Main.win.displayTextBox("Range upgraded");
            }
            else{
                Main.win.displayTextBox("Insufficient funds");
            }
        }else if(super.level==2){
            if(Main.user.getBank() >= upgradePrice) {
                flame_speed += 12;
                super.level++;
                Main.user.spendMoney(upgradePrice);
                value += upgradePrice;
                upgradePrice =400+40*Main.win.selectedDifficulty();
                upgrade_price = Integer.toString(upgradePrice);
                upgradeStat = "+9 burn radius";
                Main.win.displayTextBox("Flame speed upgraded");
            }
            else{
                Main.win.displayTextBox("Insufficient funds");
            }
        }else if(super.level==3){
            if(Main.user.getBank() >= upgradePrice) {
                mx_flame += 9;
                super.level++;
                Main.user.spendMoney(upgradePrice);
                value += upgradePrice;
                upgradePrice =1000+100*Main.win.selectedDifficulty();
                upgrade_price = Integer.toString(upgradePrice);
                upgradeStat = "+30 fire rate";
                Main.win.displayTextBox("Burn radius upgraded");
            }
            else{
                Main.win.displayTextBox("Insufficient funds");
            }
        }else if(super.level==4){
            if(Main.user.getBank() >= upgradePrice) {
                fire_rate -= 1;
                super.level++;
                Main.user.spendMoney(upgradePrice);
                value += upgradePrice;
                upgrade_price = "Max level";
                upgradeStat = "";
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
        return "Range: " + range + ", Flame Speed: " + flame_speed + ", Burn Radius: " + mx_flame + ", Fire Rate: " + 60.0/(double)fire_rate + "/second";
    }
}
