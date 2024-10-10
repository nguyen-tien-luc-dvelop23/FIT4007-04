import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(int id, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getId() == id) {
                products.set(i, updatedProduct);
                return;
            }
        }
        System.out.println("Product not found with ID: " + id);
    }

    public void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    public List<Product> searchProducts(String keyword) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
