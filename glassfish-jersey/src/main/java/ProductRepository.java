import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

}
