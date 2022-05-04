package Programming_classes_2021.kdruc.snake;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;


public class GamePanel extends JPanel implements ActionListener {

    static int SCREEN_WIDTH = 600;
    static int SCREEN_HEIGHT=600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 100;
    final int x[]= new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts= 6;
    int appleEaten;
    int appleX;
    int appleY;

    int appleExtraX;
    int appleExtraY;
    char direction ='R';
    boolean running = false;
    Timer timer =new Timer(DELAY, this);
    Random random;







    GamePanel(){

        random = new Random();
        Dimension dimension = new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT);
        MyKeyAdapter myKeyAdapter = new MyKeyAdapter();

        this.setPreferredSize(dimension);
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(myKeyAdapter);
        startGame();


    }


    public void startGame(){

        for (int i = 0; i < x.length; i++) {
            x[i] = 0;
            y[i]=0;
        }
        direction ='R';
        bodyParts = 6;
        appleEaten = 0;

        newApple();
        running = true;
        timer.start();
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        draw(graphics);
    }

    public void draw(Graphics graphics){

        if(running) {
            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                graphics.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_WIDTH);
                graphics.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            }
            newAppleExtra();
            if(appleExtraY == -1 && appleExtraX == -1){
                graphics.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255),random.nextInt(255)));
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

                    graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
                //System.out.println("snake body : X"+x[i]+" Y"+ y[i]);
            }
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("Ink Free",Font.BOLD,40));
            FontMetrics fontMetrics = getFontMetrics(graphics.getFont());
            graphics.drawString("Score: "+appleEaten, (SCREEN_WIDTH - fontMetrics.stringWidth("Score: "+appleEaten))/2,graphics.getFont().getSize());
        }else{
            gameOver(graphics);
        }
    }





    public void newApple(){
        int appleXRan = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        int appleYRan = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
        int ifYes = 0;
        for (int i = 0; i < bodyParts; i++) {

            if(x[i] == appleXRan && y[i] == appleYRan ) {
                ifYes++;
            }
        }
        if(ifYes>0){
            newApple();
        }else{
            appleX = appleXRan;
            appleY = appleYRan;
        }

    }
    public void newAppleExtra(){
        int appleXRan = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        int appleYRan = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
        int ifYes = 0;
        for (int i = 0; i < bodyParts; i++) {

            if(x[i] == appleXRan && y[i] == appleYRan ) {
                ifYes++;
            }
        }
        if(random.nextInt(100)<50) {
            if (ifYes > 0) {
                newApple();
            } else {
                appleExtraX = appleXRan;
                appleExtraY = appleYRan;
            }
        }else{
            appleExtraX = -1;
            appleExtraY = -1;
        }
    }


    public void move() throws InterruptedException {
        for(int i = bodyParts; i>0;i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch (direction) {
            case 'U' -> y[0] = y[0] - UNIT_SIZE;
            case 'D' -> y[0] = y[0] + UNIT_SIZE;
            case 'L' -> x[0] = x[0] - UNIT_SIZE;
            case 'R' -> x[0] = x[0] + UNIT_SIZE;
        }
    }

    public void checkApple(){
        if(x[0] == appleX && y[0] == appleY){
            bodyParts++;
            appleEaten++;
            newApple();
        }
    }

    public  void checkCollision(){
        for (int i = bodyParts; i >0 ; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                running = false;
                break;
            }
        }


        if(x[0] < 0){
            running = false;
        }
        if(x[0] > SCREEN_WIDTH){
            running = false;
        }
        if(y[0] < 0){
            running = false;
        }
        if(y[0] > SCREEN_HEIGHT){
            running = false;
        }
        if(!running){
            timer.stop();
        }

    }

    public void gameOver(Graphics graphics){
        if(!running){
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("Ink Free",Font.BOLD,40));
            FontMetrics fontMetrics1 = getFontMetrics(graphics.getFont());
            graphics.drawString("Score: "+appleEaten, (SCREEN_WIDTH - fontMetrics1.stringWidth("Score: "+appleEaten))/2,graphics.getFont().getSize());

            graphics.setColor(Color.RED);
            graphics.setFont(new Font("Ink Free",Font.BOLD,75));
            FontMetrics fontMetrics2 = getFontMetrics(graphics.getFont());
            graphics.drawString("Game Over", (SCREEN_WIDTH - fontMetrics2.stringWidth("Game Over"))/2,SCREEN_HEIGHT/2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            try {
                move();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            checkApple();
            checkCollision();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent keyEvent){
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (keyEvent.getKeyCode()){

                case KeyEvent.VK_LEFT:
                    if(direction != 'R'){
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L'){
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D'){
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U'){
                        direction = 'D';
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    startGame();
                    repaint();
                    break;
            }
        }
    }

}
