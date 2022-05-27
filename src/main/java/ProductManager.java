public class ProductManager {
    private final ProductRepository repository;

    public ProductManager(ProductRepository repository1) {
        this.repository = repository1;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                int length = result.length + 1;
                Product[] tmp = new Product[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int LastIndex = tmp.length - 1;
                tmp[LastIndex] = product;
                result = tmp; // "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        return product.getTitle().contains(search);
        // или в одну строку:
        // return product.getName().contains(search);
    }

    public void add(Product product) {
        repository.save(product);

    }
}