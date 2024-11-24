package Lab5_Annotation_Validation.Validator;

import Lab5_Annotation_Validation.Model.Settlement;
import Lab5_Annotation_Validation.Annotation.ValidPopulationDensity;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PopulationDensityValidator implements ConstraintValidator<ValidPopulationDensity, Settlement> {

    @Override
    public boolean isValid(Settlement settlement, ConstraintValidatorContext context) {
        if (settlement.getArea() <= 0) {
            return true; // Площадь <= 0 не проверяется, это можно валидировать другими аннотациями
        }
        double calculatedDensity = settlement.getPopulation() / settlement.getArea();
        return Math.abs(calculatedDensity - settlement.getPopulationDensity()) < 0.0001; // Допуск на погрешность вычислений
    }
}
