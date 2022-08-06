package folder;

import java.awt.*;
public class Food {
    // variables
        // the food's positions
        private int x;
        private int y;
    // functions
        public  Food(Snake sPlayer){
            this.spawningRandomly(sPlayer);
        }
        public void spawningRandomly(Snake snakePlayer){
            // check
            boolean onIt = true;
            while(onIt){
                onIt = false;
                // must cast, or switches to zero BUT,
                // HOWEVER WE MUST CHECK IF THE DOT'S LOCATION NOT EQUAL TO SNAKE'S
                // must create or will generate bugs
                // added -1 because of the food can spawn outside the window bec of its top
                x = (int)(Math.random() *  Constants.WINDOW_WIDTH - 1);
                y = (int)(Math.random() *  Constants.WINDOW_HEIGHT- 1);
                for(Rectangle r: snakePlayer.getSnakeBody()){
                    if(r.x == x && r.y == y){
                        onIt = true;
                    }
                }
            }
        }
        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }
        public void setX(int pX){
            this.x = pX;
        }
        public void setY(int pY){
            this.y = pY;
        }
}
