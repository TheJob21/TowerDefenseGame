package model.Enemies.StarWars;

import controller.Main;
import model.GameData;
import model.Sounds;

import java.awt.*;

public class DeathStar extends SWEnemy {
    private Color color;
    private boolean soundPlayed= false;

    public DeathStar(int x, int y, int hp, int sd){
        super(x, y, sd,25,1000,hp);
        color = Color.BLACK;
        super.SIZE = 200;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(color);
        g2.setStroke(new BasicStroke(1)); // thickness
        g2.fillOval((int)super.location.x - SIZE/2,(int)super.location.y-SIZE/2, SIZE, SIZE);
        g2.setColor(Color.GRAY);
        g2.fillOval((int)super.location.x + SIZE/8,(int)super.location.y-SIZE*3/8, SIZE/4, SIZE/4);
        g2.drawLine((int)super.location.x + SIZE/2,(int)super.location.y, (int)super.location.x - SIZE/2, (int)super.location.y);
    }

    @Override
    public void update() {
        updateState();
        if (numberOfTurns == 0) {
            if (location.x >= 222)
                Sounds.loadSound(Sounds.badFeeling);
        }else if (numberOfTurns == 2){
            if (location.x >= 425)
                Sounds.loadSound(Sounds.underestimateMyPower);
        }else if (numberOfTurns == 4){
            if (location.x >= 661)
                Sounds.loadSound(Sounds.treatedUnfairly);
        }else if (numberOfTurns == 6) {
            if (location.x >= 844)
                Sounds.loadSound(Sounds.legal);
        }else if (numberOfTurns == 7) {
            if (location.y <= 97)
                Sounds.loadSound(Sounds.makeItLegal);
        }else if (numberOfTurns == 8){
            if (location.x >= 999)
                Sounds.loadSound(Sounds.anakinYell);
        }else if (numberOfTurns == 9){
            if (location.y >= 559)
                Sounds.loadSound(Sounds.anakinYell2);
        }else if (numberOfTurns == 10){
            if (location.x <= 870)
                Sounds.loadSound(Sounds.sidiousScream);
        }else if (numberOfTurns == 11) {
            if (location.y <= 420)
                Sounds.loadSound(Sounds.unlimitedPower);
        }else if (numberOfTurns == 12) {
            if (location.x <= 680)
                Sounds.loadSound(Sounds.youCanDoBetter);
        }else if (numberOfTurns == 13) {
            if (location.y >= 566)
                Sounds.loadSound(Sounds.order66);
        }else if (numberOfTurns == 15){
            if (location.y <= 415)
                Sounds.loadSound(Sounds.theSenate);
        }else if (numberOfTurns == 16){
            if (location.x <= 199)
                Sounds.loadSound(Sounds.thisIsImpossible);
        }else if (numberOfTurns == 17){
            if (location.y >= 554)
                Sounds.loadSound(Sounds.haveYouNow);
        }else if (numberOfTurns == 18){
            if (location.x <= 0)
                Sounds.loadSound(Sounds.itsATrap);
        }
        if (super.done) {
            GameData.killCount4++;
            Sounds.loadSound(Sounds.DSExplosion);
            if(Main.win.selectedEndless())
                Sounds.loadSound(Sounds.wellWhaddyaKnow);
        }
        if(HP <=  500 && !soundPlayed) {
            soundPlayed = true;
            Sounds.loadSound(Sounds.abandonShip);
        }
        animStrategy.animate(); // strategy design pattern
        if(location.x >= 1 && location.x <= UNIT_MOVE && location.y <= 90 && !REACHED_END && Main.iteration == 2) Sounds.loadSound(Sounds.noMoon);
        else if(location.x >= 1 && location.x <= UNIT_MOVE && location.y <= 90 && !REACHED_END && Main.iteration == 3) Sounds.loadSound(Sounds.twoOfThem);
        if(location.x >= 1 && location.x <= UNIT_MOVE && location.y <= 560 && location.y >= 550) Sounds.loadSound(Sounds.itsATrap);
    }
}