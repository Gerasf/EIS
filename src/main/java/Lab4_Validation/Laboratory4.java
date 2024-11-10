package Lab4_Validation;

import Lab4_Validation.Model.CodeValidateSettlement;
import Lab4_Validation.Model.XmlValidatedSettlement;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import java.util.Set;

public class Laboratory4 {

    public static void main(String[] args) {
        // Создание фабрики валидаторов
        ValidatorFactory factory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator = factory.getValidator();

        // Создание и проверка объекта XmlValidatedSettlement
        XmlValidatedSettlement xmlSettlement = new XmlValidatedSettlement();
        xmlSettlement.setName("Москва");
        xmlSettlement.setPostalCode("123456");
        xmlSettlement.setRegion("Центральный");
        xmlSettlement.setCountry("Россия");
        xmlSettlement.setFoundationYear(1147);

        System.out.println("Валидация XmlValidatedSettlement:");
        validateAndPrint(validator, xmlSettlement);

        // Создание и проверка объекта CodeValidateSettlement
        CodeValidateSettlement codeSettlement = new CodeValidateSettlement();
        codeSettlement.setName("Лондон");
        codeSettlement.setPostalCode("654321");
        codeSettlement.setRegion("Южный");
        codeSettlement.setCountry("Великобритания");
        codeSettlement.setFoundationYear(43);

        System.out.println("\nВалидация CodeValidateSettlement:");
        validateAndPrint(validator, codeSettlement);
    }

    // Метод для валидации и вывода результата валидации в консоль
    private static <T> void validateAndPrint(Validator validator, T object) {
        Set<ConstraintViolation<T>> violations = validator.validate(object);
        if (violations.isEmpty()) {
            System.out.println("Валидация прошла успешно!");
        } else {
            for (ConstraintViolation<T> violation : violations) {
                System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
            }
        }
    }
}
