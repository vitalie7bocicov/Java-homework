package uaic.wordgame;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vital
 */
public class TimeKeeper extends Thread {

    Game game;
    private int time = 0;
    private int maxTime = 20;

    public TimeKeeper(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        while (!game.isOver) {

            System.out.println("\nTime: " + ++time + " seconds\n");

            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TimeKeeper.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (time >= maxTime) {
                System.out.println("Time expired! Game Over!");
                game.isOver = true;
            }
        }

    }

    public void showTime() {
        System.out.println("\nGame duration: " + time + " seconds");

    }

    public int getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

}
