import java.util.List;
import java.util.Scanner;

public class DeleteProduct {
    public static void deleteProduct(List<Product> products) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên sản phẩm cần xóa: ");
        String name = scanner.nextLine().trim();
        Product productToDelete = null;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                productToDelete = product;
                break;
            }
        }

        if (productToDelete != null) {
            System.out.print("Nhập số lượng muốn xóa: ");
            int quantityToDelete = scanner.nextInt();
            scanner.nextLine();
            if (quantityToDelete >= productToDelete.getQuantity()) {
                products.remove(productToDelete);
                System.out.println("Đã xóa sản phẩm: " + name);
            } else {
                int newQuantity = productToDelete.getQuantity() - quantityToDelete;
                products.set(products.indexOf(productToDelete), new Product(productToDelete.getName(), newQuantity, productToDelete.getColor(), productToDelete.getPrice()));
                System.out.println("Đã cập nhật số lượng sản phẩm: " + productToDelete.getName() + " còn lại: " + newQuantity);
            }
        } else {
            System.out.println("Sản phẩm không tìm thấy.");
        }
    }
}
