package laboratorio;

import robocode.JuniorRobot;

public class Ganadora implements Strategy{


    @Override
    public void run(LPT juniorRobot) {
        while (true) {
            juniorRobot.turnGunRight(10);
        }
    }

    @Override
    public void onScannedRobot(LPT juniorRobot) {
        juniorRobot.fire(2);
        juniorRobot.ahead(2);
    }

    @Override
    public void onHitWall(LPT juniorRobot) {
        juniorRobot.back(10);
        juniorRobot.turnLeft(45);
    }
}
