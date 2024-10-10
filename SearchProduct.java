import java.util.List;
import java.util.Scanner;

public class SearchProduct {
    public static void searchProduct(List<Product> products) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println("Sản phẩm tìm thấy: " + product);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm nào.");
        }
    }
}
