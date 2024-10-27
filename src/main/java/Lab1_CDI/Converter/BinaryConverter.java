package Lab1_CDI.Converter;

import Lab1_CDI.Converter.Abstraction.INumberConverter;
import Lab1_CDI.Converter.Annotation.BINARY;
import lombok.NoArgsConstructor;

@BINARY
@NoArgsConstructor
public class BinaryConverter implements INumberConverter {

    @Override
    public String convert(int decimal) {
        return Integer.toBinaryString(decimal);
    }
}
