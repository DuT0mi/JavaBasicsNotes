package folder;

import javax.swing.*;
import java.awt.event.*;

// Because we want to do thing via clicking, we must to implements a Listener
public class Game implements KeyListener {
    // Variables
        // For getting the constants
            Constants c;
        // the player
            private Snake player;
        // the red dot
            private Food food;
        // windows with swing graphics
            private JFrame  window;
        // Our Graphics class
            folder.Graphics graphics;
    // Functions
    public Game(){
        window = new JFrame();
        player = new Snake();
        food = new Food(player);

        graphics = new Graphics(this);
        window.add(graphics);

            window.setTitle("Snake");
            // added +4 and +6 because of the food can spawn outside the window bec of its top
            window.setSize(c.WINDOW_WIDTH * c.DIMENSION + 4,c.WINDOW_HEIGHT * c.DIMENSION + 6);
            // So we don't need to create a Listener class which close the window whe the client clicks on the X button
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // window not to be resizable
            window.setResizable(false);
            window.setVisible(true);
    }
    public void startGame(){
        graphics.state = Constants.RUNNING;
    }
    // collisions
    public boolean checkCollisionWithWall(){
        if(player.getXPos() < 0 ||
           player.getXPos() > Constants.WINDOW_WIDTH * Constants.DIMENSION ||
           player.getYPos() < 0 ||
           player.getYPos() >= Constants.WINDOW_HEIGHT * Constants.DIMENSION
        ) {
            return true;
        }
        // otherwise
            return  false;
    }
    public boolean checkCollisionWithFood(){
        if(player.getXPos() == food.getX() * Constants.DIMENSION &&
           player.getYPos() == food.getY() * Constants.DIMENSION
        ){
            return  true;
        }
        // otherwise
        return  false;
    }
    public boolean checkSelfCollision(){
        // we must start it from 1 which is the second element
        // because you can't touch your own head
        for(int i = 1; i < player.getSnakeBody().size(); i++){
            if(player.getXPos() == player.getSnakeBody().get(i).x &&
               player.getYPos() == player.getSnakeBody().get(i).y
            ){
                return true;
            }
        }
        // otherwise
        return  false;
    }

    // For the KeyListener
    @Override   // Ignored
    public void keyTyped(KeyEvent e) {

        }
    @Override   // We only use this one
    public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if(graphics.state == Constants.RUNNING){
                // if the W is pressed than go up
                if(keyCode == KeyEvent.VK_W){
                    player.dirUp();
                }
                // if the S is pressed than go down
                else if(keyCode == KeyEvent.VK_S){
                    player.dirDown();
                }
                // if the A is pressed than go left
                else if(keyCode == KeyEvent.VK_A){
                    player.dirLeft();
                }
                else{ // the default direction of the movement
                    player.dirRight();
                }
            }
                else {
                    this.startGame();
            }
        }
    @Override   // Ignored
    public void keyReleased(KeyEvent e) {

        }
    public Snake getPlayer(){
            return this.player;
        }
    public void setPlayer(Snake pPlayer){
            this.player = pPlayer;
        }
    public Food getFood() {
            return food;
        }
    public void setFood(Food pFood){
            this.food = pFood;
        }
    public JFrame getWindow(){
            return  this.window;
        }
    public void setWindow(JFrame pWindow){
            this.window = pWindow;
        }
}
