package folder;

import java.awt.*;
import java.util.ArrayList;

/*
* Each rectangle is part of the snake, so we make a rectangle arraylist
*/
public class Snake {
    // variables
        /**
         * @brief: Indicates the direction
         * @values: NOTHING,UP,DOWN,LEFT,RIGHT
         * */
        private String move;
        private ArrayList<Rectangle> snakeBody;
    // functions
        public Snake(){
            snakeBody = new ArrayList<>();
            Rectangle rT = new Rectangle(Constants.DIMENSION,Constants.DIMENSION);
                // setting the location of the rectangle
                rT.setLocation(Constants.DIMENSION * Constants.WINDOW_WIDTH / 2, Constants.WINDOW_HEIGHT * Constants.DIMENSION / 2);
            snakeBody.add(rT);
            // clearing and location adjusting for the beginnings of the snake (start with 3 dots)
                // first dot (actually the second)
                    rT = new Rectangle(Constants.DIMENSION,Constants.DIMENSION);
                    rT.setLocation( // - 1 stands for one dot to the left
                            ((Constants.WINDOW_WIDTH / 2 - 1) * Constants.DIMENSION),
                            ((Constants.WINDOW_HEIGHT / 2) * Constants.DIMENSION)
                    );
                    snakeBody.add(rT);
                // second dot (actually the third)
                    rT = new Rectangle(Constants.DIMENSION,Constants.DIMENSION);
                    rT.setLocation( // - 2 stands for one dot to the left
                            ((Constants.WINDOW_WIDTH / 2 - 2) * Constants.DIMENSION),
                            ((Constants.WINDOW_HEIGHT / 2) * Constants.DIMENSION)
                    );
                    snakeBody.add(rT);
            move = Constants.NOTHING;
        }
        public void movingTheSnake(){
            if(move != Constants.NOTHING){
                // get the sneak's head for being the reference point
                Rectangle head = snakeBody.get(0);
                // create a rectangle
                Rectangle rTemp = new Rectangle(Constants.DIMENSION,Constants.DIMENSION);
                if(move == Constants.UP){
                    // the (0,0) point is at left top usually that is why we subtract
                    rTemp.setLocation(head.x,head.y - Constants.DIMENSION);
                    // add to the body
                    snakeBody.add(0,rTemp);
                }
                else if(move == Constants.DOWN){
                    // the (0,0) point is at left top usually that is why we add now
                    rTemp.setLocation(head.x,head.y + Constants.DIMENSION);
                    snakeBody.add(0,rTemp);
                }
                else if(move == Constants.LEFT){
                    // the (0,0) point is at left top usually that is why we subtract now
                    rTemp.setLocation(head.x - Constants.DIMENSION,head.y);
                    snakeBody.add(0,rTemp);
                }
                // these are the right (means "-->" not the synonym of good :D) directions
                else{
                    // the (0,0) point is at left top usually that is why we add now
                    rTemp.setLocation(head.x + Constants.DIMENSION,head.y);
                    snakeBody.add(0,rTemp);
                }
                // remove the last
                snakeBody.remove(snakeBody.size() - 1);
            }
        }
        public void grow(){
            /*  It has copied and pasted from the movingTheSnake function
            *   because when growing, obviously it means we are moving
            *   the differences are, we don't remove the last node and
            *   don't need to check if it equals to "NOTHING",
            *   so pretty much the same as the moving function what is being above/upper
            * */
            // get the sneak's head for being the reference point
            Rectangle head = snakeBody.get(0);
            // create a rectangle
            Rectangle rTemp = new Rectangle(Constants.DIMENSION,Constants.DIMENSION);
            if(move == Constants.UP){
                // the (0,0) point is at left top usually that is why we subtract
                rTemp.setLocation(head.x,head.y - Constants.DIMENSION);
                // add to the body
                snakeBody.add(0,rTemp);
            }
            else if(move == Constants.DOWN){
                // the (0,0) point is at left top usually that is why we add now
                rTemp.setLocation(head.x,head.y + Constants.DIMENSION);
                // add to the body
                snakeBody.add(0,rTemp);
            }
            else if(move == Constants.LEFT){
                // the (0,0) point is at left top usually that is why we subtract now
                rTemp.setLocation(head.x - Constants.DIMENSION,head.y);
                // add to the body
                snakeBody.add(0,rTemp);
            }
            // these are the right (means "-->",not the synonym of good :D) directions
            else{
                // the (0,0) point is at left top usually that is why we add now
                rTemp.setLocation(head.x + Constants.DIMENSION,head.y);
                // add to the body
                snakeBody.add(0,rTemp);
            }
        }
        public ArrayList<Rectangle> getSnakeBody(){
            return this.snakeBody;
    }
        public void setSnakeBody(ArrayList<Rectangle> pSnakeBody){
            this.snakeBody = pSnakeBody;
        }
        public void dirUp(){
                move = Constants.UP;
        }
        public void dirDown(){
                move = Constants.DOWN;
        }
        public void dirLeft(){
                move = Constants.LEFT;
        }
        public void dirRight(){
                move = Constants.RIGHT;
        }
        public int getXPos(){
            return snakeBody.get(0).x;
        }
        public int getYPos(){
            return snakeBody.get(0).y;
        }
        public int getSnakeLength(){
            return snakeBody.size();
        }
        public String getMove(){
            return move;
        }
}
