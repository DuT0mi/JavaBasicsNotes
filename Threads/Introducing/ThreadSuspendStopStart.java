/**
     * For suspend a thread use suspend() instead of stop(), the stop() method let the thread being in an inconsistent status. 
     * With suspend() the thread will be unreachable until we dont free it. The stop() method after use, immediately free all of the lock which was having the thread.
*/
    class MyThread extends Thread{
    // variable
        private boolean suspendRequested;
        private boolean job;                // Still have work? 
    // functions
        public synchronized void requestSuspend(){
        suspendRequested = true;
        notify();
        }
        public synchronized void checkSuspended() throws InterruptedException{
            while(suspendRequested)
                wait();
           
        }
       @Override
       public void run(){
           while(job){
               try{
                checkSuspended();
               }
               catch(InterruptedException e){
                   System.out.println("InterruptedException caugth.");
               }
           }
           
       }
    }
