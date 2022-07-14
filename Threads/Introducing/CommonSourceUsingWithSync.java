
package book_modul3;

import java.lang.Thread;
import java.util.Set;


public class ThreadTest{
    final int CONST = 100;         
        private int[] vals = new int[CONST];    {
    
        for(int i = 0; i < CONST; i++){
            vals[i] = i;
        }
    }

        
   class MyThread extends Thread{
       // variables
       
       // functions
       @Override
       public void run(){
           for(int j = 0; j < CONST - 1; j++){
           synchronized (vals){         //
               vals[j] += vals[j+1];    //  Bec of this the read and write cant cancel!!
           }                            //
               
           }
       }       
   }    
   public void go(){
           Thread t1 = new MyThread();
           Thread t2 = new MyThread();
           t1.start();
           t2.start();
           try{
               t1.join();
               t2.join();
           }
           catch(InterruptedException e){}
           for(int k = 0; k < CONST; k++){
               System.out.println(vals[k] + " ");
           }
       }
    // main thread control
    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        test.go();
    }
}
