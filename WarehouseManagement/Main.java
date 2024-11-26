import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n---- Hệ thống Quản lý Kho Hàng ----");
            System.out.println("1. Quản lý sản phẩm");
            System.out.println("2. Quản lý đơn hàng");
            System.out.println("3. Quản lý khách hàng");
            System.out.println("4. Quản lý nhà cung cấp");
            System.out.println("5. Báo cáo và phân tích");
            System.out.println("6. Hỗ trợ");
            System.out.println("7. Quản lý tài khoản (nhân viên)");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    ProductManagement.manageProduct(scanner);
                    break;
                case 2:
                    OrderManagement.manageOrder(scanner);
                    break;
                case 3:
                    CustomerManagement.manageCustomer(scanner);
                    break;
                case 4:
                    SupplierManagement.manageSupplier(scanner);
                    break;
                case 5:
                    System.out.println("Đang lỗi quay lại sau.");
                    break;
                case 6:
                    System.out.println("Thông tin hỗ trợ:\nTên: Nguyễn Tiến Lực\nZalo: https://chat.zalo.me/0386607818");
                    break;
                case 7:
                    EmployeeManagement.manageEmployee(scanner);
                    break;
                case 8:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}
