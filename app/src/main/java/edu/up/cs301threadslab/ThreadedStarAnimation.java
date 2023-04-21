package edu.up.cs301threadslab;

import java.util.Random;

public class ThreadedStarAnimation extends Thread{

    private StarAnimation star;

    private Random num;


    public ThreadedStarAnimation(StarAnimation g) {
        star = g;
        num = new Random();
    }

    @Override
    public void run() {
        int holder = num.nextInt(10);

        while(true) {
            try {
                this.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(holder < 5) {
                synchronized (star) {
                    star.addStar();
                }
            }
            else {
                synchronized (star) {
                    star.removeStar();
                }
            }
        }
    }
}
