package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;

public class ComplexValue extends AbstractValue {

    private final double real;
    private final double imaginary;

    public ComplexValue(double real, double imaginary)
    {
        super();
        this.real = real;
        this.imaginary = imaginary;
    }

    public AbstractValue add(AbstractValue operand){
        return new ComplexValue(this.real + ((ComplexValue) operand).real,
                this.imaginary + ((ComplexValue) operand).imaginary);
    }

    public AbstractValue sub(AbstractValue operand){
        return new ComplexValue(this.real - ((ComplexValue) operand).real,
                this.imaginary - ((ComplexValue) operand).imaginary);
    }

    public AbstractValue mul(AbstractValue operand){
        return new ComplexValue(this.real * ((ComplexValue) operand).real -
                this.imaginary * ((ComplexValue) operand).imaginary,
                this.real * ((ComplexValue) operand).imaginary +
                        this.imaginary * ((ComplexValue) operand).real);
    }

    public AbstractValue div(AbstractValue operand) throws DivisionByZeroException{
        if (((ComplexValue) operand).real == 0 && ((ComplexValue) operand).imaginary == 0)
            throw new DivisionByZeroException();
        else
        {
            ComplexValue z2 = (ComplexValue) operand;
            double d = z2.real * z2.real + z2.imaginary *  z2.imaginary;
            ComplexValue z1z2 = (ComplexValue) this.mul(new ComplexValue(z2.real, -z2.imaginary));
            return new ComplexValue(z1z2.real / d, z1z2.imaginary / d);
        }
    }

    public String toString() {
        return String.format("%1$.8f+%2$.8fi", this.real, this.imaginary);
    }

    //public boolean equals(AbstractValue operand){
    //    return this.real == ((ComplexValue) operand).real &&
    //            this.imaginary == ((ComplexValue) operand).imaginary;
    //}
}