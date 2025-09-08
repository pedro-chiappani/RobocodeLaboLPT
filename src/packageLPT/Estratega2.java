package packageLPT;

import robocode.JuniorRobot;

public class Estratega2 implements Strategist{

    private final Strategy movediza = this.new EstrategiaMovediza(){};
    private final Strategy torreta = this.new EstrategiaTorreta(){};

    private int totalRobots = 0;
    private static Estratega2 instancia;

    private Estratega2(){

    }

    public static Estratega2 getInstancia(){
        if (instancia == null){
            instancia = new Estratega2();
        }
        return instancia;
    }

    private class EstrategiaTorreta implements Strategy {
        @Override
        public void run(LPT robot) {
            robot.turnRight(360);
            robot.fire(3);
        }

        @Override
        public void onHitWall(LPT robot) {
            robot.back(50);
            robot.turnRight(90);
        }

        @Override
        public void onScannedRobot(LPT robot) {
            robot.turnTo(robot.scannedAngle);
            robot.fire(3);
        }

        @Override
        public void onHitByBullet(LPT robot) {
            robot.ahead(40);
            robot.turnRight(30);
        }
    }

    private class EstrategiaMovediza implements Strategy {
        @Override
        public void run(LPT robot) {
            robot.ahead(80);
            robot.turnRight(60);
            robot.ahead(80);
            robot.turnLeft(120);
        }

        @Override
        public void onHitWall(LPT robot) {
            robot.back(100);
            robot.turnRight(90);
        }

        @Override
        public void onScannedRobot(LPT robot) {
            if (robot.scannedDistance < 120) {
                robot.fire(1);
            }
            robot.turnRight(30);
            robot.ahead(40);
        }

        @Override
        public void onHitByBullet(LPT robot) {
            robot.turnLeft(90);
            robot.ahead(100);
        }
    }

    @Override
    public Strategy returnStrategyRun(JuniorRobot robot) {
        if (totalRobots == 0)
            totalRobots = robot.others;

        if (robot.energy < 35 && (robot.others > totalRobots / 3)) {
            return movediza;
        } else {
            return torreta;
        }
    }

    @Override
    public Strategy returnStrategyOnScannedRobot(JuniorRobot robot) {
        if (robot.energy > 60) {
            return torreta;
        } else {
            return movediza;
        }
    }

    @Override
    public Strategy returnStrategyOnHitWall(JuniorRobot robot) {
        if (robot.energy > 50) {
            return torreta;
        } else {
            return movediza;
        }
    }

    @Override
    public Strategy returnStrategyOnHitByBullet(JuniorRobot robot) {
        if (robot.energy > 35) {
            return torreta;
        } else {
            return movediza;
        }
    }
}
