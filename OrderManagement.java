import java.io.*;
import java.util.*;

public class OrderManagement {
    private static Map<String, Order> orderCatalog = new HashMap<>();
    private static final String ORDER_FILE = "D:\\DAINAM\\ltdt\\baitaplon\\orders.txt"; // Đảm bảo đường dẫn file đúng

    // Đọc danh sách đơn hàng từ file
    public static void loadOrdersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ORDER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String orderId = data[0];
                String customerName = data[1];
                String productId = data[2];
                int quantity = Integer.parseInt(data[3]);
                String status = data[4];
                Order order = new Order(orderId, customerName, productId, quantity, status);
                orderCatalog.put(orderId, order);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file đơn hàng: " + e.getMessage());
        }
    }

    // Ghi danh sách đơn hàng vào file
    private static void saveOrdersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ORDER_FILE))) {
            for (Order order : orderCatalog.values()) {
                writer.write(order.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file đơn hàng: " + e.getMessage());
        }
    }

    // Phương thức quản lý đơn hàng
    public static void manageOrder(Scanner scanner) {
        loadOrdersFromFile();  // Đọc đơn hàng từ file khi bắt đầu

        while (true) {
            System.out.println("\n---- Quản lý Đơn Hàng ----");
            System.out.println("1. Tạo đơn hàng mới");
            System.out.println("2. Cập nhật trạng thái đơn hàng");
            System.out.println("3. Tìm kiếm đơn hàng");
            System.out.println("4. Hiển thị danh sách đơn hàng");
            System.out.println("5. Quay lại");
            System.out.print("Lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addOrder(scanner);
                    break;
                case 2:
                    updateOrderStatus(scanner);
                    break;
                case 3:
                    searchOrder(scanner);
                    break;
                case 4:
                    displayOrders();
                    break;
                case 5:
                    saveOrdersToFile();  // Ghi lại đơn hàng vào file khi thoát
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    // Thêm đơn hàng
    private static void addOrder(Scanner scanner) {
        System.out.print("Nhập mã đơn hàng: ");
        String orderId = scanner.nextLine();
        System.out.print("Nhập tên khách hàng: ");
        String customerName = scanner.nextLine();
        System.out.print("Nhập mã sản phẩm: ");
        String productId = scanner.nextLine();
        System.out.print("Nhập số lượng: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // consume the newline
        System.out.print("Nhập trạng thái đơn hàng: ");
        String status = scanner.nextLine();
        Order order = new Order(orderId, customerName, productId, quantity, status);
        orderCatalog.put(orderId, order);
        System.out.println("Đơn hàng đã được tạo.");
        saveOrdersToFile();  // Ghi đơn hàng vào file sau khi thêm
    }

    // Cập nhật trạng thái đơn hàng
    private static void updateOrderStatus(Scanner scanner) {
        System.out.print("Nhập mã đơn hàng cần cập nhật: ");
        String orderId = scanner.nextLine();
        if (orderCatalog.containsKey(orderId)) {
            System.out.print("Nhập trạng thái mới: ");
            String newStatus = scanner.nextLine();
            Order order = orderCatalog.get(orderId);
            order.status = newStatus;
            System.out.println("Trạng thái đơn hàng đã được cập nhật.");
            saveOrdersToFile();  // Ghi đơn hàng vào file sau khi cập nhật
        } else {
            System.out.println("Đơn hàng không tồn tại.");
        }
    }

    // Tìm kiếm đơn hàng
    private static void searchOrder(Scanner scanner) {
        System.out.print("Nhập mã đơn hàng hoặc tên khách hàng để tìm kiếm: ");
        String searchQuery = scanner.nextLine();
        for (Order order : orderCatalog.values()) {
            if (order.orderId.equals(searchQuery) || order.customerName.equalsIgnoreCase(searchQuery)) {
                System.out.println(order);
            }
        }
    }

    // Hiển thị tất cả đơn hàng
    private static void displayOrders() {
        if (orderCatalog.isEmpty()) {
            System.out.println("Không có đơn hàng nào.");
        } else {
            for (Order order : orderCatalog.values()) {
                System.out.println(order);
            }
        }
    }
}
