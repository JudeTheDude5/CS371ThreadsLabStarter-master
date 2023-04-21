package edu.up.cs301threadslab;

public class ThreadedAnimationView extends Thread{

    private AnimationView AV;

    public ThreadedAnimationView(AnimationView g) {
        AV = g;
    }

    @Override
    public void run() {
        while(true) {
            try {
                this.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            AV.postInvalidate();
        }
    }
}
