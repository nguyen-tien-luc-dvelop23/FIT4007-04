import java.util.List;

public class DisplayProducts {
    public static void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Không có sản phẩm nào trong kho.");
            return;
        }
        System.out.println("--- Danh sách sản phẩm ---");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static void displayProductsUnder100k(List<Product> products) {
        boolean hasProducts = false;
        System.out.println("--- Sản phẩm dưới 100 nghìn ---");
        for (Product product : products) {
            if (product.getPrice() < 100000) {
                System.out.println(product);
                hasProducts = true;
            }
        }
        if (!hasProducts) {
            System.out.println("Không có sản phẩm nào dưới 100 nghìn.");
        }
    }
}
