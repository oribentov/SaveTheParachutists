package view;

import model.GameComponent;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class GameComponentObserver implements Observer {

    @Override
    public void update(Observable observable, Object o) {
        System.out.println("I have been updated");
        try{
            GameComponent gameComponent = (GameComponent) observable;
        } catch (Exception e){

        }
    }

    public void draw(Graphics2D g2D) {
      //  g2D.drawImage(this.image, getX(), getY(), null);
    }

}
