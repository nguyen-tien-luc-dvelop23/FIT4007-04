import java.io.*;
import java.util.*;

public class ProductManagement {
    private static Map<String, Product> productCatalog = new HashMap<>();
    private static final String PRODUCT_FILE = "D:\\WarehouseManagement\\products.txt"; // Đảm bảo đường dẫn file đúng

    // Đọc danh sách sản phẩm từ file
    public static void loadProductsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PRODUCT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                int quantity = Integer.parseInt(data[3]);
                String category = data[4];
                String supplier = data[5];
                Product product = new Product(name, id, price, quantity, category, supplier);
                productCatalog.put(id, product);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file sản phẩm: " + e.getMessage());
        }
    }

    // Ghi danh sách sản phẩm vào file
    private static void saveProductsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRODUCT_FILE))) {
            for (Product product : productCatalog.values()) {
                writer.write(product.productId + "," + product.productName + "," + product.price + "," + product.quantity + "," + product.category + "," + product.supplier);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file sản phẩm: " + e.getMessage());
        }
    }


    public static void manageProduct(Scanner scanner) {
        loadProductsFromFile();

        while (true) {
            System.out.println("\n---- Quản lý Sản Phẩm ----");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Cập nhật sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Quay lại");
            System.out.print("Lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    updateProduct(scanner);
                    break;
                case 3:
                    deleteProduct(scanner);
                    break;
                case 4:
                    displayProducts();
                    break;
                case 5:
                    saveProductsToFile();  // Ghi lại sản phẩm vào file khi thoát
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    // Thêm sản phẩm
    private static void addProduct(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập mã sản phẩm: ");
        String id = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = scanner.nextDouble();
        System.out.print("Nhập số lượng: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // consume the newline
        System.out.print("Nhập loại sản phẩm: ");
        String category = scanner.nextLine();
        System.out.print("Nhập nhà cung cấp: ");
        String supplier = scanner.nextLine();
        Product product = new Product(name, id, price, quantity, category, supplier);
        productCatalog.put(id, product);
        System.out.println("Sản phẩm đã được thêm.");
        saveProductsToFile();
    }

    // Cập nhật sản phẩm
    private static void updateProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        String productId = scanner.nextLine();
        if (productCatalog.containsKey(productId)) {
            System.out.print("Nhập tên sản phẩm mới: ");
            String newName = scanner.nextLine();
            System.out.print("Nhập giá mới: ");
            double newPrice = scanner.nextDouble();
            System.out.print("Nhập số lượng mới: ");
            int newQuantity = scanner.nextInt();
            scanner.nextLine(); // consume the newline
            System.out.print("Nhập loại mới: ");
            String newCategory = scanner.nextLine();
            System.out.print("Nhập nhà cung cấp mới: ");
            String newSupplier = scanner.nextLine();
            Product updatedProduct = new Product(newName, productId, newPrice, newQuantity, newCategory, newSupplier);
            productCatalog.put(productId, updatedProduct);
            System.out.println("Sản phẩm đã được cập nhật.");
            saveProductsToFile();
        } else {
            System.out.println("Sản phẩm không tồn tại.");
        }
    }

    // Xóa sản phẩm
    private static void deleteProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        String productId = scanner.nextLine();
        if (productCatalog.containsKey(productId)) {
            productCatalog.remove(productId);
            System.out.println("Sản phẩm đã được xóa.");
            saveProductsToFile();
        } else {
            System.out.println("Sản phẩm không tồn tại.");
        }
    }

    private static void displayProducts() {
        if (productCatalog.isEmpty()) {
            System.out.println("Kho không có sản phẩm nào.");
        } else {
            for (Product product : productCatalog.values()) {
                System.out.println(product);
            }
        }
    }
}
