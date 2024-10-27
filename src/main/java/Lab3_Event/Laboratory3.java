package Lab3_Event;

import Lab3_Event.Util.Product;
import Lab3_Event.Util.ProductManager;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Laboratory3 {
    protected static Weld weld;

    protected static WeldContainer container;

    public static void main(String[] args) {
        weld = new Weld();
        container = weld.initialize();

        try {
            ProductManager productManager = container.select(ProductManager.class).get();

            Product product1 = new Product("Яблоко", 50.0);
            Product product2 = new Product("Банан", 30.0);
            Product product3 = new Product("Яблоко", 80.0);


            productManager.addProduct(product1);
            System.out.println("\n");
            productManager.addProduct(product2);
            System.out.println("\n");
            productManager.addProduct(product3); // Добавляем еще одно яблоко с другой ценой
            System.out.println("\n");
            productManager.addProduct(product1); // Добавляем еще одно яблоко
            System.out.println("\n");

            productManager.removeProduct(product1); // Удаляем одно яблоко

        } finally {
            weld.shutdown();
        }
    }
}
