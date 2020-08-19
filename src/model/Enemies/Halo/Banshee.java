package model.Enemies.Halo;

import model.GameData;
import model.Images;
import model.Sounds;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Banshee extends HaloEnemy {
    private BufferedImage BansheeImage;

    public Banshee(int x, int y, int hp, int sd){
        super(x, y, sd,2,10,hp);
        super.SIZE = 38;
        BansheeImage = Images.Banshee1;
    }

    @Override
    public void render(Graphics2D g2) {
        if(super.location.x >= 4)
            g2.drawImage(BansheeImage, (int)super.location.x -50, (int)super.location.y-35, null);
    }


    @Override
    public void update() {
        updateState();
        if(super.done){
            GameData.killCount2++;
            Sounds.loadSound(Sounds.eliteFall);
        }
        if(super.state == STATE_MOVING_RIGHT)
            BansheeImage = Images.Banshee1;
        else if(super.state == STATE_MOVING_LEFT){
            BansheeImage = Images.Banshee2;
        }
        animStrategy.animate(); // strategy design pattern
        if(location.x >= 1 && location.x <= this.UNIT_MOVE && location.y <= 90 && location.y >= 87 && !REACHED_END && !Sounds.clip.isActive()) Sounds.loadSound(Sounds.bansheeFlying);
        if(location.x >= 1 && location.x <= this.UNIT_MOVE && location.y <= 264 && location.y >= 184 && !Sounds.clip.isActive()) Sounds.loadSound(Sounds.bansheeBomb);
    }
}
