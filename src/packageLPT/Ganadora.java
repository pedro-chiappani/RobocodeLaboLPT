package packageLPT;

import java.awt.*;

public class Ganadora implements Strategy{
    private int powerFires = 0;


    public void run(LPT juniorRobot) {

        juniorRobot.setColors(Color.blue.getBlue(), Color.yellow.hashCode(), Color.yellow.hashCode());

        while (true) {
            juniorRobot.turnGunRight(10);
        }
    }


    public void onScannedRobot(LPT juniorRobot) {
        if (this.getPowerFires()> 0) {
            juniorRobot.fire(3);
            this.decreasePowerFires();
        }
        else{
            juniorRobot.fire(2);
        }
        juniorRobot.ahead(2);
    }


    public void onHitWall(LPT juniorRobot) {
        juniorRobot.back(10);
        juniorRobot.turnRight(90);
    }


    public void onHitByBullet (LPT juniorRobot) {
        juniorRobot.turnRight(90);
        juniorRobot.ahead(100);
        this.setPowerFires(1);
    }

    public void setPowerFires(int powerFires) {
        this.powerFires = powerFires;
    }
    public int getPowerFires() {
        return powerFires;
    }
    public void decreasePowerFires() {
        this.powerFires--;
    }
}
