package controller;

import model.Sounds;
import view.MyWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener extends JFrame implements ActionListener {
    private static boolean no = false;
    private static int waveCount = 0; // Stores wave number
    private MyWindow win;
    public ButtonListener(MyWindow win){this.win = win;} // Constructor
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == win.getQuitButton()){ // Quit game
            Sounds.clipMusic.stop(); // Stop music
            if (Main.selectedMap == 1) {
                Sounds.loadSound(Sounds.goodJob); // Sound effect
            }
        // Delay for sound effect to finish
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.exit(0);
        }else if(e.getSource() == win.getCancelButton()){
            Main.menuButton = 0;
            if (Main.selectedMap == 1) {
                if(no){ Sounds.loadSound(Sounds.no); no = false;}
                else{ Sounds.loadSound(Sounds.yup); no = true;}
            } else if (Main.selectedMap == 3) {
                if(no){ Sounds.loadSound(Sounds.funTurner); no = false;}
                else{ Sounds.loadSound(Sounds.objectObjectTurner); no = true;}
            }
        }else if(e.getSource() == win.getlvl1()){
            Main.selectedMap = 1;
            Sounds.clipMusic.stop();
            Sounds.loadSong(Sounds.cantinaBand);
        }else if(e.getSource() == win.getlvl2()){
            Main.selectedMap = 2;
            Sounds.clipMusic.stop();
            Sounds.loadSong(Sounds.haloAccordion);
        }else if(e.getSource() == win.getlvl3()){
            Main.selectedMap = 3;
            Sounds.clipMusic.stop();
            Sounds.loadSong(Sounds.theEntertainer);
        }else if(e.getSource() == win.getlvl4()){
            Main.selectedMap = 4;
            Sounds.clipMusic.stop();
            Sounds.loadSong(Sounds.theEntertainer);
        }else if(e.getSource() == win.getNewGunTower()){
            Main.menuButton = 1;
        }else if(e.getSource() == win.getNewMissileTower()){
            Main.menuButton = 2;
        }else if(e.getSource() == win.getNewLaserTower()){
            Main.menuButton = 3;
        }else if(e.getSource() == win.getNewFlameTower()){
            Main.menuButton = 4;
        }else if(e.getSource() == win.getNewSmallBomb()){
            Main.menuButton = 5;
        }else if(e.getSource() == win.getNewBigBomb()){
            Main.menuButton = 6;
        }else if(e.getSource() == win.getNextWave()){
        // Ten waves repeat if endless mode is selected becoming progressively harder
            if(waveCount % 10 == 0){
                if (Main.selectedMap == 1){
                    if(Main.iteration == 1)Sounds.loadSound(Sounds.dontLikeSand); // Sound effect
                    else if(Main.iteration == 2)Sounds.loadSound(Sounds.shootHerOrSomething); // Sound effect
                    else Sounds.loadSound(Sounds.liar);// Sound effect
                } else if (Main.selectedMap == 2){
                    //if(Main.iteration == 1)
                    Sounds.loadSound(Sounds.eliteAlert); // Sound effect
                    //else if(Main.iteration == 2)Sounds.loadSound(Sounds.shootHerOrSomething); // Sound effect
                    //else Sounds.loadSound(Sounds.liar);// Sound effect
                } else if (Main.selectedMap == 3) {
                    if(Main.iteration == 1)Sounds.loadSound(Sounds.tonightUhTurner); // Sound effect
                    else Sounds.loadSound(Sounds.areYouWithMePark);
                    Main.CSTeacherTurn++;
                } else {
                    Sounds.loadSound(Sounds.knockKnock);
                }

                Main.gameData.EnemiesSpawned = false;
                for(int i=0;i<7+waveCount;i++){
                    if (Main.selectedMap == 1 || Main.selectedMap == 2){
                        Main.addMediumEnemyWithListener(-100*i, 89, 3*(waveCount+1), 3*Main.iteration);
                    } else {
                        Main.addMediumEnemyWithListener(-100*i, 71, 3*(waveCount+1), 3*Main.iteration);
                    }
                }
                Main.gameData.EnemiesSpawned = true;
                Main.win.getNextWave().setEnabled(false);
            }else if(waveCount % 10 == 1){
                if (Main.selectedMap == 1){
                    if(Main.iteration == 1)Sounds.loadSound(Sounds.takingHimNow); // Sound effect
                    else if(Main.iteration == 2) Sounds.loadSound(Sounds.fineAddition);// Sound effect
                    else Sounds.loadSound(Sounds.hate);// Sound effect
                }else if (Main.selectedMap == 2){
                    //if(Main.iteration == 1)
                    Sounds.loadSound(Sounds.noTime); // Sound effect
                    //else if(Main.iteration == 2)Sounds.loadSound(Sounds.shootHerOrSomething); // Sound effect
                    //else Sounds.loadSound(Sounds.liar);// Sound effect
                } else if (Main.selectedMap == 3) {
                    if(Main.iteration == 1)Sounds.loadSound(Sounds.test2Park); // Sound effect
                    else Sounds.loadSound(Sounds.andHereWeAreTurner);
                    Main.CSTeacherTurn++;
                } else {
                    Sounds.loadSound(Sounds.WhosThereShrek);
                }
                Main.gameData.EnemiesSpawned = false;
                for(int i=0;i<10+waveCount;i++){
                    if (Main.selectedMap == 1 || Main.selectedMap == 2){
                        Main.addSmallEnemyWithListener(-60*i, 89, 1+waveCount, 4*Main.iteration);
                    } else {
                        Main.addSmallEnemyWithListener(-60*i, 71, 1+waveCount, 4*Main.iteration);
                    }
                }
                Main.gameData.EnemiesSpawned = true;
                Main.win.getNextWave().setEnabled(false);
            }else if(waveCount % 10 == 2){
                if (Main.selectedMap == 1) {
                    if (Main.iteration == 1) Sounds.loadSound(Sounds.dontTryIt); // Sound effect
                    else if (Main.iteration == 2) Sounds.loadSound(Sounds.podracing);// Sound effect
                    else Sounds.loadSound(Sounds.itsOver);// Sound effect
                } else if (Main.selectedMap == 2){
                    //if(Main.iteration == 1)
                    Sounds.loadSound(Sounds.hurryChief); // Sound effect
                    //else if(Main.iteration == 2)Sounds.loadSound(Sounds.shootHerOrSomething); // Sound effect
                    //else Sounds.loadSound(Sounds.liar);// Sound effect
                } else if (Main.selectedMap == 3) {
                    if(Main.iteration == 1)Sounds.loadSound(Sounds.doubleClickSung); // Sound effect
                    else Sounds.loadSound(Sounds.heresAnExampleTurner);
                    Main.CSTeacherTurn++;
                } else {
                    Sounds.loadSound(Sounds.ShrekWho);
                }
                Main.gameData.EnemiesSpawned = false;
                for(int i=0;i<1+waveCount;i++){
                    if (Main.selectedMap == 1 || Main.selectedMap == 2){
                        Main.addLargeEnemyWithListener(-100*i, 89, 25*Main.iteration, 2*Main.iteration);
                    } else {
                        Main.addLargeEnemyWithListener(-100*i, 71, 25*Main.iteration, 2*Main.iteration);
                    }
                }
                Main.gameData.EnemiesSpawned = true;
                Main.win.getNextWave().setEnabled(false);
            }else if(waveCount % 10 == 3){
                if (Main.selectedMap == 1){
                    if(Main.iteration == 1)Sounds.loadSound(Sounds.notJustTheMen); // Sound effect
                    else if (Main.iteration == 2){
                        Sounds.loadSound(Sounds.weGotEem);// Sound effect
                    }else {
                        Sounds.loadSound(Sounds.treason);// Sound effect
                    }
                }else if (Main.selectedMap == 2){
                    //if(Main.iteration == 1)
                    Sounds.loadSound(Sounds.whatTheLadiesLike); // Sound effect
                    //else if(Main.iteration == 2)Sounds.loadSound(Sounds.shootHerOrSomething); // Sound effect
                    //else Sounds.loadSound(Sounds.liar);// Sound effect
                } else if (Main.selectedMap == 3) {
                    if(Main.iteration == 1)Sounds.loadSound(Sounds.youCanDoThisQian); // Sound effect
                    else Sounds.loadSound(Sounds.severalPartsTurner);
                    Main.CSTeacherTurn++;
                } else {
                    Sounds.loadSound(Sounds.getOutOfMySwamp);
                }
                Main.gameData.EnemiesSpawned = false;
                for(int i=0;i<10+waveCount;i++){
                    if (Main.selectedMap == 1 || Main.selectedMap == 2) {
                        Main.addMediumEnemyWithListener(-80 * i, 89, 2 * waveCount, 3 * Main.iteration);
                    } else {
                        Main.addMediumEnemyWithListener(-80 * i, 71, 2 * waveCount, 3 * Main.iteration);
                    }
                }
                Main.gameData.EnemiesSpawned = true;
                Main.win.getNextWave().setEnabled(false);
            }else if(waveCount % 10 == 4){
                if (Main.selectedMap == 1){
                    if(Main.iteration == 1)Sounds.loadSound(Sounds.shortNegotiations); // Sound effect
                    else Sounds.loadSound(Sounds.darthPlag);// Sound effect
                }else if (Main.selectedMap == 2){
                    //if(Main.iteration == 1)
                    Sounds.loadSound(Sounds.whatTheLadiesLike); // Sound effect
                    //else if(Main.iteration == 2)Sounds.loadSound(Sounds.shootHerOrSomething); // Sound effect
                    //else Sounds.loadSound(Sounds.liar);// Sound effect
                } else if (Main.selectedMap == 3) {
                    if(Main.iteration == 1)Sounds.loadSound(Sounds.gainsControlMcD); // Sound effect
                    else Sounds.loadSound(Sounds.httpsPark);
                    Main.CSTeacherTurn++;
                } else {
                    Sounds.loadSound(Sounds.getOutOfMySwamp);
                }
                Main.gameData.EnemiesSpawned = false;
                for(int i=0;i<15+waveCount;i++){
                    if (Main.selectedMap == 1 || Main.selectedMap == 2) {
                        Main.addSmallEnemyWithListener(-60*i, 89, 2+waveCount, 5*Main.iteration);
                    } else {
                        Main.addSmallEnemyWithListener(-60*i, 71, 2+waveCount, 5*Main.iteration);
                    }
                }
                Main.gameData.EnemiesSpawned = true;
                Main.win.getNextWave().setEnabled(false);
            }else if(waveCount % 10 == 5){
                if (Main.selectedMap == 1){
                    if(Main.iteration == 1)Sounds.loadSound(Sounds.simpleMan); // Sound effect
                    else Sounds.loadSound(Sounds.takeASeat);// Sound effect
                }else if (Main.selectedMap == 2){
                    //if(Main.iteration == 1)
                    Sounds.loadSound(Sounds.whatTheLadiesLike); // Sound effect
                    //else if(Main.iteration == 2)Sounds.loadSound(Sounds.shootHerOrSomething); // Sound effect
                    //else Sounds.loadSound(Sounds.liar);// Sound effect
                } else if (Main.selectedMap == 3) {
                    if(Main.iteration == 1)Sounds.loadSound(Sounds.potentialProblem20000ErrorsTurner); // Sound effect
                    else Sounds.loadSound(Sounds.two4681012Turner);
                    Main.CSTeacherTurn++;
                } else {
                    Sounds.loadSound(Sounds.getOutOfMySwamp);
                }
                Main.gameData.EnemiesSpawned = false;
                for(int i=0;i<1+waveCount;i++) {
                    if (Main.selectedMap == 1 || Main.selectedMap == 2) {
                        Main.addLargeEnemyWithListener(-100 * i, 89, 25 * Main.iteration + waveCount, 3 * Main.iteration);
                    } else {
                        Main.addLargeEnemyWithListener(-100 * i, 71, 25 * Main.iteration + waveCount, 3 * Main.iteration);
                    }
                }
                Main.gameData.EnemiesSpawned = true;
                Main.win.getNextWave().setEnabled(false);
            }else if(waveCount % 10 == 6){
                if (Main.selectedMap == 1){
                    if(Main.iteration == 1)Sounds.loadSound(Sounds.tooDangerous); // Sound effect
                    else Sounds.loadSound(Sounds.gangstas);// Sound effect
                }else if (Main.selectedMap == 2){
                    //if(Main.iteration == 1)
                    Sounds.loadSound(Sounds.whatTheLadiesLike); // Sound effect
                    //else if(Main.iteration == 2)Sounds.loadSound(Sounds.shootHerOrSomething); // Sound effect
                    //else Sounds.loadSound(Sounds.liar);// Sound effect
                } else if (Main.selectedMap == 3) {
                    //if(Main.iteration == 1)
                    Sounds.loadSound(Sounds.areYouWithMePark); // Sound effect
                    Main.CSTeacherTurn++;
                } else {
                    Sounds.loadSound(Sounds.getOutOfMySwamp);
                }
                Main.gameData.EnemiesSpawned = false;
                for(int i=0;i<15+waveCount;i++){
                    if (Main.selectedMap == 1 || Main.selectedMap == 2) {
                        Main.addMediumEnemyWithListener(-80 * i, 89, 10 + waveCount, 4 * Main.iteration);
                    } else {
                        Main.addMediumEnemyWithListener(-80 * i, 71, 10 + waveCount, 4 * Main.iteration);
                    }
                }
                Main.gameData.EnemiesSpawned = true;
                Main.win.getNextWave().setEnabled(false);
            }else if(waveCount % 10 == 7){
                if (Main.selectedMap == 1){
                    if(Main.iteration == 1)Sounds.loadSound(Sounds.tooWeak); // Sound effect
                    else Sounds.loadSound(Sounds.againstMe);// Sound effect
                }else if (Main.selectedMap == 2){
                    //if(Main.iteration == 1)
                    Sounds.loadSound(Sounds.whatTheLadiesLike); // Sound effect
                    //else if(Main.iteration == 2)Sounds.loadSound(Sounds.shootHerOrSomething); // Sound effect
                    //else Sounds.loadSound(Sounds.liar);// Sound effect
                } else if (Main.selectedMap == 3) {
                    //if(Main.iteration == 1)
                    Sounds.loadSound(Sounds.greenTriangleSung); // Sound effect
                    Main.CSTeacherTurn++;
                } else {
                    Sounds.loadSound(Sounds.getOutOfMySwamp);
                }
                Main.gameData.EnemiesSpawned = false;
                for(int i=0;i<15+waveCount;i++){
                    if (Main.selectedMap == 1 || Main.selectedMap == 2) {
                        Main.addSmallEnemyWithListener(-80 * i, 89, waveCount, 5 * Main.iteration);
                    } else {
                        Main.addSmallEnemyWithListener(-80 * i, 71, waveCount, 5 * Main.iteration);
                    }
                }
                Main.gameData.EnemiesSpawned = true;
                Main.win.getNextWave().setEnabled(false);
            }else if(waveCount % 10 == 8){
                if (Main.selectedMap == 1){
                    if(Main.iteration == 1)Sounds.loadSound(Sounds.noDangerAtAll); // Sound effect
                    else Sounds.loadSound(Sounds.doneThatYourself);// Sound effect
                }else if (Main.selectedMap == 2){
                    //if(Main.iteration == 1)
                    Sounds.loadSound(Sounds.whatTheLadiesLike); // Sound effect
                    //else if(Main.iteration == 2)Sounds.loadSound(Sounds.shootHerOrSomething); // Sound effect
                    //else Sounds.loadSound(Sounds.liar);// Sound effect
                } else if (Main.selectedMap == 3) {
                    //if(Main.iteration == 1)
                    Sounds.loadSound(Sounds.justSkipSung); // Sound effect
                    Main.CSTeacherTurn++;
                } else {
                    Sounds.loadSound(Sounds.getOutOfMySwamp);
                }
                Main.gameData.EnemiesSpawned = false;
                for(int i=0;i<waveCount;i++) {
                    if (Main.selectedMap == 1 || Main.selectedMap == 2) {
                        Main.addLargeEnemyWithListener(-70 * i, 89, 25*Main.iteration+waveCount, 4*Main.iteration);
                    } else {
                        Main.addLargeEnemyWithListener(-70 * i, 71, 25*Main.iteration+waveCount, 4*Main.iteration);
                    }
                }
                Main.gameData.EnemiesSpawned = true;
                Main.win.getNextWave().setEnabled(false);
            }else if(waveCount % 10 == 9){
                if (Main.selectedMap == 1){

                }else if (Main.selectedMap == 2){
                    //if(Main.iteration == 1)
                    Sounds.loadSound(Sounds.whatTheLadiesLike); // Sound effect
                    //else if(Main.iteration == 2)Sounds.loadSound(Sounds.shootHerOrSomething); // Sound effect
                    //else Sounds.loadSound(Sounds.liar);// Sound effect
                } else if (Main.selectedMap == 3) {
                    //if(Main.iteration == 1)
                    Sounds.loadSound(Sounds.comprehensiveFinalQian); // Sound effect
                } else {
                    Sounds.loadSound(Sounds.getOutOfMySwamp);
                }
                if(!Main.win.selectedEndless()){
                    Main.lastWave = true;
                }
                Main.gameData.EnemiesSpawned = false;
                for(int i = 0; i < Main.iteration; i++) {
                    if (Main.selectedMap == 1 || Main.selectedMap == 2) {
                        Main.addBossEnemyWithListener(0, 89, 1500*Main.iteration, Main.iteration);
                    } else {
                        Main.addBossEnemyWithListener(0, 71, 1500*Main.iteration, Main.iteration);
                    }
                }
                Main.gameData.EnemiesSpawned = true;
                Main.iteration++;
            }
            waveCount++;
            Main.win.getNextWave().setText("Next Wave: #" + getWaveCount());
        }
    }

    public static int getWaveCount() {
        return waveCount+1;
    }
}
