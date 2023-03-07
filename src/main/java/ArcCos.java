public class ArcCos {


    public static double run(double x) {
        if (x > 1 || x < -1)
            return Double.NaN;

        double nc = 1;
        double df = 2;

        double e;
        double n = 1;
        double sum = x;

        do {
            nc *= 2 * n - 1;
            df *= 2 * n;
            e = (nc * Math.pow(x, 2 * n - 1)) / (df * (2 * n - 1));
            sum += e;
            n++;
        }while (Math.abs(e) > 0.0001);

        return Math.PI / 2 -  sum;
    }


}
