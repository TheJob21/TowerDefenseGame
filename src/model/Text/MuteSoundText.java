package model.Text;

import model.Sounds;
import java.awt.*;

public class MuteSoundText extends Text {
    public MuteSoundText(String text, int x, int y, Color color, Font font) {
        super(text, x, y, color, font);
    }
    @Override
    public void update() {
        if(Sounds.soundsMuted)
            text = "Sounds Muted";
        else
            text = "Mute Sounds";
    }
}
