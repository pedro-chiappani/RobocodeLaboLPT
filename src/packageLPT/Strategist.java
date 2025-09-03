package packageLPT;

public interface Strategist {

    Strategy returnStrategyOnScannedRobot();
    Strategy returnStrategyOnHitWall();
    Strategy returnStrategyOnHitByBullet();
}
