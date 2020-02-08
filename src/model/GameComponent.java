package model;


import java.awt.*;
import java.util.Observable;

public abstract class GameComponent extends Observable {
    private int x;
    private int y;
    private int speed;

    protected final Image image;

    public GameComponent(int x, int y, int speed, Image image) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        notifyObservers();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        notifyObservers();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        notifyObservers();
    }

    public Image getImage() {
        return image;
    }

    public abstract Rectangle getBound();

}
