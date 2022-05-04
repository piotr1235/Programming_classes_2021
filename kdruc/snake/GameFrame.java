package Programming_classes_2021.kdruc.snake;

import Programming_classes_2021.kdruc.gameoflife.OutOfBounds;

import javax.swing.*;

public class GameFrame extends JFrame{
    GameFrame() throws OutOfBounds {
        GamePanel gamePanel = new GamePanel();

        this.add(gamePanel);
        this.setTitle("snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
