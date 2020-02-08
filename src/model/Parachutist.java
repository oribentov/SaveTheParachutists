package model;

import java.awt.*;

public class Parachutist extends PlaneDrop {
    //private final Image image;

    public Parachutist(int x, int y, int speed, Image image) {
        super(x, y, speed, image);
    }

    @Override
    public Rectangle getBound(){
        return new Rectangle(getX(), getY(), this.image.getWidth(null), this.image.getHeight(null));
    }
}
