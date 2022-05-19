package utils;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vital
 */
public class Timer extends Thread {

    private int time;
    private boolean running;

    public Timer() {
        time = 0;
        running = true;
    }

    @Override
    public void run() {
        while (running) {
            System.out.println("Time: " + ++time + " seconds");
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void kill() {
        running = false;
    }
}
