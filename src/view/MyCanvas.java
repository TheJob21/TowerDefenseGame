package view;

import controller.Main;
import model.GameFigure;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MyCanvas extends JPanel {

    public void render(){
    // off-screen double buffer image
        BufferedImage map = null;
        if (Main.selectedMap == 1 || Main.selectedMap == 4) {
            try { // Gets map 1 to display on screen background
                map = ImageIO.read(new File("../TermProject/src/Images/map.jpg"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try { // Gets map 2 to display on screen background
                map = ImageIO.read(new File("../TermProject/src/Images/map2.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (map == null){
            System.out.println("Critical error: doubleBufferImage is null");
            System.exit(1);
        }

    // off-screen rendering
        Graphics2D g2OffScreen = (Graphics2D) map.getGraphics();
        if (g2OffScreen == null){
            System.out.println("Critical error: g2OffScreen is null");
            System.exit(1);
        }

    // render all game data!!
        for (GameFigure fig: Main.gameData.textObject){
            fig.render(g2OffScreen);
        }
        for (GameFigure fig: Main.gameData.mouseObject){
            fig.render(g2OffScreen);
        }
        for (GameFigure fig: Main.gameData.fixedObject){
            fig.render(g2OffScreen);
        }
        for(GameFigure fig: Main.gameData.friendObject){
            fig.render(g2OffScreen);
        }
        for(GameFigure fig: Main.gameData.enemyObject){
            fig.render(g2OffScreen);
        }
        for(GameFigure fig: Main.gameData.lineObject){
            fig.render(g2OffScreen);
        }

    // use active rendering to put the buffer image on screen
        Graphics gOnScreen;
        gOnScreen = this.getGraphics();
        if(gOnScreen != null) {
        // copy offScreen image to onScreen
            gOnScreen.drawImage(map,0,0,null);
        }
        Toolkit.getDefaultToolkit().sync(); // sync the display on certain systems
        if (gOnScreen != null){
            gOnScreen.dispose();
        }
    }
}
