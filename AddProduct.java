import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AddProduct {
    public static void addProduct(List<Product> products) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();

        System.out.print("Nhập số lượng: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();

        System.out.print("Nhập giá: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhập màu sắc: ");
        String color = scanner.nextLine();

        Product newProduct = new Product(name, quantity, description, price, color);
        products.add(newProduct);
        saveProductToFile(newProduct);
        System.out.println("Sản phẩm đã được thêm thành công.");
    }

    private static void saveProductToFile(Product product) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("QuanLykhoHang.txt", true))) {
            writer.write(product.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi sản phẩm vào tệp: " + e.getMessage());
        }
    }
}
