package model;

import java.awt.*;

public class Plane extends GameComponent {
    //private final Image image;

    // TODO: change to factory method?
    public Plane(int x, int y, int speed, Image image) {
        super(x, y, speed, image);
       // this.image = image;
    }

    @Override
    public Rectangle getBound(){
        return new Rectangle(getX(), getY(), this.image.getWidth(null), this.image.getHeight(null));
    }
}
