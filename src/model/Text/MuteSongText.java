package model.Text;

import model.Sounds;

import java.awt.*;

public class MuteSongText extends Text{
    public MuteSongText(String text, int x, int y, Color color, Font font) {
        super(text, x, y, color, font);
    }
    @Override
    public void update() {
        if(Sounds.songMuted)
            text = "Song Muted";
        else
            text = "Mute Song";
    }
}
