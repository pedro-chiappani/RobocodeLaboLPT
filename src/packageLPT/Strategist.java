package packageLPT;

import robocode.JuniorRobot;

public interface Strategist {

    Strategy returnStrategyRun(JuniorRobot robot);
    Strategy returnStrategyOnScannedRobot(JuniorRobot robot);
    Strategy returnStrategyOnHitWall(JuniorRobot robot);
    Strategy returnStrategyOnHitByBullet(JuniorRobot robot);
}
