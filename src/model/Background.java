package model;

import java.awt.*;

public class Background extends GameComponent{

    public Background(int x, int y, Image image){
        super(x, y, 0, image);
    }

    @Override
    public Rectangle getBound() {
        return null;
    }
}
