package view;

import controller.ArenaController;
import controller.GameEngine;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class GameViewer extends JPanel implements GeneralData {

    private ArenaController arenaController;
    private Background background;

    public GameViewer(ArenaController arenaController){
        //this.addKeyListener(this);
        //setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();
        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.arenaController = arenaController;
        this.background = new Background(0, 0, new ImageIcon(getClass().getResource("../images/background.jpg")).getImage());

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
       //draw(g2D);
        drawComponent(background, g2D);
        drawComponent(arenaController.getArena().getPlane(), g2D);
        drawComponent(arenaController.getArena().getPlayer().getBoat(), g2D);

        ArrayList<PlaneDrop> planeDrops = arenaController.getArena().getPlaneDrops();
        for(PlaneDrop planeDrop : planeDrops){
            drawComponent(planeDrop, g2D);
        }
        System.out.println("drawing");
        g2D.drawString("Life: " + arenaController.getArena().getPlayer().getLife(), 10, 30);
        g2D.drawString("Score: " + arenaController.getArena().getPlayer().getScore(), GAME_WIDTH - 50, 30);
        repaint();
    }


    public void draw(Graphics2D g2D){
        drawComponent(background, g2D);
        drawComponent(arenaController.getArena().getPlane(), g2D);
        drawComponent(arenaController.getArena().getPlayer().getBoat(), g2D);

        ArrayList<PlaneDrop> planeDrops = arenaController.getArena().getPlaneDrops();
        for(PlaneDrop planeDrop : planeDrops){
            drawComponent(planeDrop, g2D);
        }
        System.out.println("drawing");
        g2D.drawString("Life: " + arenaController.getArena().getPlayer().getLife(), 10, 30);
        g2D.drawString("Score: " + arenaController.getArena().getPlayer().getScore(), GAME_WIDTH - 50, 30);
       repaint();
    }

    public void drawGameOver(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawString("GAME OVER", 100, 50);
    }

    public void drawComponent(GameComponent gameComponent, Graphics2D g2D){
        g2D.drawImage(gameComponent.getImage(), gameComponent.getX(), gameComponent.getY(), null);
    }
}
