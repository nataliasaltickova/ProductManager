public class ProductRepository {
    protected Product[] items = new Product[0];


    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int LastIndex = tmp.length - 1;
        tmp[LastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {

        return items;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id:  " + id + " not found");
        }
        Product[] tmp = new Product[items.length - 1];
        int index = 0;

        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;

    }

    public Product findById(int id) {


        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

}

