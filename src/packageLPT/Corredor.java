package packageLPT;

import robocode.JuniorRobot;

public class Corredor implements Strategist{

    private final Strategy corredora = this.new EstrategiaCorredora();
    private final Strategy ganadora = this.new EstrategiaGanadora();
    private int totalRobots = 0;

    private class EstrategiaCorredora implements Strategy{
        @Override
        public void run(LPT juniorRobot) {
        }

        @Override
        public void onHitWall(LPT juniorRobot) {

        }

        @Override
        public void onScannedRobot(LPT juniorRobot) {

        }

        @Override
        public void onHitByBullet(LPT juniorRobot) {

        }

    }
    private class EstrategiaGanadora implements Strategy{

        @Override
        public void run(LPT juniorRobot) {

        }

        @Override
        public void onHitWall(LPT juniorRobot) {

        }

        @Override
        public void onScannedRobot(LPT juniorRobot) {

        }

        @Override
        public void onHitByBullet(LPT juniorRobot) {

        }
    }

    @Override
    public Strategy returnStrategyRun(JuniorRobot robot){
        // Si
        if (totalRobots == 0)
            totalRobots = robot.others;
        if (robot.energy < 35 && (robot.others > totalRobots/3)) {
            return corredora;
        }else{
            return ganadora;
        }
    }

    @Override
    public Strategy returnStrategyOnScannedRobot(JuniorRobot robot) {
        // Si el robot tiene bastante energia o
        // si el robot enemigo esta muy muy cerca se acerca a cagarlo a tiros
        if (robot.energy > 60 || (robot.scannedDistance < (robot.fieldHeight * robot.fieldWidth / 500)))
        {
            return ganadora;
        }else {
            return corredora;
        }
    }

    @Override
    public Strategy returnStrategyOnHitWall(JuniorRobot robot) {
        if (robot.energy > 50){
            return ganadora;
        } else {
            return corredora;
        }
    }

    @Override
    public Strategy returnStrategyOnHitByBullet(JuniorRobot robot) {
        if (robot.energy > 35){
            return ganadora;
        }else{
            return corredora;
        }
    }
}
