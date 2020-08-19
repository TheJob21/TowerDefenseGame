package controller;

import model.Bomb.Bomb;
import model.Bomb.bigBomb;
import model.Bomb.smallBomb;
import model.GameFigure;
import model.MousePointer;
import model.Sounds;
import model.Towers.*;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import static java.lang.Math.sqrt;

public class PlayerInputEventQueue {

    public LinkedList<InputEvent> queue = new LinkedList<>();
    public void processInputEvents() {
        while(!queue.isEmpty()){
            InputEvent inputEvent = queue.removeFirst();
            switch(inputEvent.type){
                case InputEvent.MOUSE_PRESSED:
                    MouseEvent e = (MouseEvent) inputEvent.event;
                    if(Main.menuButton == 0) {
                        if(e.getX() <= 1049 && e.getX() >= 931 && e.getY() <= 15 && e.getY() >= 4) {
                            if (Sounds.songMuted)
                                Sounds.songMuted = false;
                            else
                                Sounds.songMuted = true;
                        }else if(e.getX() <= 1049 && e.getX() >= 931 && e.getY() <= 32 && e.getY() >= 21) {
                            if (Sounds.soundsMuted)
                                Sounds.soundsMuted = false;
                            else
                                Sounds.soundsMuted = true;
                        }else if(e.getX() <= 1039 && e.getX() >= 931 && e.getY() <= 44 && e.getY() >= 36) {
                            Sounds.nextSong();
                        }else if(e.getX() <= 95 && e.getX() >= 10 && e.getY() <= 53 && e.getY() >= 33) {
                            if(Main.FPS == 20)
                                Main.FPS = 30;
                            else if(Main.FPS == 30)
                                Main.FPS = 40;
                            else if(Main.FPS == 40)
                                Main.FPS = 10;
                            else
                                Main.FPS = 20;
                        }else{
                            boolean noSelection=true;
                            for(GameFigure fixed: Main.gameData.fixedObject) { // process mouse click on towers
                                fixed.selected = false;
                                if(sqrt((fixed.location.x - e.getX())*(fixed.location.x - e.getX()) + (fixed.location.y - e.getY())*(fixed.location.y - e.getY())) <= 15){
                                    fixed.selected = true;
                                    Main.win.displayUpgradeMenu(fixed);
                                    Main.win.displayTextBox(fixed.getStats());
                                    noSelection=false;
                                }
                            }
                            if(noSelection) {
                                for (GameFigure enemy : Main.gameData.enemyObject) { // process mouse click on enemies
                                    enemy.selected = false;
                                    if (sqrt((enemy.location.x - e.getX()) * (enemy.location.x - e.getX()) + (enemy.location.y - e.getY()) * (enemy.location.y - e.getY())) <= 15) {
                                        enemy.selected = true;
                                        noSelection = false;
                                    }
                                }
                            }
                            if (noSelection && Main.running){ Main.win.displayMenu(); Main.win.displayTextBox("Nothing selected"); }
                        }
                        break;
                    }else if(Main.menuButton == 1) {
                        if(!mapCollisions(e)) {
                            gunTower m = new gunTower(e.getX(), e.getY());
                            Main.gameData.fixedObject.add(m);
                            Main.user.spendMoney(gunTower.PRICE);
                        }
                        else
                            Main.win.displayTextBox("Invalid location: Cannot place on path or river.");
                        Main.menuButton = 0;
                    }else if(Main.menuButton == 2) {
                        if(!mapCollisions(e)) {
                            missileTower m = new missileTower(e.getX(), e.getY());
                            Main.gameData.fixedObject.add(m);
                            Main.user.spendMoney(missileTower.PRICE);
                        }
                        else
                            Main.win.displayTextBox("Invalid location: Cannot place on path or river.");
                        Main.menuButton = 0;
                    }else if(Main.menuButton == 3) {
                        if(!mapCollisions(e)) {
                            laserTower m = new laserTower(e.getX(), e.getY());
                            Main.gameData.fixedObject.add(m);
                            Main.user.spendMoney(laserTower.PRICE);
                        }
                        else
                            Main.win.displayTextBox("Invalid location: Cannot place on path or river.");
                        Main.menuButton = 0;
                    }else if(Main.menuButton == 4) {
                        if(!mapCollisions(e)) {
                            flameTower m = new flameTower(e.getX(), e.getY());
                            Main.gameData.fixedObject.add(m);
                            Main.user.spendMoney(flameTower.PRICE);
                        }
                        else
                            Main.win.displayTextBox("Invalid location: Cannot place on path or river.");
                        Main.menuButton = 0;
                    }else if(Main.menuButton == 5) { // Purchase small bomb
                        Bomb b = new smallBomb(e.getX(), e.getY());
                        Main.gameData.friendObject.add(b);
                        Main.user.spendMoney(b.price);
                        Main.menuButton = 0;
                    }else if(Main.menuButton == 6) {// Purchase large bomb
                        Bomb b = new bigBomb(e.getX(), e.getY());
                        Main.gameData.friendObject.add(b);
                        Main.user.spendMoney(b.price);
                        Main.menuButton = 0;
                    }
                    break;
                case InputEvent.MOUSE_MOVED:
                    MousePointer mp = (MousePointer) Main.gameData.mouseObject.get(0);
                    MouseEvent me = (MouseEvent) inputEvent.event;
                    mp.location.x = me.getX();
                    mp.location.y = me.getY();
                    break;
            }
        }
    }
    private boolean mapCollisions(MouseEvent e){
        for(GameFigure fig:  Main.gameData.fixedObject){// Checks for collisions with other towers
            if (sqrt(((fig.location.x - e.getX())*(fig.location.x - e.getX())) + ((fig.location.y - e.getY())*(fig.location.y - e.getY()))) < 30){
                return true;
            }
        }
    // Checks for collisions with the path segments or river
        if (Main.selectedMap == 1) {
            if ((e.getY() > 51 && e.getY() < 131) && ((e.getX() < 268) || (e.getX() > 377 && e.getX() < 702) || e.getX() > 802)) {
                // Segments 1-3
                return true;
            } else if ((e.getY() > 230 && e.getY() < 329) && ((e.getX() > 172 && e.getX() < 474) || (e.getX() > 616 && e.getX() < 890))) {
                // Segments 4-5
                return true;
            } else if ((e.getY() > 358 && e.getY() < 455) && ((e.getX() > 145 && e.getX() < 474) || (e.getX() > 627 && e.getX() < 907))) {
                // Segments 7-8
                return true;
            } else if ((e.getY() > 503) && ((e.getX() < 241) || (e.getX() > 385 && e.getX() < 718) || e.getX() > 824)) {
                // Segments 8-10
                return true;
            } else if ((e.getY() > 102 && e.getY() < 259) && ((e.getX() > 173 && e.getX() < 268) || (e.getX() > 372 && e.getX() < 471) || (e.getX() > 621 && e.getX() < 702) || (e.getX() > 804 && e.getX() < 891) || (e.getX() > 953))) {
                // Segments 11-15
                return true;
            } else if ((e.getY() > 421 && e.getY() < 535) && ((e.getX() > 145 && e.getX() < 242) || (e.getX() > 381 && e.getX() < 470) || (e.getX() > 628 && e.getX() < 721) || (e.getX() > 831 && e.getX() < 914) || e.getX() > 967)) {
                // Segments 16-20
                return true;
            } else if ((e.getY() > 230 && e.getY() < 456) && e.getX() > 958) {
                // Segment 21
                return true;
            } else if (e.getX() > 501 && e.getX() < 552) {
                // river
                return true;
            } else // No collisions
                return false;
        } else {
            if ((e.getY() > 43 && e.getY() < 143) && (e.getX() < 1003)) {
                // Segment 1
                return true;
            } else if ((e.getY() > 113 && e.getY() < 541) && (e.getX() > 888 && e.getX() < 1003)) {
                // Segment 2
                return true;
            } else if ((e.getY() > 510) && (e.getX() > 65 && e.getX() < 1003)) {
                // Segment 3
                return true;
            } else if ((e.getY() > 434 && e.getY() < 540) && (e.getX() > 65 && e.getX() < 187)) {
                // Segment 4
                return true;
            } else if ((e.getY() > 347 && e.getY() < 463) && (e.getX() > 64 && e.getX() < 835)) {
                // Segment 5
                return true;
            } else if ((e.getY() > 249 && e.getY() < 377) && (e.getX() > 716 && e.getX() < 835)) {
                // Segment 6
                return true;
            } else if ((e.getY() > 167 && e.getY() < 278) && e.getX() < 835) {
                // Segments 7
                return true;
            }else {
                // No Collisions
                return false;
            }
        }
    }
}
