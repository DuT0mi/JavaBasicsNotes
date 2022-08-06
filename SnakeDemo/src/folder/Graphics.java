package folder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphics  extends JPanel implements ActionListener {
    // variables
        // delay is 100ms
        // delay means how every 100ms this class will draw everything what it can
        private Timer t = new Timer(100,this);
        // The game's state
        public static String state;
        // Objects
        private Snake snake;
        private Game game;
        private Food food;
    // functions
        public Graphics(Game g){
            t.start();
            state = Constants.START;
            game = g;
            snake = g.getPlayer();
            food = g.getFood();
        // Add a KeyListener to game
            this.addKeyListener(g);
            this.setFocusable(true);
            this.setFocusTraversalKeysEnabled(false);
        }
        // I wrote out the java.awt.Graphics for the better readable
        public void paintComponent(java.awt.Graphics g){
            // Calling JPanel constructor trough super
            super.paintComponent(g);
            // Cast it to 2D
            Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(Color.black);
            // black rectangle for the bg :D for covering
            // added +5  because of the food can spawn outside the window bec of its top
            g2d.fillRect(0,0,Constants.WINDOW_WIDTH * Constants.DIMENSION + 5,Constants.WINDOW_HEIGHT * Constants.DIMENSION + 5);
            // opening screen
            if(state ==  Constants.START){
                g2d.setColor(Color.white);
                // write a text and center it that (+ 250)
                g2d.drawString("Press any key to continue...",
                        Constants.WINDOW_WIDTH / 2 -  Constants.DIMENSION + 225 ,
                        Constants.WINDOW_HEIGHT / 2 * Constants.DIMENSION );

            }else if(state == Constants.END){

                // the end screen
                // one more state when the end happens
                g2d.setColor(Color.white);
                // write a text and center it
                g2d.drawString("Your score: " + (snake.getSnakeBody().size() - Constants.BASE_LENGTH_OF_SNAKE),
                        Constants.WINDOW_WIDTH / 2 -  Constants.DIMENSION + 225,
                        Constants.WINDOW_HEIGHT / 2 * Constants.DIMENSION);
            }
            else {
                /*  Usually in 2D games the painting looks like that:
                 *   paint the bg first
                 *   then removing what you see on the previous page
                 *   updates all the locations, I mean the color of elements
                 *   it's painting really fast
                 * */
                // paint the food first, it's maybe looks better
                g2d.setColor(Color.red);
                g2d.fillRect(food.getX() * Constants.DIMENSION,food.getY() * Constants.DIMENSION,Constants.DIMENSION,Constants.DIMENSION);
                // set the color of the snake
                g2d.setColor(Color.green);
                for(Rectangle r:snake.getSnakeBody())
                    g2d.fill(r);
            }
        }

    @Override // For the implements
    public void actionPerformed(ActionEvent e) {
        // This gets the 100ms refresh
            // Repaint the bg than draw
            repaint();
        // manage the game
            if(state == Constants.RUNNING){
                if(game.checkCollisionWithFood() == true){
                    snake.grow();
                    food.spawningRandomly(snake);
                }
                // could be xor but yeah now is or, bravely replace the || with ^
                else if(game.checkCollisionWithWall() || game.checkSelfCollision()){
                    state = Constants.END;
                }
                else{
                    snake.movingTheSnake();
                }
            }
    }
}
