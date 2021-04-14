package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

import java.io.IOException;

public class ComplexValueParser implements AbstractValueParser {

    public AbstractValue parse(String value) throws ParseValueException {
        try {
            String[] values = value.split("\\+");
            double r = Double.parseDouble(values[0]);
            double i = Double.parseDouble(values[1].split("i")[0]);
            return new ComplexValue(r, i);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            throw new ParseValueException();
        }
    }

    public String getDatatypeName() {
        //return "Комплексные числа";
        return "complex number";
    }

}