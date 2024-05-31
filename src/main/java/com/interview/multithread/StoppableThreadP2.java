package com.interview.multithread;

public class StoppableThreadP2 {

    public static class StoppableRunnable implements Runnable {

        private boolean stopRequested = false;

        public synchronized void requestStop() {
            this.stopRequested = true;
        }

        public synchronized boolean isStopRequested() {
            return this.stopRequested;
        }


        @Override
        public void run() {

            System.out.println("Thread started!");
            while (!isStopRequested()) {
                //sleep(1000);
                System.out.println("....");
            }
            System.out.println("Thread Stopped");
        }
    }

    public static void main(String[] args) {

        StoppableRunnable stoppableRunnable = new StoppableRunnable();

        Thread thread = new Thread(stoppableRunnable);
        thread.start();

        sleep(5000);
        System.out.println("Stop Requesting");
        stoppableRunnable.requestStop();
        System.out.println("Stop Requested");

    }

    public static void sleep(int wait) {
        try {
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
