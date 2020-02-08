package controller;

import model.*;
import view.GameViewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameEngine extends JPanel implements KeyListener, GeneralData, Runnable {

    private Thread gameThread;
    private Arena arena;
    private Player player;
    private Boat boat;
    private Plane plane;
    private ArenaController arenaController;
    private GameViewer gameViewer;


    public GameEngine(){

        this.addKeyListener(this);
        //setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();
        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));

        // configure data objects
        this.plane = new Plane(GAME_WIDTH, 20, getRandomSpeed(), new ImageIcon(getClass().getResource("../images/plane.png")).getImage());
        this.boat = new Boat(GAME_WIDTH / 2, GAME_HEIGHT - 150, 3, new ImageIcon(getClass().getResource("../images/boat3.png")).getImage());
        this.player = new Player();
        player.setBoat(boat);
        arena = new Arena(player, plane);
        arenaController = new ArenaController(arena);
        gameViewer = new GameViewer(arenaController);
    }


    @Override
    public void addNotify(){
        super.addNotify();
        if(gameThread == null){
            gameThread = new Thread(this);
        }
        gameThread.start();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        System.out.println("typed");
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT){
            arenaController.moveBoatLeft();
        } else if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT){
            arenaController.moveBoatRight();
        } else {

        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
     //   System.out.println("released");
        arenaController.resetSpeed(boat);
    }

    protected int getRandomSpeed() {
        return new Random().nextInt(4) + 2;
    }


    @Override
    public void run() {
        arenaController.init();
        long waitTime = 0;

        //BufferedImage screen = new BufferedImage(GAME_WIDTH*2, GAME_WIDTH, BufferedImage.TYPE_INT_RGB);
        Graphics g = this.getGraphics();
       // gameViewer.paintComponent(g);


        while(arenaController.isRunning()){
            long startTime = System.currentTimeMillis();

            gameViewer.paintComponent(g);
            //repaint();
            update();
            arenaController.renderGame();

            long endTime = System.currentTimeMillis() - startTime;
            waitTime = (MILLISECOND / FPS) - endTime / MILLISECOND;

            try{
                Thread.sleep(waitTime);
            } catch (Exception e){}

        }
        if(!arenaController.isRunning()){
            gameViewer.drawGameOver(g);
        }
    }


    public void update(){
        this.arenaController.updateGame();
    }

    public GameViewer getGameViewer() {
        return gameViewer;
    }
}
