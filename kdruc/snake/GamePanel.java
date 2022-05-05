package kdruc.snake;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;

import static kdruc.snake.Direction.Right;


public class GamePanel extends JPanel implements ActionListener {

    static int SCREEN_WIDTH = 600;
    static int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 100;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int appleEaten;
    int appleX;
    int appleY;

    int appleExtraX;
    int appleExtraY;
    boolean appleExtraEaten = false;
    Direction direction = Right;
    boolean running = false;
    Timer timer = new Timer(DELAY, this);
    Random random;
    private int appleXRan;


    GamePanel() throws InterruptedException {

        random = new Random();
        Dimension dimension = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
        MyKeyAdapter myKeyAdapter = new MyKeyAdapter();

        this.setPreferredSize(dimension);
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(myKeyAdapter);
        startGame();


    }


    public void startGame() throws InterruptedException {

        for (int i = 0; i < x.length; i++) {
            x[i] = 0;
            y[i] = 0;
        }
        direction = Right;
        bodyParts = 6;
        appleEaten = 0;
        appleExtraY = 5 * UNIT_SIZE;
        appleExtraX = 5 * UNIT_SIZE;
        newApple();
        newAppleExtra();
        running = true;
        timer.start();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        draw(graphics);
    }

    public void draw(Graphics graphics) {

        if (running) {
            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                graphics.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_WIDTH);
                graphics.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            }


            if (!appleExtraEaten) {
                graphics.setColor(Color.BLUE);
                graphics.fillOval(appleExtraX, appleExtraY, UNIT_SIZE, UNIT_SIZE);
            }
            graphics.setColor(Color.RED);
            graphics.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    graphics.setColor(Color.GREEN);
                    graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);

                } else {

                    graphics.setColor(new Color(45, 180, 0));
                    graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                    graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics fontMetrics = getFontMetrics(graphics.getFont());
            graphics.drawString("Score: " + appleEaten, (SCREEN_WIDTH - fontMetrics.stringWidth("Score: " + appleEaten)) / 2, graphics.getFont().getSize());

        } else {
            gameOver(graphics);
        }
    }


    public void newApple() {
        boolean ifAppleInSideSnake = true;
        int appleXRan = 0;
        int appleYRan = 0;
        while (ifAppleInSideSnake) {
            ifAppleInSideSnake = false;
            appleXRan = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
            appleYRan = random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
            for (int i = 0; i < bodyParts; i++) {

                if (x[i] == appleXRan && y[i] == appleYRan) {
                    ifAppleInSideSnake = true;
                    break;
                }
            }
        }
        appleX = appleXRan;
        appleY = appleYRan;
    }

    public void newAppleExtra() throws InterruptedException {
       /* Thread.sleep(1000);
        System.out.println("works");
        int appleXRan = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        int appleYRan = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
        int ifYes = 0;
        for (int i = 0; i < bodyParts; i++) {

            if(x[i] == appleXRan && y[i] == appleYRan ) {
                ifYes++;
            }
        }
        if(ifYes > 0) {
            if (random.nextInt(10)<5) {
                System.out.println("yes");
                appleExtraX = appleXRan;
                appleExtraY = appleYRan;
                appleExtraEaten = false;
            } else {

                newAppleExtra();
                System.out.println("no");
            }
        }else{
            //appleExtraEaten = true;
            newAppleExtra();
            System.out.println("no no");
        }*/
    }


    public void move() throws InterruptedException {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case Up -> y[0] = y[0] - UNIT_SIZE;
            case Down -> y[0] = y[0] + UNIT_SIZE;
            case Left -> x[0] = x[0] - UNIT_SIZE;
            case Right -> x[0] = x[0] + UNIT_SIZE;
        }
    }

    public void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            bodyParts++;
            appleEaten++;
            newApple();
        }
    }

    public void checkAppleExtra() throws InterruptedException {
        if (x[0] == appleExtraX && y[0] == appleExtraY) {
            bodyParts = bodyParts + 5;
            appleEaten = appleEaten + 5;
            appleExtraEaten = true;
            newAppleExtra();
        }
    }

    public void checkCollision() {
        for (int i = bodyParts; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                running = false;
                break;
            }
        }


        if (x[0] < 0 || x[0] > SCREEN_WIDTH) {
            running = false;
        }
        if (y[0] < 0 || y[0] > SCREEN_HEIGHT) {
            running = false;
        }
        if (!running) {
            timer.stop();
        }

    }

    public void gameOver(Graphics graphics) {
        if (!running) {
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics fontMetrics1 = getFontMetrics(graphics.getFont());
            graphics.drawString("Score: " + appleEaten, (SCREEN_WIDTH - fontMetrics1.stringWidth("Score: " + appleEaten)) / 2, graphics.getFont().getSize());

            graphics.setColor(Color.RED);
            graphics.setFont(new Font("Ink Free", Font.BOLD, 75));
            FontMetrics fontMetrics2 = getFontMetrics(graphics.getFont());
            graphics.drawString("Game Over", (SCREEN_WIDTH - fontMetrics2.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            try {
                move();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            checkApple();
            try {
                checkAppleExtra();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            checkCollision();

        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent keyEvent) {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (keyEvent.getKeyCode()) {

                case KeyEvent.VK_LEFT:
                    if (direction != Right) {
                        direction = Direction.Left;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != Direction.Left) {
                        direction = Right;
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != Direction.Down) {
                        direction = Direction.Up;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != Direction.Up) {
                        direction = Direction.Down;
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    try {
                        startGame();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    repaint();
                    break;
            }
        }
    }

}
