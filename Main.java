import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Product> products = new ArrayList<>();
    private static final String FILE_NAME = "QuanLykhoHang.txt";
    private static final String PINK = "\u001B[35m";
    public static void main(String[] args) {
        loadProductsFromFile();

        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(PINK + "\n--- Quản lý kho hàng ---" );
            System.out.println(PINK + "1. Thêm sản phẩm" );
            System.out.println(PINK + "2. Hiển thị sản phẩm" );
            System.out.println(PINK + "3. Cập nhật sản phẩm" );
            System.out.println(PINK + "4. Xóa sản phẩm" );
            System.out.println(PINK + "5. Tìm kiếm sản phẩm" );
            System.out.println(PINK + "6. Hiển thị tổng số sản phẩm" );
            System.out.println(PINK + "7. Hiển thị sản phẩm dưới 100 nghìn" );
            System.out.println(PINK + "8. Thoát" );
            System.out.print(PINK + "Chọn chức năng: " );
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    AddProduct.addProduct(products);
                    break;
                case 2:
                    DisplayProducts.displayProducts(products);
                    break;
                case 3:
                    UpdateProduct.updateProduct(products);
                    break;
                case 4:
                    DeleteProduct.deleteProduct(products);
                    break;
                case 5:
                    SearchProduct.searchProduct(products);
                    break;
                case 6:
                    System.out.println("Tổng số sản phẩm: " + products.size());
                    break;
                case 7:
                    DisplayProducts.displayProductsUnder100k(products);
                    break;
                case 8:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 8);

        saveProductsToFile();
    }

    private static void loadProductsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                products.add(Product.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc tệp: " + e.getMessage());
        }
    }

    private static void saveProductsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Product product : products) {
                writer.write(product.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi tệp: " + e.getMessage());
        }
    }
}
