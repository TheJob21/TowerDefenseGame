package model.Enemies.CSDepartment;

import model.GameData;
import model.Images;
import model.Sounds;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DrQian extends CSTeacher {
    private BufferedImage Qian;

    public DrQian(int x, int y, int hp, int sd){
        super(x, y, sd, 1, 25, hp);
        super.SIZE = 50;
        Qian = Images.Qian;
    }

    @Override
    public void render(Graphics2D g2) {
        if(super.location.x >= 4)
            g2.drawImage(Qian, (int)super.location.x -10, (int)super.location.y-17, null);
    }

    @Override
    public void update() {
        updateState();
        if(super.done){
            GameData.killCount2++;
            Sounds.loadSound(Sounds.thatsFineQian);
        }
        animStrategy.animate(); // strategy design pattern
        if(location.x >= 1 && location.x <= this.UNIT_MOVE && location.y <= 72 && location.y >= 70 && !REACHED_END && !Sounds.clip.isActive()) Sounds.loadSound(Sounds.straightToPointQian);
        if(location.x >= 1 && location.x <= this.UNIT_MOVE && location.y <= 264 && location.y >= 184 && !Sounds.clip.isActive()) Sounds.loadSound(Sounds.backToTheBeginningQian);
    }
}
