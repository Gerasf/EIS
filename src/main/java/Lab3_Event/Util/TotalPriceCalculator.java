package Lab3_Event.Util;

import Lab3_Event.Annotation.AddedProduct;
import Lab3_Event.Annotation.RemovedProduct;

import javax.enterprise.event.Observes;
import java.util.List;

public class TotalPriceCalculator {

    private double totalPrice = 0.0; // Общая цена всех товаров

    // Метод для обработки события добавления товара
    public void calculateTotalPriceOnAdd(@Observes @AddedProduct List<Product> productList) {
        totalPrice = calculateTotal(productList);
        System.out.println("Общая цена всех товаров после добавления: " + totalPrice);
    }

    // Метод для обработки события удаления товара
    public void calculateTotalPriceOnRemove(@Observes @RemovedProduct List<Product> productList) {
        totalPrice = calculateTotal(productList);
        System.out.println("Общая цена всех товаров после удаления: " + totalPrice);
    }

    // Метод для вычисления общей цены товаров
    private double calculateTotal(List<Product> productList) {
        double sum = 0.0;
        for (Product product : productList) {
            sum += product.getPricePerUnit();
        }
        return sum;
    }
}
