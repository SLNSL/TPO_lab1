public class ArcCos {


    public static double run(double x) {
        if (x > 1 || x < -1)
            return Double.NaN;

        double numeratorCoeff = 1;
        double denominatorCoeff = 2;

        double e;
        double n = 1;
        double arcsin = x;

        do {
            numeratorCoeff *= 2 * n - 1;
            denominatorCoeff *= 2 * n;
            e = (numeratorCoeff * Math.pow(x, 2 * n - 1)) / (denominatorCoeff * (2 * n - 1));
            arcsin += e;
            n++;
        }while (Math.abs(e) > 0.0001);

        return Math.PI / 2 -  arcsin;
    }


}
