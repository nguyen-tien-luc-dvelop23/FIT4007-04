import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private static List<Product> products = new ArrayList<>();

    public static void handleProductManagement(Scanner scanner) {
        int choice;
        do {
            System.out.println("      Quản lý sản phẩm    ");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xóa sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Tìm kiếm sản phẩm");
            System.out.println("5. Kiểm kê tồn kho");
            System.out.println("6. Xuất kho");
            System.out.println("7. Nhập kho");
            System.out.println("8. Quay lại");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    removeProduct(scanner);
                    break;
                case 3:
                    updateProduct(scanner);
                    break;
                case 4:
                    searchProduct(scanner);
                    break;
                case 5:
                    inventoryCheck();
                    break;
                case 6:
                    exportProduct(scanner);
                    break;
                case 7:
                    importProduct(scanner);
                    break;
                case 8:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 8);
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập danh mục: ");
        String category = scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();
        System.out.print("Nhập số lượng: ");
        int quantity = scanner.nextInt();
        System.out.print("Nhập giá bán: ");
        double price = scanner.nextDouble();
        System.out.print("Nhập giá nhập: ");
        double costPrice = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer
        System.out.print("Nhập nhà cung cấp: ");
        String supplier = scanner.nextLine();

        Product product = new Product(id, name, category, description, quantity, price, costPrice, supplier);
        products.add(product);
        System.out.println("Sản phẩm đã được thêm thành công!");
    }

    private static void removeProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        String id = scanner.nextLine();
        Product product = findProductById(id);
        if (product != null) {
            products.remove(product);
            System.out.println("Sản phẩm đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }

    private static void updateProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        String id = scanner.nextLine();
        Product product = findProductById(id);
        if (product != null) {
            System.out.print("Nhập tên mới (bỏ trống để giữ nguyên): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) product.setName(newName);

            System.out.print("Nhập số lượng mới (-1 để giữ nguyên): ");
            int newQuantity = scanner.nextInt();
            if (newQuantity != -1) product.setQuantity(newQuantity);

            System.out.print("Nhập giá bán mới (-1 để giữ nguyên): ");
            double newPrice = scanner.nextDouble();
            if (newPrice != -1) product.setPrice(newPrice);

            System.out.println("Thông tin sản phẩm đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }

    private static void searchProduct(Scanner scanner) {
        System.out.print("Nhập tên hoặc mã sản phẩm: ");
        String keyword = scanner.nextLine().toLowerCase();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(keyword) || product.getId().toLowerCase().contains(keyword)) {
                System.out.println(product);
            }
        }
    }

    private static void inventoryCheck() {
        System.out.println("Danh sách tồn kho:");
        for (Product product : products) {
            System.out.println(product.getName() + " - Số lượng: " + product.getQuantity());
        }
    }

    private static void exportProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần xuất: ");
        String id = scanner.nextLine();
        System.out.print("Nhập số lượng cần xuất: ");
        int quantity = scanner.nextInt();
        Product product = findProductById(id);
        if (product != null) {
            if (product.getQuantity() >= quantity) {
                product.setQuantity(product.getQuantity() - quantity);
                System.out.println("Xuất sản phẩm thành công. Số lượng còn lại: " + product.getQuantity());
            } else {
                System.out.println("Không đủ số lượng.");
            }
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }

    private static void importProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần nhập kho: ");
        String id = scanner.nextLine();
        System.out.print("Nhập số lượng cần nhập: ");
        int quantity = scanner.nextInt();
        Product product = findProductById(id);
        if (product != null) {
            product.setQuantity(product.getQuantity() + quantity);
            System.out.println("Nhập kho thành công. Số lượng hiện tại: " + product.getQuantity());
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }

    private static Product findProductById(String id) {
        for (Product product : products) {
            if (product.getId().equalsIgnoreCase(id)) {
                return product;
            }
        }
        return null;
    }
}