import controller.GameEngine;
import model.Arena;
import model.GeneralData;

import javax.swing.*;
import java.awt.*;

public class Program {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame gameFrame = new JFrame(("Save The Soldiers"));
                gameFrame.add(new GameEngine());
               // gameFrame.add(new Game());
                gameFrame.setResizable(false);
                gameFrame.pack();
                gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameFrame.setLocationRelativeTo(null);
                gameFrame.setVisible(true);
            }
        });
    }
}
