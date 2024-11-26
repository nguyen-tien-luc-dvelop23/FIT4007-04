import java.io.*;
import java.util.*;

public class EmployeeManagement {
    private static Map<String, Employee> employeeCatalog = new HashMap<>();
    private static final String EMPLOYEE_FILE = "D:\\WarehouseManagement\\employee_data.txt";
    private static final String WORK_HOURS_FILE = "D:\\WarehouseManagement\\work_hours.txt";
    private static final String LEAVE_TIME_FILE = "D:\\WarehouseManagement\\leave_time.txt";

    public static void loadEmployeesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(EMPLOYEE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String id = data[1];
                String position = data[2];
                String address = data[3];
                String phone = data[4];
                String email = data[5];
                Employee employee = new Employee(name, id, position, address, phone, email);
                employeeCatalog.put(id, employee);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file nhân viên: " + e.getMessage());
        }
    }

    private static void saveEmployeesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(EMPLOYEE_FILE))) {
            for (Employee employee : employeeCatalog.values()) {
                writer.write(employee.name + "," + employee.id + "," + employee.position + ","
                        + employee.address + "," + employee.phone + "," + employee.email);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file nhân viên: " + e.getMessage());
        }
    }

    public static void manageEmployee(Scanner scanner) {
        loadEmployeesFromFile();

        while (true) {
            System.out.println("\n---- Quản lý Nhân Viên ----");
            System.out.println("1. Thêm nhân viên mới");
            System.out.println("2. Hiển thị nhân viên");
            System.out.println("3. Xóa nhân viên");
            System.out.println("4. Báo cáo giờ làm việc");
            System.out.println("5. Thêm giờ nghỉ");
            System.out.println("6. Quay lại");
            System.out.print("Lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    removeEmployee(scanner);
                    break;
                case 4:
                    reportWorkHours(scanner);
                    break;
                case 5:
                    addLeaveTime(scanner);
                    break;
                case 6:
                    saveEmployeesToFile();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập mã nhân viên: ");
        String id = scanner.nextLine();
        System.out.print("Nhập chức vụ: ");
        String position = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();

        Employee employee = new Employee(name, id, position, address, phone, email);
        employeeCatalog.put(id, employee);
        System.out.println("Nhân viên đã được thêm.");
    }

    private static void displayEmployees() {
        if (employeeCatalog.isEmpty()) {
            System.out.println("Không có nhân viên nào.");
        } else {
            for (Employee employee : employeeCatalog.values()) {
                System.out.println(employee);
            }
        }
    }

    private static void removeEmployee(Scanner scanner) {
        System.out.print("Nhập mã nhân viên cần xóa: ");
        String id = scanner.nextLine();
        if (employeeCatalog.containsKey(id)) {
            employeeCatalog.remove(id);
            System.out.println("Nhân viên đã được xóa.");
        } else {
            System.out.println("Nhân viên không tồn tại.");
        }
    }

    private static void reportWorkHours(Scanner scanner) {
        // Báo cáo giờ làm việc cho nhân viên (ví dụ sử dụng work_hours.txt)
        System.out.println("Chức năng báo cáo giờ làm việc sẽ được cập nhật sau.");
    }

    private static void addLeaveTime(Scanner scanner) {

        System.out.println("Chức năng thêm giờ nghỉ sẽ được cập nhật sau.");
    }
}
