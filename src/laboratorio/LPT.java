package laboratorio;

import robocode.JuniorRobot;

public class LPT extends JuniorRobot {

    private Strategy estrategia = new Ganadora();

    @Override
    public void run() {
        this.estrategia.run(this);
    }

    @Override
    public void onScannedRobot(){
        this.estrategia.onScannedRobot(this);
    }

    @Override
    public void onHitWall(){
        this.estrategia.onHitWall(this);
    }

    @Override
    public void onHitByBullet(){ this.estrategia.onHitByBullet(this); }

    public Strategy getEstrategia() {
        return this.estrategia;
    }
    public void setEstrategia(Strategy estrategia) {
        this.estrategia = estrategia;
    }

}
