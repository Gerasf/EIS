package Lab1_CDI.Converter;

import Lab1_CDI.Converter.Abstraction.INumberConverter;
import Lab1_CDI.Converter.Annotation.OCTAL;
import lombok.NoArgsConstructor;

@OCTAL
@NoArgsConstructor
public class OctalConverter implements INumberConverter {

    @Override
    public String convert(int decimal) {
        return Integer.toOctalString(decimal);
    }
}
