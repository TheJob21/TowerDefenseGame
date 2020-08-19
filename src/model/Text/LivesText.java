package model.Text;

import controller.Main;

import java.awt.*;

public class LivesText extends Text {

    public LivesText(String text, int x, int y, Color color, Font font){
        super(text,x,y,color,font);
    }

    @Override
    public void update() {
        text = "Lives: " + Integer.toString(Main.user.getLives());
    }

}
