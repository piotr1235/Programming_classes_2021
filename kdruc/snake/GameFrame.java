package kdruc.snake;

import kdruc.gameoflife.OutOfBounds;

import javax.swing.*;

public class GameFrame extends JFrame{
    GameFrame() throws OutOfBounds, InterruptedException {
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
