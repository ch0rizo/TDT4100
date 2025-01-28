package oving1;

public class StopWatch {
    private boolean start = false;
    private boolean stop = false;
    private int tick = 0;
    private int time = -1;

    public boolean isStarted() {
        return this.start;
    }

    public boolean isStopped() {
        return this.stop;
    }

    public int getTicks() {
        return this.tick;
    }

    public int getTime() {
        if ( this.start && !this.stop ) {
            return this.tick;
        } else if ( this.stop ) {
            return this.tick;
        }
        return 0;
    }

    public int getLapTime() {

    }

    public int getLastLapTime() {

    }

    // Endringsmetoder
    public void tick(int ticks) {
        
    }

}
