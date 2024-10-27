package Lab3_Event.Util;

import Lab3_Event.Annotation.AddedProduct;
import Lab3_Event.Annotation.RemovedProduct;
import lombok.Getter;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


public class ProductManager {

    @Getter
    private List<Product> productList = new ArrayList<>(); // Список товаров

    @Inject
    @AddedProduct
    private Event<List<Product>> productAddedEvent; // Событие добавления

    @Inject
    @RemovedProduct
    private Event<List<Product>> productRemovedEvent; // Событие удаления

    public void addProduct(Product product) {
        productList.add(product); // Добавление товара в список
        productAddedEvent.fire(new ArrayList<>(productList)); // Вызов события добавления
    }

    public void removeProduct(Product product) {
        if (productList.contains(product)) {
            productList.remove(product); // Удаление товара из списка
            productRemovedEvent.fire(new ArrayList<>(productList)); // Вызов события удаления
        } else {
            System.out.println("Товар " + product.getName() + " не найден в списке.");
        }
    }
}
