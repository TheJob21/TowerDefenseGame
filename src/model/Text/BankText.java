package model.Text;

import controller.Main;

import java.awt.*;

public class BankText extends Text {

    public BankText(String text, int x, int y, Color color, Font font){
        super(text,x,y,color,font);
    }
    @Override
    public void update() {
        text = "Bank: $" + Integer.toString(Main.user.getBank());
    }

}
