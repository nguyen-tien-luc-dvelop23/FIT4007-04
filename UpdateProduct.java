import java.util.List;
import java.util.Scanner;

public class UpdateProduct {
    public static void updateProduct(List<Product> products) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên sản phẩm cần cập nhật: ");
        String name = scanner.nextLine();

        Product productToUpdate = null;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                productToUpdate = product;
                break;
            }
        }

        if (productToUpdate == null) {
            System.out.println("Sản phẩm không tìm thấy.");
            return;
        }

        System.out.print("Nhập số lượng mới: ");
        int newQuantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập mô tả mới: ");
        String newDescription = scanner.nextLine();
        System.out.print("Nhập giá mới: ");
        double newPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập màu sắc mới: ");
        String newColor = scanner.nextLine();

        products.remove(productToUpdate);
        Product updatedProduct = new Product(name, newQuantity, newDescription, newPrice, newColor);
        products.add(updatedProduct);
        System.out.println("Sản phẩm đã được cập nhật thành công.");
    }
}
