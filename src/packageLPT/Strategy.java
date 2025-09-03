package packageLPT;

public interface Strategy {

    void run(LPT juniorRobot);

    void onHitWall(LPT juniorRobot);

    void onScannedRobot(LPT juniorRobot);

    void onHitByBullet(LPT juniorRobot);
}
