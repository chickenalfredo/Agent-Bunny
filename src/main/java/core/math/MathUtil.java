package core.math;

public class MathUtil {

    private final double EPSILON = 1e-8;

    public double abs(double num) {
        return num < 0 ? -num : num;
    }

    /**
     * @return the ePSILON
     */
    public double getEPSILON() {
        return EPSILON;
    }

    public int abs(int num) {
        return num < 0 ? -num : num;
    }

    public double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        } else if (value > max) {
            return max;
        } else {
            return value;
        }
    }

    public int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        } else if (value > max) {
            return max;
        } else {
            return value;
        }
    }

    public double sign(double value) {
        return value < 0 ? -1 : 1;
    }

    public int sign(int value) {
        return value < 0 ? -1 : 1;
    }

}