package soze.software.industries.eMall;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class RealNumber extends BigDecimal {

    private static final long        serialVersionUID = 1L;

    private static final MathContext MATH_CONTEXT     = new MathContext(8, RoundingMode.HALF_EVEN);

    public RealNumber(String val) {
        super(val, MATH_CONTEXT);
    }

    public RealNumber(Long val) {
        this(Long.toString(val));
    }

    public RealNumber(Integer val) {
        this(Integer.toString(val));
    }

    public RealNumber(Double val) {
        this(Double.toString(val));
    }

    public RealNumber add(RealNumber augend) {
        return new RealNumber(super.add(augend, MATH_CONTEXT).toString());
    }

    public RealNumber subtract(RealNumber subtrahend) {
        return new RealNumber(super.subtract(subtrahend, MATH_CONTEXT).toString());
    }

    public RealNumber multiply(RealNumber multiplicand) {
        return new RealNumber(super.multiply(multiplicand, MATH_CONTEXT).toString());
    }

    public RealNumber divide(RealNumber divisor) {
        return new RealNumber(super.divide(divisor, MATH_CONTEXT).toString());
    }

}
