
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class ArcCosTest {

    @ParameterizedTest
    @ValueSource(doubles = {-10, -0.24, -1})
    public void negTest(double x){
        Assertions.assertEquals(Math.acos(x), ArcCos.run(x), 0.1);
    }

    @ParameterizedTest
    @ValueSource(doubles = {10, 0.15, 1})
    public void posTest(double x){
        Assertions.assertEquals(Math.acos(x), ArcCos.run(x), 0.1);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.01, 0.1, 0.001})
    public void posCloseToZeroTest(double x){
        Assertions.assertEquals(Math.acos(x), ArcCos.run(x), 0.1);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.01, -0.1, -0.001})
    public void negCloseToZeroTest(double x){
        Assertions.assertEquals(Math.acos(x), ArcCos.run(x), 0.1);
    }


    @ParameterizedTest
    @ValueSource(doubles = {0.0, -0.001, 0.001})
    public void zeroTest(double x){
        Assertions.assertEquals(Math.acos(x), ArcCos.run(x), 0.1);
    }


    @ParameterizedTest
    @ValueSource(doubles = {0.99, 0.95, 0.9})
    public void posCloseTest(double x){
        Assertions.assertEquals(Math.acos(x), ArcCos.run(x), 0.1);
    }


    @ParameterizedTest
    @ValueSource(doubles = {-0.99, -0.95, -0.9})
    public void negCloseTest(double x){
        Assertions.assertEquals(Math.acos(x), ArcCos.run(x), 0.1);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.0, 1.0 + 0.001, 1.0 - 0.001})
    public void posEdgeCheck(double x) {
        Assertions.assertEquals(Math.acos(x), ArcCos.run(x), 0.1);    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.0, -1.0 - 0.001, -1.0 + 0.001})
    public void negEdgeCheck(double x) {
        Assertions.assertEquals(Math.acos(x), ArcCos.run(x), 0.1);    }

}