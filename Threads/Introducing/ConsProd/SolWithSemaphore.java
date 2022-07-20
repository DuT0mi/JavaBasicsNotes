/*
  This solution is not the best if want an effective code, the semaphore bind takes a lot of time but it works.
  --> Low efficiency
*/

package PC;

import java.lang.Thread;
import java.util.Set;
class Queue{
    // variable
            int n;
            boolean full = false; //semaphore
    // functions
        synchronized int get(){
            if(!full) return -1;
        System.out.println("Got: " + n);
        full = true;
        return n;
    }
        synchronized int put(int param){
            if(full) return -1;
           this.n = param;
           System.out.println("Put: " + n);
           full = true;
           return 1;
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
       @Override 
       public void run(){
       int i = 0;
       while(true){
           if(q.put(i)!= -1) i++;
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
        @Override
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
