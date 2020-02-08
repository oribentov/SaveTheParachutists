package controller;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ArenaController extends JPanel implements GeneralData {


    private Arena arena;

    private boolean isRunning;

    public ArenaController(Arena arena){
        this.arena = arena;
        this.isRunning = false;
    }

    public void updateGame() {
        Boat boat = arena.getPlayer().getBoat();
        Plane plane = arena.getPlane();
        ArrayList<PlaneDrop> planeDrops = arena.getPlaneDrops();
        Player player = arena.getPlayer();
        updatePlane(plane);

        if(plane.getX() < 0){
            plane.setSpeed(getRandomSpeed());
            plane.setX(GAME_WIDTH);
        }

        if(plane.getX() == (new Random().nextInt(GAME_WIDTH - 50) + 50) || (plane.getX() == new Random().nextInt(GAME_WIDTH / (2 * 3) - 50) + 50) || (plane.getX() == new Random().nextInt(GAME_WIDTH / (1 * 3) - 50) + 50)){
            planeDrops.add(new Parachutist(plane.getX(), plane.getY(), getRandomSpeed(), new ImageIcon(getClass().getResource("../images/parachutist.png")).getImage()));
           // System.out.println("plane.getX(): " + plane.getX());
           // System.out.println("plane.getY(): " + plane.getY());
        }

        for(int i = 0; i < planeDrops.size(); i++){
            PlaneDrop planeDrop = planeDrops.get(i);
            updatePlaneDrop(planeDrop);

            if(boat.getBound().intersects(planeDrop.getBound())){
                player.setScore(player.getScore() + 10);
                System.out.println("score: " + player.getScore());
                planeDrops.remove(planeDrop);
            } else{
                if(planeDrop.getY() == GAME_HEIGHT - 50){
                    player.setLife(player.getLife() -1);
                    System.out.println("life: " + player.getLife());
                    if(player.getLife() > 0){
                        planeDrops.remove(planeDrop);
                    } else if(player.getLife() == 0){
                        isRunning = false;
                    }
                }
            }
        }
    }

    protected void updatePlane(Plane plane){
        plane.setX(plane.getX() - plane.getSpeed());
    }

    protected void updatePlaneDrop(PlaneDrop planeDrop){
        planeDrop.setY(planeDrop.getY() + planeDrop.getSpeed());
    }

    protected int getRandomSpeed() {
        return new Random().nextInt(4) + 2;
    }

    protected void moveBoatLeft(){
        Boat boat = arena.getPlayer().getBoat();

        if(boat.getX() < 0){
            return;
        }
        boat.setX(boat.getX() - boat.getSpeed());
        increaseSpeed(boat);
       // System.out.println("move left");
    }

    protected void moveBoatRight(){
        Boat boat = arena.getPlayer().getBoat();

        if(boat.getX() > GAME_WIDTH - (boat.getBound().width / 2)){
            return;
        }
        boat.setX(boat.getX() + boat.getSpeed());
        increaseSpeed(boat);
       // System.out.println("move right");
    }

    public void increaseSpeed(GameComponent gameComponent){
        if(gameComponent.getSpeed() < MAX_SPEED){
            gameComponent.setSpeed(gameComponent.getSpeed() + 1);
        }
    }

    protected void resetSpeed(GameComponent gameComponent){
        gameComponent.setSpeed(5);
    }

    protected void renderGame() {
        repaint();
    }

    public Arena getArena() {
        return arena;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void init() {
        this.isRunning = true;
    }
}
