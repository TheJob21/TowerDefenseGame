package model.Bomb;

import model.Sounds;

import java.awt.*;

public class bigBomb extends Bomb {
    public static final int PRICE = 75;
    public static final int RANGE = 60;
    public static final int INIT_BOMB_SIZE = 5;

    int size = INIT_BOMB_SIZE;
    Color color;

    public bigBomb(float x, float y) {
        super(x, y, RANGE, PRICE);
        color = Color.RED;
        Sounds.loadSound(Sounds.explosion2);
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(color);
        g2.setStroke(new BasicStroke(1)); // thickness
        g2.fillOval((int) super.location.x - size / 2, (int) super.location.y - size / 2, size, size);
    }

    @Override
    public void update() {
        updateState();
        size += 6;
    }

    private void updateState() {
        if (size >= RANGE) {
            super.done = true;
        }
    }

    @Override
    public int getCollisionRadius() {
        return size/2;
    }

    @Override
    protected double getCollisionAngle() {
        return 0;
    }
}
