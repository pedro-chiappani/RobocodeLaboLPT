package laboratorio;

import robocode.JuniorRobot;

import java.awt.*;

public class Ganadora implements Strategy{
    private int powerFires = 0;

    @Override
    public void run(LPT juniorRobot) {

        juniorRobot.setColors(Color.blue.getBlue(), Color.yellow.hashCode(), Color.yellow.hashCode());

        while (true) {
            juniorRobot.turnGunRight(10);
        }
    }

    @Override
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

    @Override
    public void onHitWall(LPT juniorRobot) {
        juniorRobot.back(10);
        juniorRobot.turnLeft(45);
    }

    @Override
    public void onHitByBullet (LPT juniorRobot) {
        juniorRobot.turnRight(180);
        juniorRobot.ahead(10000);
        this.setPowerFires(3);
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
