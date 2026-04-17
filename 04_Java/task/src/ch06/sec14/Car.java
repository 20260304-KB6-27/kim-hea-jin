package ch06.sec14;

public class Car {
    // field
    private int speed;
    private boolean stop;

    // Getter Setter method
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed <= 0){
            this.speed = 0;
        } else {
            this.speed = speed;
        }
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        if (stop == true){
            this.speed = 0;
        }
        this.stop = stop;
    }
}
