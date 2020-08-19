package model.Enemies.StarWars;

import model.GameData;
import model.Images;
import model.Sounds;

import java.awt.*;
import java.awt.image.BufferedImage;

public class STAP extends SWEnemy {

    private BufferedImage STAP;

    public STAP(int x, int y, int hp, int sd){
        super(x, y, sd, 1, 25, hp);
        super.SIZE = 24;
        STAP = Images.STAP1;
        //STAP = Images.Ghost1;
    }

    @Override
    public void render(Graphics2D g2) {
        if(super.location.x >= 4)
            g2.drawImage(STAP, (int)super.location.x -10, (int)super.location.y-17, null);
    }

    @Override
    public void update() {
        updateState();
        if(super.done){
            GameData.killCount1++;
        }
        if(super.state == STATE_MOVING_RIGHT)
            STAP = Images.STAP1;
            //STAP = Images.Ghost1;
        else if(super.state == STATE_MOVING_LEFT)
            STAP = Images.STAP2;
            //STAP = Images.Ghost2;
        animStrategy.animate(); // strategy design pattern
        if(location.x >= 1 && location.x <= this.UNIT_MOVE && location.y <= 90 && location.y >= 87 && !REACHED_END && !Sounds.clip.isActive()) Sounds.loadSound(Sounds.rogerRoger);
        if(location.x >= 1 && location.x <= this.UNIT_MOVE && location.y <= 560 && location.y >= 550 && !Sounds.clip.isActive()) Sounds.loadSound(Sounds.happyLanding);
    }
}
