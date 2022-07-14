
package ThreadTest;

import java.lang.Thread;
import java.util.Set;

// Creating a thread, spread from the Thread class
class ThreadT extends Thread{
    // variables
    String name;
    long delay;
    
    // functions
    ThreadT(String pName, long pDelay){
       // for sure need the validition but this is just note
        super(pName);
        this.name = pName;
        this.delay = pDelay;
        System.out.println("ThreadT tpye childthread's name: " + pName);
        System.out.println("ChilTthread's delay: " + pDelay);
        
    }
    @Override
    public void run(){
    try{
        for(int i = 5; i > 0; --i){
        System.out.println("ChildThread's condition: i = " + i );
        Thread.sleep(delay);
        }
    }
     catch(InterruptedException e){
         System.out.println("ChildThread cancelled");
         }
         System.out.println(name + "ChildThread ended");
    }
}
class ThreadR implements Runnable{
    // variables
    String name;
    long delay;
    Thread t;
    
    // functions
    ThreadR(String pName, long pDelay){
        // for sure need the validition but this is just note
        this.name = pName;
        this.delay = pDelay;
        t = new Thread(this,name);
        System.out.println("Name of the ThreadR type child: " + name);
        System.out.println("Delay of the child: " + delay);
    }
    @Override
    public void run(){
    try{
    for(int i = 5; i > 0; i--){
        System.out.println(name + " child's status, i = " + i);
        Thread.sleep(delay);
    }
    }
    catch(InterruptedException e){
    System.out.println(name + " child thread cancelled");
    }
    System.out.println(name + " thread ended");
    }
}
public class ThreadTest {
    // main thread control
    public static void main(String[] args) {
    // testing
    final int CONST = 500; // [uSecond]
     ThreadT t1 = new ThreadT("First",CONST);
        System.out.println("First thread is alive: " + t1.isAlive());
        t1.start();
        System.out.println("First thread is alive: " + t1.isAlive());
     ThreadT t2 = new ThreadT("Second",CONST * 2);
        System.out.println("Second thread is alive: " + t2.isAlive());
        t2.start();
        System.out.println("Second thread is alive: " + t2.isAlive());
     ThreadR t3 = new ThreadR("Third",CONST * 3);
        System.out.println("Third thread is alive: " + t2.isAlive());
        t3.t.start();
        System.out.println("Third thread is alive: " + t2.isAlive());
        try {
            // join
            t1.join();
            t2.join();
            t3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Cancelled");
        }
    }
    
}
