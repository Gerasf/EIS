package Lab1_CDI.Converter;

import Lab1_CDI.Converter.Abstraction.INumberConverter;
import Lab1_CDI.Converter.Annotation.HEXADECIMAL;
import lombok.NoArgsConstructor;

@HEXADECIMAL
@NoArgsConstructor
public class HexadecimalConverter implements INumberConverter {

    @Override
    public String convert(int decimal) {
        return Integer.toHexString(decimal);
    }
}
