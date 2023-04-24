package ie.tudublin;

import example.MyVisual;

public class Timer {
    int start = 0;
    boolean running = false;
    MyVisual su;
    Audio1 sv;

    public Timer(Audio1 sv){
        this.sv = sv;
    }

    public void start(){
        start = sv.millis();
        running = true;

    }

    public void stop(){
        running = false;
    }
    public int elapsedTime(){
        int elapsed = (sv.millis()-start);

        return elapsed;
    }

    public int seconds(){
        return elapsedTime() / 1000;
    }

    public void update() {
    }
}