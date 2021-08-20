package controller;

import model.*;
import model.Enemies.CSDepartment.*;
import model.Enemies.Halo.Banshee;
import model.Enemies.Halo.Ghost;
import model.Enemies.Halo.Wraith;
import model.Enemies.StarWars.DeathStar;
import model.Enemies.StarWars.MTT;
import model.Enemies.StarWars.ATT;
import model.Enemies.StarWars.STAP;
import model.Text.*;
import view.MyWindow;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static MyWindow win;
    public static GameData gameData;
    public static PlayerInputEventQueue playerInputEventQueue;
    public static boolean running;
    public static User user; // Contains lives and money
    public static int menuButton = 0; // Stores selected menu button
    public static int iteration = 1; // stores tens of waves completed
    public static int FPS = 20; // 60 FPS
    private static Font font = new Font("Callibri", Font.BOLD, 16);
    static boolean lastWave = false;
    private static String difficulty;
    public static Images images = new Images();
    public static Sounds sounds = new Sounds();
    public static int selectedMap = 1;
    public static int CSTeacherTurn = 0;

    public static void main(String[] args){
        win = new MyWindow();
        Sounds.loadSound(Sounds.honored); // Sound effect
        win.init();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);

        gameData = new GameData();
        playerInputEventQueue = new PlayerInputEventQueue();

        running = false;

        startScreen();

        initGame();

        gameLoop();
    }

    public static void startScreen() {
        gameData.clear();
    // Start music and create mute button and mouse cursor
        Main.win.canvas.render();
        gameData.textObject.add(new MuteSongText("Mute Song", 930, 15, Color.RED, font));
        gameData.mouseObject.add(new MousePointer(0,0));
        try {
            Thread.sleep(1750);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // Play start screen music
        if (!Sounds.clipMusic.isActive())
            Sounds.loadSong(Sounds.cantinaBand);

        while(!running) { // Start screen loop
        // Needed to process mute function
            playerInputEventQueue.processInputEvents();
        // Updating and rendering mute button
            gameData.update();
            win.canvas.render();
            if(Sounds.songMuted){ //Stop music when muted
                Sounds.clipMusic.stop();
            }
        // Run at 60FPS so that music stops and starts faster when muted
            long startTime = System.currentTimeMillis();
            long endTime = System.currentTimeMillis();

            long timeSpent = endTime-startTime;
            long sleepTime = (long) (1000.0 / FPS - timeSpent);
            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    // finish when running == true;
    }

    private static void initGame(){
        gameData.clear();
        Sounds.clipMusic.stop();
        if(win.selectedDifficulty() == 0) difficulty = "Easy";
        else if(win.selectedDifficulty() == 1) difficulty = "Medium";
        else difficulty = "Hard";
        // Initialize text to display bank, lives, and mute
        gameData.textObject.add(new BankText("Bank: $" + Integer.toString(user.getBank()), 10, 15, Color.CYAN, font));
        gameData.textObject.add(new LivesText("Lives: " + Integer.toString(user.getBank()), 10, 30, Color.CYAN, font));
        gameData.textObject.add(new MuteSongText("Mute Song", 930, 15, Color.RED, font));
        gameData.textObject.add(new MuteSoundText("Mute Sounds", 930, 30, Color.RED, font));
        gameData.textObject.add(new GenText("Next Song", 930, 45, Color.RED, font));
        gameData.textObject.add(new GameSpeedText("1.0X Speed", 10, 45, Color.CYAN, font));
        // Initialize mouse
        gameData.mouseObject.add(new MousePointer(0,0));
    }

    private static void gameLoop(){
        running = true;

        Sounds.clipMusic.stop();
        if (selectedMap == 1)
            Sounds.song = 0;
        else if (selectedMap == 2)
            Sounds.song = 4;
        else
            Sounds.song = 6;
        Sounds.playSong();
        Main.gameData.EnemiesSpawned = true;

        // game loop
        while (running){
            if(!Sounds.clipMusic.isActive() && !Sounds.songMuted && !Sounds.clip.isActive())
                Sounds.playSong();

            long startTime = System.currentTimeMillis();

            playerInputEventQueue.processInputEvents();
            processCollisions();
            gameData.update();
            win.canvas.render();

            if(Sounds.songMuted){
                Sounds.clipMusic.stop();
            }if(Sounds.soundsMuted){
                Sounds.clip.stop();
            }

            if (user.getLives() <= 0){
                gameOver();
            }else if(!win.getNextWave().isEnabled() && gameData.enemyObject.isEmpty() && gameData.EnemiesSpawned){
                gameOver();
            }

            if (gameData.EnemiesSpawned && !lastWave)
                win.getNextWave().setEnabled(true);
            else
                win.getNextWave().setEnabled(false);

            long endTime = System.currentTimeMillis();

            long timeSpent = endTime-startTime;
            long sleepTime = (long) (1000.0 / FPS - timeSpent);
            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void gameOver() { // Stops game loop, plays end sound, and prints gameover
        running = false;
        gameData.update();
        win.canvas.render();
        font = new Font("Forte", Font.BOLD, 40);
        if(user.getLives() <= 0) {
            gameData.textObject.add(new GenText("Game Over", 440, 137, Color.RED, font));
            if (selectedMap == 1) {
                Sounds.loadSound(Sounds.youHaveLost);
            }
        }else {
            gameData.textObject.add(new GenText("You Win!", 440, 137, Color.RED, font));
            if (selectedMap == 1) {
                Sounds.loadSound(Sounds.peaceFreedom);
            }
        }
        gameData.textObject.add(new GenText("Score",495,180, Color.RED, font));
        font = new Font("Callibri", Font.BOLD, 40);
        gameData.textObject.add(new GenText("Difficulty: " + difficulty,400,230, Color.RED, font));
        gameData.textObject.add(new GenText("Light enemies destroyed: " + GameData.killCount1,400,280, Color.RED, font));
        gameData.textObject.add(new GenText("Medium enemies destroyed: " + GameData.killCount2,400,330, Color.RED, font));
        gameData.textObject.add(new GenText("Heavy enemies destroyed: " + GameData.killCount3 ,400,380, Color.RED, font));
        gameData.textObject.add(new GenText("Death Stars destroyed: " + GameData.killCount4,400,430, Color.RED, font));
        gameData.textObject.add(new GenText("Waves survived: " + (ButtonListener.getWaveCount()-1),400,480, Color.RED, font));
        gameData.textObject.add(new GenText("Money spent: " + user.moneySpent,400,530, Color.RED, font));
        win.getNextWave().setEnabled(false);
        while(!running){
            playerInputEventQueue.processInputEvents();
            gameData.updateEnemies();
            win.canvas.render();
            // Run at 60FPS so that music stops and starts faster when muted
            long startTime = System.currentTimeMillis();
            long endTime = System.currentTimeMillis();

            long timeSpent = endTime-startTime;
            long sleepTime = (long) (1000.0 / FPS - timeSpent);
            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    static void addSmallEnemyWithListener(int x, int y, int hp, int sd) { // Creates light enemies
        GameFigure Enemy;
        if (selectedMap == 1) {
            Enemy = new STAP(x,y,hp,sd);
        } else if (selectedMap == 2){
            Enemy = new Ghost(x, y, hp, sd);
        } else {
            if (CSTeacherTurn%5 == 0)Enemy = new DrMcDaniel(x, y, hp, sd);
            else if (CSTeacherTurn%5 == 1)Enemy = new DrTurner(x, y, hp, sd);
            else if (CSTeacherTurn%5 == 2)Enemy = new DrPark(x, y, hp, sd);
            else if (CSTeacherTurn%5 == 3)Enemy = new DrSung(x, y, hp, sd);
            else Enemy = new DrQian(x, y, hp, sd);
        }
        //Enemy.attachListener(new EnemyObserverAddNew());
        gameData.enemyObject.add(Enemy);
    }

    static void addMediumEnemyWithListener(int x, int y, int hp, int sd) { // Creates medium enemies
        GameFigure Enemy;
        if (selectedMap == 1) {
            Enemy = new ATT(x,y,hp,sd);
        } else if (selectedMap == 2) {
            Enemy = new Banshee(x, y, hp, sd);
        } else {
            if (CSTeacherTurn%5 == 0)Enemy = new DrMcDaniel(x, y, hp, sd);
            else if (CSTeacherTurn%5 == 1)Enemy = new DrTurner(x, y, hp, sd);
            else if (CSTeacherTurn%5 == 2)Enemy = new DrPark(x, y, hp, sd);
            else if (CSTeacherTurn%5 == 3)Enemy = new DrSung(x, y, hp, sd);
            else Enemy = new DrQian(x, y, hp, sd);
        }
        //Enemy.attachListener(new EnemyObserverAddNew());
        gameData.enemyObject.add(Enemy);
    }

    static void addLargeEnemyWithListener(int x, int y, int hp, int sd) { // Creates Large enemies
        GameFigure Enemy;
        if (selectedMap == 1) {
            Enemy = new MTT(x,y,hp,sd);
        } else if (selectedMap == 2) {
            Enemy = new Wraith(x, y, hp, sd);
        } else {
            if (CSTeacherTurn%5 == 0)Enemy = new DrMcDaniel(x, y, hp, sd);
            else if (CSTeacherTurn%5 == 1)Enemy = new DrTurner(x, y, hp, sd);
            else if (CSTeacherTurn%5 == 2)Enemy = new DrPark(x, y, hp, sd);
            else if (CSTeacherTurn%5 == 3)Enemy = new DrSung(x, y, hp, sd);
            else Enemy = new DrQian(x, y, hp, sd);
        }
        //Enemy.attachListener(new EnemyObserverAddNew());
        gameData.enemyObject.add(Enemy);
    }

    static void addBossEnemyWithListener(int x, int y, int hp, int sd) { // Creates boss enemy
        GameFigure Enemy;
        if (selectedMap == 1) {
            Enemy = new DeathStar(x,y,hp,sd);
        } else if (selectedMap == 2) {
            Enemy = new Wraith(x, y, hp, sd);
        } else {
            gameData.enemyObject.add(new DrQian(x,y,hp/5,sd));
            gameData.enemyObject.add(new DrPark(x-100,y,hp/5,sd));
            gameData.enemyObject.add(new DrMcDaniel(x-200,y,hp/5,sd));
            gameData.enemyObject.add(new DrTurner(x-300,y,hp/5,sd));
            Enemy = new DrSung(x-400, y, hp/5, sd);
        }
        //Enemy.attachListener(new EnemyObserverAddNew());
        gameData.enemyObject.add(Enemy);
    }

    private static void processCollisions() {
        for(GameFigure friend: Main.gameData.friendObject) { // process enemy collisions with bullets missiles and flames
            for(GameFigure enemy: Main.gameData.enemyObject) {
                if (friend.collideWith(enemy)) {
                    ++friend.hitCount;
                    --enemy.HP;
                }
            }
        }
        for(GameFigure line: Main.gameData.lineObject) { // process enemy collisions with lasers based on angle
            for(GameFigure enemy: Main.gameData.enemyObject) {
                if (line.collideWithLine(enemy)) {
                    --enemy.HP;
                }
            }
        }
    }
}
