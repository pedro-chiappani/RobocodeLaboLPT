package laboratorio;

import robocode.JuniorRobot;

public class LPT extends JuniorRobot {

    boolean robotOnSight = false;
//    Estrategia estragia = new Agresivo();

    @Override
    public void run() {
        if (!robotOnSight) {
            turnGunLeft(5);
        } else {
            robotOnSight = false;
        }
//        estrategia.run();
    }

    @Override
    public void onScannedRobot(){
        robotOnSight = true;
        fire(2);
        ahead(5);
    }

    @Override
    public void onHitWall(){
        back(10);
        turnLeft(45);
    }

}
