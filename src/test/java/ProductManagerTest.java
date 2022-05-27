import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {


    @Test
    void shouldOneProductSearchBy() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product product1 = new Product(1, "one", 22);
        Product product2 = new Product(3, "ten", 2332);
        Product product3 = new Product(22, "five", 2772);
        Product product4 = new Product(67, "seven", 9922);


        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);


        Product[] all = manager.searchBy("ten");

        Product[] expected = {product2};
        assertArrayEquals(expected, all);

    }

    @Test
    void shouldTwoProductSearchBy() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product product1 = new Product(1, "one", 22);
        Product product2 = new Product(3, "ten", 2332);
        Product product3 = new Product(22, "ten", 2772);
        Product product4 = new Product(67, "seven", 9922);

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);

        Product[] all = manager.searchBy("ten");

        Product[] expected = {product2, product3};
        assertArrayEquals(expected, all);

    }

    @Test
    void shouldWhenNotProductSearchBy() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product product1 = new Product(1, "one", 22);
        Product product2 = new Product(3, "ten", 2332);
        Product product3 = new Product(22, "five", 2772);
        Product product4 = new Product(67, "seven", 9922);


        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);


        Product[] all = manager.searchBy("to");

        Product[] expected = {};
        assertArrayEquals(expected, all);

    }


    @Test
    void shouldAddOneProduct() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product product = new Product(1, "one", 22);
        manager.add(product);

        Product[] all = repository.findAll();

        Product[] expected = {product};
        assertArrayEquals(expected, all);
    }

    @Test
    void shouldNotAddProduct() {
        ProductRepository repository = new ProductRepository();


        Product[] all = repository.findAll();

        Product[] expected = {};
        assertArrayEquals(expected, all);
    }
}