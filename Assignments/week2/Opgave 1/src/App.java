public class App {
    public static double time = 1;
    public static double initialPos = 0;
    public static double initialVel = 1;
    public static double acc = 0.1;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i<10; i++) {
            double pos = positionOfBodyInLinearMotion(initialPos, initialVel, acc, time);
            incrementTime();
            System.out.println("Position ved tid ("+time+"): " + pos);
        }
    }

    private static double positionOfBodyInLinearMotion(double s0, double v0, double a, double t) {
        return s0 + v0*t + ((1.0/2.0)*a*(t*t));
    }

    private static void incrementTime(){
        time++;
    }
}
