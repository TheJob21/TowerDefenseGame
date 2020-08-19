package model.Enemies.StarWars;

import model.GameData;
import model.Images;
import model.Sounds;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MTT extends SWEnemy {

    private BufferedImage MTTImage;

    public MTT(int x, int y, int hp, int sd){
        super(x, y, sd,5,50,hp);
        super.SIZE = 60;
        MTTImage = Images.MTT1;
        //MTTImage = Images.Sung;
    }

    @Override
    public void render(Graphics2D g2) {
        if(super.location.x >= 4)
            g2.drawImage(MTTImage, (int)super.location.x -50, (int)super.location.y-35, null);
    }

    @Override
    public void update() {
        updateState();
        if(super.done){
            GameData.killCount3++;
        }
        if(super.state == STATE_MOVING_RIGHT)
            MTTImage = Images.MTT1;
            //MTTImage = Images.Turner;
        else if(super.state == STATE_MOVING_LEFT){
            MTTImage = Images.MTT2;
            //MTTImage = Images.Sung;
        }
        if(super.done && !Sounds.clip.isActive())
            Sounds.loadSound(Sounds.creditsWillDoFine);
        animStrategy.animate(); // strategy design pattern
        if(location.x >= 1 && location.x <= this.UNIT_MOVE && location.y <= 90 && location.y >= 87 && !REACHED_END) Sounds.loadSound(Sounds.helloThere);
        if(location.x >= 1 && location.x <= this.UNIT_MOVE && location.y <= 560 && location.y >= 550) Sounds.loadSound(Sounds.happyLanding);
    }
}