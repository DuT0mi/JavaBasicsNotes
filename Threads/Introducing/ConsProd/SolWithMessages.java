
package PC;

import java.lang.Thread;
import java.util.Set;
/*
 * Must be an synchronized function to call wait(), --> the caller thread got block and wait for another call it with notify()
 *                                       notify(), --> Waking up the thread (cancel the blocked condition), which was the wait on the same thread
 *                                       notifiyall() --> waking up all of th threads on one object which was calling the wait(). The biggest priority woke up thread is going to be run
 */
class Queue{
    // variable
            int n;
            boolean valueSet = false; //semaphore
    // functions
        synchronized int get(){
            if(!valueSet)
                try{
                wait();
                }
            catch(InterruptedException e){
                System.out.println("InterruptedException caught");
            }
            System.out.println("Got: " + n);
            valueSet = false;
            notify();
            return n;
    }
        synchronized void put(int n){
            if(valueSet)
                try{
                    wait();
                }
            catch(InterruptedException e){
                System.out.println("InterruptedException caught");
            }
            this.n = n;
            valueSet = true;
            System.out.println("Put:" + n);
            notify();
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
