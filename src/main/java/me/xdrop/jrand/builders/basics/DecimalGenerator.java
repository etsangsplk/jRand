package me.xdrop.jrand.builders.basics;

import me.xdrop.jrand.Generator;
import me.xdrop.jrand.JRand;

import java.math.BigDecimal;

public class DecimalGenerator extends Generator<String> {

    private double min;
    private double max;
    private int digits;
    private boolean roundUp;

    /**
     * Set the minimum value (inclusive)
     * @param min The minimum value
     * @return
     */
    public DecimalGenerator min(double min) {
        this.min = min;
        return this;
    }

    /**
     * Sets the maximum value (inclusive)
     * @param max The maximum value
     * @return
     */
    public DecimalGenerator max(double max) {
        this.max = max;
        return this;
    }

    /**
     * Sets the number of digits to return
     * @param digits Number of digits
     * @return
     */
    public DecimalGenerator digits(int digits) {
        this.digits = digits;
        return this;
    }

    /**
     * Set whether to round up or down
     * @param roundUp True for round up, false for round down
     * @return
     */
    public DecimalGenerator roundUp(boolean roundUp){
        this.roundUp = roundUp;
        return this;
    }

    @Override
    public String rand() {
        double rand = JRand.dbl().min(this.min).max(this.max).rand();
        BigDecimal decimal;
        if (roundUp) {
            decimal = BigDecimal.valueOf(rand).setScale(digits, BigDecimal.ROUND_UP);
        } else {
            decimal = BigDecimal.valueOf(rand).setScale(digits, BigDecimal.ROUND_DOWN);
        }
        return decimal.toString();
    }
}