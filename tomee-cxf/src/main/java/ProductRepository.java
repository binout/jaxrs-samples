import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class ProductRepository {

    private Map<String, Product> products = new HashMap<String, Product>();

    public void addProduct(Product p) {
        products.put(p.getName(), p);
    }

    public Iterator<Product> getProducts() {
        return products.values().iterator();
    }

    public Product getProductByName(String name) {
        return products.get(name);
    }

    public void clear() {
        products.clear();
    }

}
