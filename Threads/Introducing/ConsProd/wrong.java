
package PC;

import java.lang.Thread;
import java.util.Set;
class Queue{
    // variable
            int n;
    // functions
        synchronized int get(){
        System.out.println("Got: " + n);
        return n;
    }
        synchronized void put(int param){
           this.n = param;
           System.out.println("Put: " + n);
        }
    
    }
class Producer implements Runnable{
    // variable
       Queue q;
       
    // functions
       Producer(Queue pQ){
       this.q = pQ;
       new Thread(this,"Producer").start();
       }
       public void run(){
       int i = 0;
       while(true){
           q.put(i++);
       }
       }
    }
class Consumer implements Runnable{
    // variables
        Queue q;
    // functions
        Consumer(Queue pQ){
            this.q = pQ;
            new Thread(this,"Consumer").start();
        }
        public void run(){
        while(true){
        q.get();
        }
        }
    }
 class PC{
    
    
   public static void main(String[] args) {
            Queue q = new Queue();
            new Producer(q);
            new Consumer(q);
            System.out.println("Stop with CTRL+C");
    
    }
}
