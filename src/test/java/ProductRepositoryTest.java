import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Test
    void shouldSaveOneProduct() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product product1 = new Product(2, "tttt", 555);

        manager.add(product1);
        Product[] all = repository.findAll();
        Product[] expected = {product1};

        assertArrayEquals(expected, all);
    }

    @Test
    void shouldSaveNotProduct() {
        ProductRepository repository = new ProductRepository();


        Product[] all = repository.findAll();
        Product[] expected = {};

        assertArrayEquals(expected, all);
    }

    @Test
    void shouldFindAllWhenNotProduct() {
        ProductRepository repository = new ProductRepository();


        Product[] all = repository.findAll();
        Product[] expected = {};

        assertArrayEquals(expected, all);
    }

    @Test
    void shouldFindAllWhenOneProduct() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product product1 = new Product(2, "tttt", 555);

        manager.add(product1);
        Product[] all = repository.findAll();
        Product[] expected = {product1};

        assertArrayEquals(expected, all);
    }

    @Test
    void shouldFindAllWhenToProduct() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product product1 = new Product(2, "tttt", 555);
        Product product2 = new Book(1, "jkl", 899, "iiio");

        manager.add(product1);
        manager.add(product2);

        Product[] all = repository.findAll();
        Product[] expected = {product1, product2};

        assertArrayEquals(expected, all);
    }

    @Test
    void shouldWhenRemoveByIdOneProductOfTheTwo() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product product1 = new Product(2, "tyyt", 565);
        Product product2 = new Smartphone(5, "tttt", 555, "nnnb");

        manager.add(product1);
        manager.add(product2);
        repository.removeById(2);


        Product[] all = repository.findAll();
        Product[] expected = {product2};

        assertArrayEquals(expected, all);
    }

    @Test
    void shouldWhenRemoveByIdOneProductOfTheOne() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product product1 = new Product(2, "tttt", 555);


        manager.add(product1);
        repository.removeById(2);


        Product[] all = repository.findAll();
        Product[] expected = {};

        assertArrayEquals(expected, all);
    }
}