package Lab3_Event.Util;

import Lab3_Event.Annotation.AddedProduct;
import Lab3_Event.Annotation.RemovedProduct;

import javax.enterprise.event.Observes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductPriceCalculator {

    private final Map<Product, Double> productPrices = new HashMap<>(); // Карта с уникальными экземплярами товаров и их ценами

    // Метод для обработки события добавления товара
    public void calculatePriceOnAdd(@Observes @AddedProduct List<Product> productList) {
        updatePrices(productList);
        printProductPrices();
    }

    // Метод для обработки события удаления товара
    public void calculatePriceOnRemove(@Observes @RemovedProduct List<Product> productList) {
        updatePrices(productList);
        printProductPrices();
    }

    // Метод для обновления цен товаров
    private void updatePrices(List<Product> productList) {
        productPrices.clear();
        for (Product product : productList) {
            productPrices.put(product, product.getPricePerUnit());
        }
    }

    // Метод для вывода цен товаров
    private void printProductPrices() {
        System.out.println("Цена каждого товара после изменения:");
        for (Map.Entry<Product, Double> entry : productPrices.entrySet()) {
            Product product = entry.getKey();
            System.out.println(product);
        }
    }
}
