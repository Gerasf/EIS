package Lab5_Annotation_Validation.Annotation;

import Lab5_Annotation_Validation.Validator.PopulationDensityValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PopulationDensityValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPopulationDensity {
    String message() default "Плотность населения не равна частному населения и площади";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
