import java.io.*;
import java.util.*;

public class SupplierManagement {
    private static Map<String, Supplier> supplierCatalog = new HashMap<>();
    private static final String SUPPLIER_FILE = "D:\\WarehouseManagement\\suppliers.txt";

    // Đọc nhà cung cấp từ file
    public static void loadSuppliersFromFile() {
        File file = new File(SUPPLIER_FILE);
        if (!file.exists()) {
            try {
                file.createNewFile(); // Tạo file nếu không tồn tại
                System.out.println("File nhà cung cấp không tồn tại, đã tạo mới.");
            } catch (IOException e) {
                System.out.println("Lỗi khi tạo file: " + e.getMessage());
                return;
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(SUPPLIER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String address = data[1];
                String products = data[2];
                Supplier supplier = new Supplier(name, address, products);
                supplierCatalog.put(name, supplier);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file nhà cung cấp: " + e.getMessage());
        }
    }

    // Lưu nhà cung cấp vào file
    private static void saveSuppliersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SUPPLIER_FILE))) {
            for (Supplier supplier : supplierCatalog.values()) {
                writer.write(supplier.name + "," + supplier.address + "," + supplier.products);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file nhà cung cấp: " + e.getMessage());
        }
    }

    // Quản lý nhà cung cấp
    public static void manageSupplier(Scanner scanner) {
        loadSuppliersFromFile();

        while (true) {
            System.out.println("\n---- Quản lý Nhà Cung Cấp ----");
            System.out.println("1. Thêm nhà cung cấp mới");
            System.out.println("2. Hiển thị nhà cung cấp");
            System.out.println("3. Quay lại");
            System.out.print("Lựa chọn của bạn: ");
            String choice = scanner.nextLine();  // Sử dụng nextLine() thay cho nextInt()

            switch (choice) {
                case "1":
                    addSupplier(scanner);
                    break;
                case "2":
                    displaySuppliers();
                    break;
                case "3":
                    saveSuppliersToFile();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    // Thêm nhà cung cấp mới
    private static void addSupplier(Scanner scanner) {
        System.out.print("Nhập tên nhà cung cấp: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("Tên nhà cung cấp không được để trống.");
            return;
        }

        System.out.print("Nhập địa chỉ nhà cung cấp: ");
        String address = scanner.nextLine();
        if (address.isEmpty()) {
            System.out.println("Địa chỉ không được để trống.");
            return;
        }

        System.out.print("Nhập các mặt hàng cung cấp: ");
        String products = scanner.nextLine();
        if (products.isEmpty()) {
            System.out.println("Mặt hàng không được để trống.");
            return;
        }

        Supplier supplier = new Supplier(name, address, products);
        supplierCatalog.put(name, supplier);
        System.out.println("Nhà cung cấp đã được thêm.");
    }

    // Hiển thị danh sách nhà cung cấp
    private static void displaySuppliers() {
        if (supplierCatalog.isEmpty()) {
            System.out.println("Không có nhà cung cấp nào.");
        } else {
            for (Supplier supplier : supplierCatalog.values()) {
                System.out.println(supplier);
            }
        }
    }
}
