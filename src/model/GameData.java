package model;

import java.util.ArrayList;

public class GameData {

    public ArrayList<GameFigure> textObject = new ArrayList<>();
    public ArrayList<GameFigure> mouseObject = new ArrayList<>();
    public ArrayList<GameFigure> fixedObject = new ArrayList<>();
    public ArrayList<GameFigure> friendObject = new ArrayList<>();
    public ArrayList<GameFigure> enemyObject = new ArrayList<>();
    public ArrayList<GameFigure> lineObject = new ArrayList<>();
    public boolean EnemiesSpawned;
    public static int killCount1 = 0;
    public static int killCount2 = 0;
    public static int killCount3 = 0;
    public static int killCount4 = 0;

    public void update(){
        ArrayList<GameFigure> remove = new ArrayList<>();
        for(GameFigure fig: fixedObject){
            fig.update();
            if (fig.done) remove.add(fig);
        }
        fixedObject.removeAll(remove);

        remove.clear();
        for(GameFigure fig: mouseObject){
            fig.update();
            if (fig.done) remove.add(fig);
        }
        mouseObject.removeAll(remove);

        remove.clear();
        for(GameFigure fig: friendObject){
            fig.update();
            if (fig.done) remove.add(fig);
        }
        friendObject.removeAll(remove);

        remove.clear();
        for(GameFigure fig: textObject){
            fig.update();
            if (fig.done) remove.add(fig);
        }
        textObject.removeAll(remove);

        remove.clear();
        for(GameFigure fig: enemyObject){
            fig.update();
            //if(fig.location.x < 0)
            //    EnemiesSpawned = false;
            if (fig.done) remove.add(fig);
        }
        //EnemiesSpawned = true;
        enemyObject.removeAll(remove);

        remove.clear();
        for(GameFigure fig: lineObject){
            fig.update();
            if (fig.done) remove.add(fig);
        }
        lineObject.removeAll(remove);
    }

    public void updateEnemies(){
        ArrayList<GameFigure> remove = new ArrayList<>();
        for(GameFigure fig: enemyObject){
            fig.update();
            if (fig.done) remove.add(fig);
        }
        enemyObject.removeAll(remove);
    }

    public void clear() {
        fixedObject.clear();
        friendObject.clear();
        enemyObject.clear();
        lineObject.clear();
        textObject.clear();
        mouseObject.clear();
    }
}
