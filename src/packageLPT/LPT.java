package packageLPT;

import robocode.JuniorRobot;

public class LPT extends JuniorRobot {

    private Strategist estratega = Estratega2.getInstancia();
    //private Strategist estratega = Defensivo.getInstancia();

    @Override
    public void run() {
        this.estratega.returnStrategyRun(this).run(this);
    }

    @Override
    public void onScannedRobot(){
        this.estratega.returnStrategyOnScannedRobot(this).onScannedRobot(this);
    }

    @Override
    public void onHitWall(){
        this.estratega.returnStrategyOnHitWall(this).onHitWall(this);
    }

    @Override
    public void onHitByBullet(){ this.estratega.returnStrategyOnHitByBullet(this).onHitByBullet(this); }


}
