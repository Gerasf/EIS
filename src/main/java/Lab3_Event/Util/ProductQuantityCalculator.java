package Lab3_Event.Util;

import Lab3_Event.Annotation.AddedProduct;
import Lab3_Event.Annotation.RemovedProduct;

import javax.enterprise.event.Observes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductQuantityCalculator {

    private final Map<String, Integer> productQuantities = new HashMap<>(); // Количество товаров

    // Метод для обработки события добавления товара
    public void calculateQuantityOnAdd(@Observes @AddedProduct List<Product> productList) {
        updateQuantities(productList);
        System.out.println("Количество товаров после добавления: " + productQuantities);
    }

    // Метод для обработки события удаления товара
    public void calculateQuantityOnRemove(@Observes @RemovedProduct List<Product> productList) {
        updateQuantities(productList);
        System.out.println("Количество товаров после удаления: " + productQuantities);
    }

    // Метод для обновления количества товаров
    private void updateQuantities(List<Product> productList) {
        productQuantities.clear();
        for (Product product : productList) {
            productQuantities.put(product.getName(), productQuantities.getOrDefault(product.getName(), 0) + 1);
        }
    }
}
