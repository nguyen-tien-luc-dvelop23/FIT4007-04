import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OrderUnder100k {
    public static void saveOrdersUnder100k(List<Product> products) {
        String filePath = "OrdersUnder100k.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Product product : products) {
                if (product.getPrice() < 100000) {
                    writer.write("Tên sản phẩm: " + product.getName() + ", Giá: " + product.getPrice() + " VND, Số lượng: " + product.getQuantity());
                    writer.newLine();
                }
            }
            System.out.println("Đã lưu các đơn hàng dưới 100 nghìn vào tệp " + filePath);
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu tệp: " + e.getMessage());
        }
    }
}
