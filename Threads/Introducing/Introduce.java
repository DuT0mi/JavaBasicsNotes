
package threadIntro;

import java.lang.Thread;
import java.util.Set;
/**
    Priorities:
 *  Min:    1
 *  Normal: 5   (this is the default for the new threads)
 *  Max:    10
 */
public class threadIntro {
    // main thread control
    public static void main(String[] args) {
           // current thread
           Thread t =  Thread.currentThread();
           System.out.println("Current thread: " + t);
           // Change the thread's name
           t.setName("My thread");
           System.out.println("Current thread after the name changing: " + t);
           // Counting down from 10 to 0
           // with 1 - 1 seconds
           // try-catch bec of the sleep() is declarated with InterruptedExpection which MUST to be catch or to be spread
           try{
               for(int i = 10; i>0 ; i--){
               System.out.println(i);
               Thread.sleep(1000);
               }
           }
           catch (InterruptedException e){
              System.out.println("Main thread cancelled ");
           }
        
    }
    
}
