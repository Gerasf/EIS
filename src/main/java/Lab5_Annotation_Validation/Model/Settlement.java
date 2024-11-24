package Lab5_Annotation_Validation.Model;

import Lab5_Annotation_Validation.Annotation.ValidPopulationDensity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ValidPopulationDensity
public class Settlement {
    private long population; // Количество человек
    private double area; // Площадь в квадратных километрах
    private double populationDensity; // Плотность населения (человек/км²)
}
