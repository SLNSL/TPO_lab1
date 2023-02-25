public class ArcCos {


    public static double run(double x) {
        if (x > 1 || x < -1) {
            return Double.NaN;
        }
        if (x == 1) {
            return 0.0;
        }
        if (x == -1) {
            return Math.PI;
        }
        double y = Math.sqrt(1 - x * x);
        return Math.atan2(y, x);
    }


}
