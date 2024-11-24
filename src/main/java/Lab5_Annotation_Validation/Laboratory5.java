package Lab5_Annotation_Validation;

import Lab5_Annotation_Validation.Model.Settlement;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

public class Laboratory5 {
    public static void main(String[] args) {
        Settlement validSettlement = new Settlement(1000, 2.0, 500.0); // Плотность = 1000 / 2 = 500
        Settlement invalidSettlement = new Settlement(1000, 2.0, 600.0); // Неверная плотность

        ValidatorFactory factory = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator = factory.getValidator();

        System.out.println("Валидный населенный пункт:");
        validator.validate(validSettlement).forEach(violation -> System.out.println(violation.getMessage()));

        System.out.println("\nНевалидный населенный пункт:");
        validator.validate(invalidSettlement).forEach(violation -> System.out.println(violation.getMessage()));
    }
}
