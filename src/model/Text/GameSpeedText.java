package model.Text;

import controller.Main;

import java.awt.*;

public class GameSpeedText extends Text {
    public GameSpeedText(String text, int x, int y, Color color, Font font) {
        super(text, x, y, color, font);
    }
    @Override
    public void update() {
        if(Main.FPS == 20)
            text = "1.0X Speed";
        else if(Main.FPS == 30)
            text = "1.5X Speed";
        else if(Main.FPS == 40)
            text = "2.0X Speed";
        else if(Main.FPS == 10)
                text = "0.5X Speed";
    }
}
