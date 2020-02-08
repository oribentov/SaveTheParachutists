import controller.GameEngine;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.BufferedImage;

import static model.GeneralData.*;

public class Game extends Applet implements Runnable {
    private GameEngine engine = new GameEngine();

    public void start() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        //engine.init();
        setSize(GAME_WIDTH, GAME_WIDTH);
        long waitTime = 0;

        BufferedImage screen = new BufferedImage(GAME_WIDTH, GAME_WIDTH, BufferedImage.TYPE_INT_RGB);
        Graphics g = screen.getGraphics();
        Graphics appletGraphics = getGraphics();

        while(true){
            long startTime = System.currentTimeMillis();


            engine.update();
            engine.getGameViewer().paintComponent(g);
            //arenaController.updateGame();
            //arenaController.renderGame();
            appletGraphics.drawImage(screen, 0, 0, null);

            long endTime = System.currentTimeMillis() - startTime;
            waitTime = (MILLISECOND / FPS) - endTime / MILLISECOND;

            try{
                Thread.sleep(waitTime);
            } catch (Exception e){}

        }
    }

}
