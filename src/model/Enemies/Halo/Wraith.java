package model.Enemies.Halo;

import model.GameData;
import model.Images;
import model.Sounds;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Wraith extends HaloEnemy{
    private BufferedImage WraithImage;

    public Wraith(int x, int y, int hp, int sd){
        super(x, y, sd,5,50,hp);
        super.SIZE = 45;
        WraithImage = Images.Wraith1;
    }

    @Override
    public void render(Graphics2D g2) {
        if(super.location.x >= 4)
            g2.drawImage(WraithImage, (int)super.location.x -50, (int)super.location.y-35, null);
    }

    @Override
    public void update() {
        updateState();
        if(super.done){
            GameData.killCount3++;
            Sounds.loadSound(Sounds.eliteDeath);
        }
        if(super.state == STATE_MOVING_RIGHT)
            WraithImage = Images.Wraith1;
        else if(super.state == STATE_MOVING_LEFT){
            WraithImage = Images.Wraith2;
        }
        if(super.done && !Sounds.clip.isActive())
            Sounds.loadSound(Sounds.creditsWillDoFine);
        animStrategy.animate(); // strategy design pattern
        if(location.x >= 1 && location.x <= this.UNIT_MOVE && location.y <= 90 && location.y >= 87 && !REACHED_END) Sounds.loadSound(Sounds.wraithBoost);
        if(location.x >= 1 && location.x <= this.UNIT_MOVE && location.y <= 264 && location.y >= 184) Sounds.loadSound(Sounds.wraithMortar);
    }
}
