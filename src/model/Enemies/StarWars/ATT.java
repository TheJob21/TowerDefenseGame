package model.Enemies.StarWars;

import model.GameData;
import model.Images;
import model.Sounds;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ATT extends SWEnemy {
    private BufferedImage ATTImage;

    public ATT(int x, int y, int hp, int sd){
        super(x, y, sd,2,10,hp);
        super.SIZE = 42;
        ATTImage = Images.ATT1;
        //ATTImage = Images.Qian;
    }

    @Override
    public void render(Graphics2D g2) {
        if(super.location.x >= 4)
            g2.drawImage(ATTImage, (int)super.location.x -50, (int)super.location.y-35, null);
    }


    @Override
    public void update() {
        updateState();
        if(super.done){
            GameData.killCount2++;
        }
        if(super.state == STATE_MOVING_RIGHT)
            ATTImage = Images.ATT1;
            //ATTImage = Images.Qian;
        else if(super.state == STATE_MOVING_LEFT){
            ATTImage = Images.ATT2;
            //ATTImage = Images.Qian;
        }
        animStrategy.animate(); // strategy design pattern
        if(location.x >= 1 && location.x <= this.UNIT_MOVE && location.y <= 90 && location.y >= 87 && !REACHED_END && !Sounds.clip.isActive()) Sounds.loadSound(Sounds.helloThere);
        if(location.x >= 1 && location.x <= this.UNIT_MOVE && location.y <= 560 && location.y >= 550 && !Sounds.clip.isActive()) Sounds.loadSound(Sounds.happyLanding);
    }
}
