package Lab3_Event.Util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String name; // Наименование товара
    private double pricePerUnit; // Цена за единицу товара

    @Override
    public String toString() {
        return "Товар: " + name + ", Цена за единицу: " + pricePerUnit;
    }
}
