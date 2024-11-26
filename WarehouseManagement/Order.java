public class Order {
    String orderId;
    String customerName;
    String productId;
    int quantity;
    String status;

    public Order(String orderId, String customerName, String productId, int quantity, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Đơn hàng [ID: " + orderId + ", Khách hàng: " + customerName + ", Sản phẩm: " + productId + ", Số lượng: " + quantity + ", Trạng thái: " + status + "]";
    }

    // Chuyển đối tượng đơn hàng thành chuỗi để lưu vào file
    public String toFileString() {
        return orderId + "," + customerName + "," + productId + "," + quantity + "," + status;
    }
}
