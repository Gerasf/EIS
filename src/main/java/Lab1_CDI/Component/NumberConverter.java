package Lab1_CDI.Component;

import Lab1_CDI.Converter.Abstraction.INumberConverter;
import Lab1_CDI.Converter.Annotation.BINARY;
import Lab1_CDI.Converter.Annotation.HEXADECIMAL;
import Lab1_CDI.Converter.Annotation.OCTAL;
import Lab1_CDI.Interceptor.ProfileInterceptor;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import javax.interceptor.Interceptors;

@Interceptors(ProfileInterceptor.class) // Перехватчик
@NoArgsConstructor
public class NumberConverter {


    // Точка внедрения зависимости
    // Dependency Injection
    @Inject
//    @BINARY
    @OCTAL
//    @HEXADECIMAL
    private INumberConverter numberConverter;

    public String convert(int decimal) {
        return numberConverter.convert(decimal);
    }

}
