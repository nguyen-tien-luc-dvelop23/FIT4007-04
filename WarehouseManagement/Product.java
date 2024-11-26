public class Product {
    String productName;
    String productId;
    double price;
    int quantity;
    String category;
    String supplier;

    public Product(String productName, String productId, double price, int quantity, String category, String supplier) {
        this.productName = productName;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Sản phẩm [Mã: " + productId + ", Tên: " + productName + ", Giá: " + price + ", Số lượng: " + quantity + "]";
    }
}
