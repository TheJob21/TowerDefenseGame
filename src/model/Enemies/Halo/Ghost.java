package model.Enemies.Halo;

import model.GameData;
import model.Images;
import model.Sounds;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Ghost extends HaloEnemy {
    private BufferedImage Ghost;

    public Ghost(int x, int y, int hp, int sd){
        super(x, y, sd, 1, 25, hp);
        super.SIZE = 30;
        Ghost = Images.Ghost1;
    }

    @Override
    public void render(Graphics2D g2) {
        if(super.location.x >= 4)
            g2.drawImage(Ghost, (int)super.location.x -10, (int)super.location.y-17, null);
    }

    @Override
    public void update() {
        updateState();
        if(super.done){
            GameData.killCount1++;
            Sounds.loadSound(Sounds.gruntDeath);
        }
        if(super.state == STATE_MOVING_RIGHT)
            Ghost = Images.Ghost1;
        else if(super.state == STATE_MOVING_LEFT)
            Ghost = Images.Ghost2;
        animStrategy.animate(); // strategy design pattern
        if(location.x >= 1 && location.x <= this.UNIT_MOVE && location.y <= 90 && location.y >= 87 && !REACHED_END && !Sounds.clip.isActive()) Sounds.loadSound(Sounds.gruntLaugh);
        if(location.x >= 1 && location.x <= this.UNIT_MOVE && location.y <= 264 && location.y >= 184 && !Sounds.clip.isActive()) Sounds.loadSound(Sounds.ghostFiring);
    }
}
