public class Supplier {
    String name;
    String address;
    String products;

    public Supplier(String name, String address, String products) {
        this.name = name;
        this.address = address;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Nhà cung cấp [Tên: " + name + ", Địa chỉ: " + address + ", Mặt hàng: " + products + "]";
    }
}
