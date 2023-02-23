public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }


    public double getDecimal() {
        return (double) numerator / denominator;
    }

    public int compareDecimals(Fraction second) {
        double firstDecimal = this.getDecimal();
        double secondDecimal = second.getDecimal();

        return Double.compare(firstDecimal, secondDecimal);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public String toMixedNumber() {
        int number = numerator / denominator;
        int remainder = numerator % denominator;

        if (remainder == 0) {
            return number+",";
        } else {
            if (number == 0) {
                return remainder + "/" + denominator+",";
            } else {
                return number + " " + remainder + "/" + denominator+",";
            }
        }
    }





}
