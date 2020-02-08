package model;

import java.awt.*;

public class Boat extends GameComponent implements GeneralData {
   // Image image;

    // TODO: change to factory method?
    public Boat(int x, int y, int speed, Image image) {
        super(x, y, speed, image);
    }

    @Override
    public Rectangle getBound(){
        return new Rectangle(getX(), getY(), this.image.getWidth(null), this.image.getHeight(null));
    }

//    @Override
//    public void update() {
//
//    }

//    public void increaseSpeed(){
//        if(getSpeed() < MAX_SPEED){
//            setSpeed(getSpeed() + 1);
//        }
//    }

}
