// CustomerManagement.java
import java.io.*;
import java.util.*;

public class CustomerManagement {
    private static Map<String, Customer> customerCatalog = new HashMap<>();
    private static final String CUSTOMER_FILE = "D:\\WarehouseManagement\\customers.txt";

    public static void loadCustomersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CUSTOMER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String address = data[1];
                String phone = data[2];
                String purchaseHistory = data.length > 3 ? data[3] : "";
                Customer customer = new Customer(name, address, phone, purchaseHistory);
                customerCatalog.put(phone, customer);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file khách hàng: " + e.getMessage());
        }
    }

    private static void saveCustomersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CUSTOMER_FILE))) {
            for (Customer customer : customerCatalog.values()) {
                writer.write(customer.name + "," + customer.address + "," + customer.phone + "," + customer.purchaseHistory);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file khách hàng: " + e.getMessage());
        }
    }

    public static void manageCustomer(Scanner scanner) {
        loadCustomersFromFile();

        while (true) {
            System.out.println("\n---- Quản lý Khách Hàng ----");
            System.out.println("1. Thêm khách hàng mới");
            System.out.println("2. Hiển thị khách hàng");
            System.out.println("3. Quay lại");
            System.out.print("Lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCustomer(scanner);
                    break;
                case 2:
                    displayCustomers();
                    break;
                case 3:
                    saveCustomersToFile();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void addCustomer(Scanner scanner) {
        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.print("Nhập địa chỉ khách hàng: ");
        String address = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.print("Nhập lịch sử mua hàng: ");
        String purchaseHistory = scanner.nextLine();
        Customer customer = new Customer(name, address, phone, purchaseHistory);
        customerCatalog.put(phone, customer);
        System.out.println("Khách hàng đã được thêm.");
    }

    private static void displayCustomers() {
        if (customerCatalog.isEmpty()) {
            System.out.println("Không có khách hàng nào.");
        } else {
            for (Customer customer : customerCatalog.values()) {
                System.out.println(customer);
            }
        }
    }
}
