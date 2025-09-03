package packageLPT;

public class Corredor implements Strategist{

    private final Strategy corredora = this.new EstrategiaCorredora();
    private final Strategy ganadora = this.new EstrategiaGanadora();

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
    public Strategy returnStrategyOnScannedRobot() {
        return corredora;
    }

    @Override
    public Strategy returnStrategyOnHitWall() {
        return ganadora;
    }

    @Override
    public Strategy returnStrategyOnHitByBullet() {
        return ganadora;
    }
}
