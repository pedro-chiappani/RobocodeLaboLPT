package packageLPT;

public class Defensivo implements Strategist{

    private final Strategy corredora = this.new EstrategiaCorredora();
    private final Strategy ganadora = this.new EstrategiaGanadora();

    private class EstrategiaCorredora implements Strategy{
        @Override
        public void run(LPT LPTRobot) {
            LPTRobot.turnAheadRight(100, 45);
        }

        @Override
        public void onHitWall(LPT LPTRobot) {
            LPTRobot.turnBackRight(100, 45);
        }

        @Override
        public void onScannedRobot(LPT LPTRobot) {
            // Hacemos un disparo suave para no comprometer energia y salimos corriendo hacia el lado contrario
            if (LPTRobot.gunReady) {
                LPTRobot.fire(0.5);
            }

            int escapeAngle = (LPTRobot.scannedBearing + 180) % 360;

            LPTRobot.turnTo(escapeAngle);
            LPTRobot.ahead(70);
        }

        @Override
        public void onHitByBullet(LPT LPTRobot) {
            int bearing = LPTRobot.hitByBulletBearing;
            int escapeAngle = (bearing + 150) % 360; // Calculo el ángulo de escape, que quiero que sea a la dirección contraria de donde viene el tiro, pero un poco hacia le costado

            LPTRobot.turnTo(escapeAngle);

            int escapeDistance = Math.max(LPTRobot.scannedDistance, 50); // Calculo distancia de escape, por lo menos 50.
            LPTRobot.ahead(escapeDistance);
        }

    }
    private class EstrategiaGanadora implements Strategy{

        @Override
        public void run(LPT LPTRobot) {
            LPTRobot.turnGunRight(360);
        }

        @Override
        public void onHitWall(LPT LPTRobot) {
            LPTRobot.turnBackLeft(50, 135);
        }

        @Override
        public void onScannedRobot(LPT LPTRobot) {
            int distance = LPTRobot.scannedDistance;
            int bearing = LPTRobot.scannedBearing; // Es el angulo que tiene que girar el cuerpo para apuntar al escaneado.

            if (distance > 200) {
                LPTRobot.fire(1);
            } else if (distance > 50) {
                LPTRobot.fire(2);
            } else {
                LPTRobot.fire(3);
            }

            LPTRobot.turnRight(bearing); // Giro el cuerpo hacia el tipo
            LPTRobot.ahead(Math.min(distance, 100)); // Y lo voy a buscar, pero con cuidado
        }

        @Override
        public void onHitByBullet(LPT LPTRobot) {
            LPTRobot.turnAheadLeft(120, 60);
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
